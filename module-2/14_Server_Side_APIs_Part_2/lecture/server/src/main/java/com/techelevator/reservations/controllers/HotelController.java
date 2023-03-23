package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    // define references to DAO as instance variables
    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    // constructor should instantiate DAOS and assign to references
    //we are receiving the DAO's objects as parameters and assigning parameter to references
    // we do not have to instantiate the DAOS
    //
    // Spring will instantiate DAO s for us and pass them to the constructor
    // (dependency injection - something else instantiates objects needed and passes them to a constructor)


    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     * /hotels
     * /hotels?state=ohio
     * /hotels?state=ohio&city=cleveland
     *
     * @param state the state to filter by - optional query parameter
     * @param city  the city to filter by - optional query parameter
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity
    // required = false indicates it is an optional parameter
    (@RequestParam(required=false) String state, @RequestParam(required = false) String city) {
        // DAO does the filtering for us
        return hotelDao.getFilteredList(state, city);
    }

    /**
     * Return hotel information
     *
     * Throws a ResponseStatusException with a not_found status if hotel doesnt exist
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        Hotel hotel = hotelDao.get(id);
        if (hotel == null) {
            // Http Status is spring enum representing all possible valid HTTP status code
            //                                      HttpStatus code, message
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
    // for an http POST the data for the request is stored in the request body @requestBody
    // @request body tells Spring to take the data for the request out of the body and
    //                                                      create an object of the class given
    //                              The class must be a POJO(at least a default Ctor and getters/setters
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    // @RequestBody = take the data from the body
    //          and create a Reservation object called reservation
    public Reservation addReservation(@Valid @RequestBody Reservation reservation) {
        return reservationDao.create(reservation, reservation.getHotelId());
    }
    // update an existing reservation
    // @param reservation id
    // @param Reservation object with the new and old data
@RequestMapping(path = "/reservations/{id},", method = RequestMethod.PUT)
public Reservation updateTheReservation(@Valid @RequestBody Reservation theUpdateReservation,
                                        @PathVariable int id) {
        return reservationDao.update(theUpdateReservation, id);

        Reservation theChangedReservation;

        theChangedReservation = reservationDao.update(theUpdateReservation, id);
        if (theChangedReservation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation Id not found");
        }
        return theChangedReservation;
}


    
} // end of controller class