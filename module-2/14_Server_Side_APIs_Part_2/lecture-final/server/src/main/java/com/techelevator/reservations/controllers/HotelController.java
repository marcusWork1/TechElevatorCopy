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

    // Define references to DAO as instance variables
    private HotelDao       hotelDao;
    private ReservationDao reservationDao;

    // The constructor should instantiate the DAOs and assign to the references
    // This constructor is accepting the DAO objects as parameters and assigning parameter to references
    //    (we do not have to instantiate the DAOs)
    //
    // Spring will instantiate the DAOs for us and pass them to the constructor
    //     (dependency injection - something else instantiates objects needed and passes them to a constructor)
    //
    // When Spring sees a constructor it looks to see if any of the parameters to the constructor
    //            should be dependency injected (@Component is specified any class that implements the interface)

    public HotelController(HotelDao hotelDao, ReservationDao reservationDao) {
        this.hotelDao       = hotelDao;
        this.reservationDao = reservationDao;
    }

    /**
     * /hotels
     * /hotels?state=ohio
     * /hotels?state=ohio&city=cleveland
     *
     * @param state the state to filter by  - optional query parameter
     * @param city  the city to filter by   - optional query parameter
     * @return a list of hotels that match the city & state
     */
    // required=false indicates teh query parameter is optional
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam(required=false) String state
                                           ,@RequestParam(required=false) String city) {
        // The DAO does the filtering for us
        // If the DAO does not do filtering for you, the controller has to do
        return hotelDao.getFilteredList(state, city);
    }

    /**
     * Return hotel information
     *
     * throws a ResponseStatusException with a NOT_FOUND status
     *     if hotel requested does not exist
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        Hotel hotel = hotelDao.get(id);
        if (hotel == null) {
            // HttpStatus is Spring enum representing all possible valid HTTP status code
            //                                 HTTP-Status-Code   , message
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
    // For an HTTP POST the data for the request is stored in the request body
    // @RequestBody tells Spring to take the data for the request out of the body
    //              and create and object of the class given
    //              the class must be a POJO (at least a default constructor & standard named getters/setters)
    //              Spring uses the default constructor to create the object and setters to populate it

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reservations", method = RequestMethod.POST)
    // @RequestBody - take the data from the body
    //                and create a Reservation object called aHotelReservation
    //
    // @Valid tells server apply any validation annotations in the POJO to that JSON
    //        data as it is used to populate the object
    public Reservation addReservation(@Valid @RequestBody Reservation aHotelReservation) {
        return reservationDao.create(aHotelReservation, aHotelReservation.getHotelId());
    }

    /**
     * Update an existing reservation
     *
     * @param reservation id   -  path variable
     * @param Reservation object with the new (and old) data - Request Body
     *
     * throw a ResponseStatusException if a non-existing reservation is passed
     *
     * ACCEPTED status returned if successful
     */
    // HTTP Request: PUT
    // Data to be used: request Body and path variable
    // Does Bean validation exist and do we want to use it?
    // DAO method:  Reservation update(Reservation reservation, int id);
    // What errors can occur and How do we want to handle errors?
    // What HTTP Status back do send back if successful? (200 OK is the default)
    // Path to the controller: /reservations/{id}  where {id} the reservation to update

    // Send back the accepted status code if successful
    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path="/reservations/{id}", method=RequestMethod.PUT)
    public Reservation updateTheReservation(@Valid @RequestBody Reservation theUpdateReservation,
                                            @PathVariable int id) {
        Reservation theChangedReservation;

        theChangedReservation = reservationDao.update(theUpdateReservation, id);
        if (theChangedReservation == null) {  // if DAO did not do the update
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation Id="+id + " Not Found");
        }
        // If the update was successful
        return theChangedReservation;
    }

    /**
     * Delete an existing reservation
     *
     * @param reservation id   -  path variable
     *
     * OK status returned if successful
     */
    // HTTP Request: DELETE
    // Data to be used: path variable (HTTP DELETE or GET has no data in the body)
    // Does Bean validation exist and do we want to use it?  n/a
    // DAO method:    void delete(int id);
    // What errors can occur and How do we want to handle errors?
    // What HTTP Status back do send back if successful? (200 OK is the default)
    // Path to the controller: /reservations/{id}  where {id} the reservation to update

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/reservations/{id}", method=RequestMethod.DELETE)
    public void removeReservation(@PathVariable int id){
        // Since the DAO methods gives us no indication of success or failure
        //       we cannot handle deleting a non-existing reservation
        reservationDao.delete(id);
    }

}  // End of controller class