package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// A controller handles HTTP requests from external sources (programs/Postman)
//
// A typical server controller will receive a request, C.R.U.D. the data using DAOs
//                  and send back a response with any data requested
//
// A controller has very little logic or looping
//
// Controllers are part of the MVC design pattern for structuring server applications
//
// MVC stands for Model-View-Controller
//
//    Model - data for an application (Java POJO and DAOs)
//    View  - User interface - How data  is displayed and acquired from a user
//                             (CLI - Command Line Interface) or Web Interface (Browser))
//    Controller - Coordinate the transfer of data from the Model to/from the View
//                 (server)
//
// In this application:
//
//    Model - Java POJOs and DAOs
//    View  - Handled by the client side of the application
//    Controller - receives requests via API calls from client
//                 find any data requested by the request using DAOs
//                 send back the data with a response


@RestController // Tells server this class has controllers to handle RESTful HTTP requests
                // The controllers need to be in the same base package as the server
public class HotelController {

    // Defined references to any DAOs used by the controlled in this class
    private HotelDao       hotelDao;
    private ReservationDao reservationDao;

    // constructor for class containing servers instantiate DAOs and assign them to their references
    public HotelController() {
        this.hotelDao       = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    // @RequestMapping tells the server which URL path and HTTP request this method will handle
    // The following method will handle any HTTP request with the path /hotels
    //
    // The server will convert the return object to JSON in the response automagically
    //                 create the response object (header and et al) for the response
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> anythingYouWantToCallTheMethod() { // Controller method name is never used
        System.out.println("GET for /hotels was received"); // Logging the request
        return hotelDao.list();  // Call the DAO that gets all the Hotels and return them
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     *
     *
     * Handle HTTP GET requests for the path /hotels/{id}
     *       {id} indicates a data value will be in its place
     *       {id} is called a path variables (hold data in the path)
     *
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    // @PathVariable assigns a name and a data type to the path variable
    // Path variables are always Strings, the server will convert it from String the data type of variable
    public Hotel get(@PathVariable int id) {  // name used here just match the name in the ~@RequestMapping for teh variable
        System.out.println("GET for /hotels/" + id + " was received"); // Logging the request
        return hotelDao.get(id);  // Call the DAO method to get info about the hotel with id specified
    }

    // Create a controller to handle sending back all reservations from the data source
    //
    // What type of HTTP Request will be used: GET
    //
    // Is there a DAO that will give us the data we need?
    //           yep it's: List<Reservation> findAll();
    //
    // What path do we want the request to use to tell us they want all the reservations for all hotels?
    //         /bryansreservervations
    //
    // Do we need any additional to get the data requested?
    //        No

    // Tell the server the HTTP request type and path we are handling
    @RequestMapping(path="/bryansreservervations", method=RequestMethod.GET)
    // Write the method signature for the method to do the work
    public List<Reservation> pickAName() {
        System.out.println("GET for /bryansreservervations was received"); // Logging the request
        // define the object to be returned
        List<Reservation> theReservations = null;

        // Call the DAO to get the data we need to return
        theReservations = reservationDao.findAll();

        // return the object containing the data to be returned
        return theReservations;
    }

    // Create a controller to handle sending back all hotels for particular city and state
    //
    // What type of HTTP Request will be used: GET
    //
    // Is there a DAO that will give us the data we need?
    //           yep it's: List<Hotel> getFilteredList(String state, String city);
    //
    // What path do we want the request to use to tell us they want all the reservations for all hotels?
    //         /searchCityState
    //
    // Do we need any additional to get the data requested?
    //       yes! State and City to be used in the search
    //
    //       Use path variables:       /searchCityState/{city}/{state}
    //          -or-
    //       Use query parameters:     /searchCityState?city=value&state=value
    //          -or-
    //       Use combination of both:  /searchCityState/{state}?city=value

    // Tell the server the HTTP request type and path we are handling
    @RequestMapping(path="/searchCityState", method=RequestMethod.GET)
    // Write the method signature for the method to do the work
    // @RequestParam() identifies query parameters to be extracted from URL and stored in a Java variable
    //    Java variable name should match the query parameter name, server will convert data if needed
    public List<Hotel> whateverYouWantToCallThis(@RequestParam String state, @RequestParam String city) {
        System.out.println("GET for /searchCityState/?state=" + state + "&city=" + city +" was received"); // Logging the request
        List<Hotel> hotelsToReturn = null;
        hotelsToReturn = hotelDao.getFilteredList(state, city);
        return hotelsToReturn;
    //  return hotelDao.getFilteredList(state, city);  // alternate coding style
    }

    // Write a version of the above code using a path variable for state and query parm for city
    // Tell the server the HTTP request type and path we are handling
    @RequestMapping(path="/searchCityState/{state}", method=RequestMethod.GET)
    // Write the method signature for the method to do the work
    // @RequestParam() identifies query parameters to be extracted from URL and stored in a Java variable
    //    Java variable name should match the query parameter name, server will convert data if needed
    // @PathVariable assigns a name and a data type to the path variable
    //    Java variable name should match the path variable name, server will convert data if needed

    // handle the path: /searchCityState/{state}?city=value
    public List<Hotel> anotherName(@PathVariable String state, @RequestParam String city) {
        System.out.println("GET for /searchCityState/?state=" + state + "&city=" + city +" was received"); // Logging the request
        List<Hotel> hotelsToReturn = null;
        hotelsToReturn = hotelDao.getFilteredList(state, city);
        return hotelsToReturn;
        //  return hotelDao.getFilteredList(state, city);  // alternate coding style
    }

    // Write a version of the above code using a path variable for both state and city
    // Tell the server the HTTP request type and path we are handling
    @RequestMapping(path="/searchCityState/{state}/{city}", method=RequestMethod.GET)
    // Write the method signature for the method to do the work
    // @RequestParam() identifies query parameters to be extracted from URL and stored in a Java variable
    //    Java variable name should match the query parameter name, server will convert data if needed
    // @PathVariable assigns a name and a data type to the path variable
    //    Java variable name should match the path variable name, server will convert data if needed

    // handle the path: /searchCityState/{state}/{city}
    public List<Hotel> stillAnotherName(@PathVariable String state, @PathVariable String city) {
        System.out.println("GET for /searchCityState/?state=" + state + "&city=" + city +" was received"); // Logging the request
        List<Hotel> hotelsToReturn = null;
        hotelsToReturn = hotelDao.getFilteredList(state, city);
        return hotelsToReturn;
        //  return hotelDao.getFilteredList(state, city);  // alternate coding style
    }


} // end of the class that holds controllers
