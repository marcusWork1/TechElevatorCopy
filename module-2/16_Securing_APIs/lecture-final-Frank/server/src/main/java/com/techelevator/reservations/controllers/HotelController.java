package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

// Two user roles for this system:
//      ROLE_USER   - normal every day user or the app
//      ROLE_ADMIN  - Higher that user, responsible for "important stuff"


// This controller handles all requests for the Hotel resource
//
//   who's
//   allowed to-do-this
//   anyone  Create - addReservation
//   anyone  Read   - filterByStateCity, get, listReservations, listHotels, ListReservationsByHotel
//   anyone  Update - updateReservation
//   admin   Delete - deleteReservation
//
// Use SpEl to establish access to the paths



// In order to access any process in this class, a user must be logged in
@PreAuthorize("isAuthenticated()")
@RestController
public class HotelController {

    private HotelDao       hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao       = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

 /**
     * /hotels
     * /hotels?state=ohio
     * /hotels?state=ohio&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam(required=false) String state, @RequestParam(required = false) String city) {
        return hotelDao.getFilteredList(state, city);
    }


    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        Hotel hotel = hotelDao.get(id);
        if (hotel == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found.");
        } else {
            return hotel;
        }
    }

    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @RequestMapping(path = "/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservations() {
        return reservationDao.findAll();
    }

    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     */
    @RequestMapping(path = "reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservation(@PathVariable int id) {
        Reservation reservation = reservationDao.get(id);
        if (reservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found.");
        } else {
            return reservation;
        }
    }

    /**
     * List of reservations by hotel
     *
     * @param hotelId
     * @return all reservations for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}/reservations", method = RequestMethod.GET)
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) {
        List<Reservation> reservations = reservationDao.findByHotel(hotelId);
        if (reservations == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel not found.");
        } else {
            return reservations;
        }
    }

    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    public Reservation addReservation(@Valid @RequestBody Reservation reservation) {
        return reservationDao.create(reservation, reservation.getHotelId());
    }

    /**
     * Updates a reservation
     *
     * @param reservation
     * @param id
     * @return the updated Reservation
     */
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.PUT)
    public Reservation update(@Valid @RequestBody Reservation reservation, @PathVariable int id) {
        Reservation updatedReservation = reservationDao.update(reservation, id);
        if (updatedReservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found.");
        } else {
            return updatedReservation;
        }
    }

    /**
     * Delete a reservation by id
     *
     * restricted to those in ROLE_ADMIN
     *
     * @param id
     */
    // Only those with "ROLE_ADMIN" can access this path
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/reservations/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        reservationDao.delete(id);
    }

    /**
     * Used to log operations
     * 
     * @param operation
     * @param reservation
     * @param username
     */
    private void auditLog(String operation, int reservation, String username) {
        System.out.println(
                "User: " + username + " performed the operation: " + operation + " on reservation: " + reservation);
    }

}
