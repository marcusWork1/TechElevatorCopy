package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;


public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate theApiServer  = new RestTemplate();
    private final ConsoleService notifyUser  = new ConsoleService();

    /**
     * Create a new reservation in the hotel reservation system
     *
     * We need to do an HTTP POST request to server
     *
     * An HTTP POST request expects the data its using to be in the request body
     */
    //       this method receives a Reservation object with the data to be added to the server
    //                   returns the Reservation that was added
    //                          (it will now contain the system generated Reservation Id)
    public Reservation addReservation(Reservation newReservation) {
        // TODONE: Implement method

        // Define the object to be returned so we don't change the Reservation passed to us
        Reservation theReservationAdded = null;

        // the data to be added/inserted into the server resource
        //    must be placed in the body of the HTTP POST request
        //
        // Need an Entity header for the request the describes teh data in the request body
        //      to include the Entity header with the request
        //      to include the data to be add with the request

        // Define a HTTP general header to be included with the request
        HttpHeaders theRequestHeader = new HttpHeaders();

        // Set the type of data we are sending the server to JSON
        // Set the Content type to MediaType.APPLICATON_JSON
        // Also tell RestTemplate to convert your Java Object to JSON when placing in request body
        theRequestHeader.setContentType(MediaType.APPLICATION_JSON);
        HttpHeaders anotherHeader = new HttpHeaders();

        // Add an Entity header to request to connect the data with the header
        // This also causes RestTemplate to convert the object to JSON and put it in the request body

        //        <data-type-for-data-structure>
        //    List<String>
        //     Map<Integer, String>
        HttpEntity<Reservation> anEntityHeader = new HttpEntity<>(newReservation, theRequestHeader);

        // Send the request to the server to add the object to the resource
        //
        // postForObject(server-url-path, entity, class-of-object-to-be-returned)
        //
        // API_BASE_URL: http://localhost:3000/
        //     URL Path: http://localhost:3000/reservations

        theReservationAdded = theApiServer.postForObject(API_BASE_URL + "reservations", anEntityHeader, Reservation.class);

       // return the object created in the method
        return theReservationAdded;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new
     * reservation
     *
     * Do an HTTP PUT request
     *
     * http://localhost:3000/reservations/{id}   {id} means put reservation to be updated
     *
     * HTTP PUT requires updated data be in the body of the request
     */
    public boolean updateReservation(Reservation updatedReservation) {
        // TODONE: Implement method

        boolean didUpdateWork = false;

        HttpHeaders aHeader = new HttpHeaders();
        aHeader.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Reservation> anEntity = new HttpEntity<>(updatedReservation, aHeader);

        //         http://localhost:3000/reservations/{id}   {id} means put reservation to be updated
       try {
           theApiServer.put(API_BASE_URL + "reservations/" + updatedReservation.getId(), anEntity);
           didUpdateWork = true; // if no exception happened, assume the update worked
       } catch (RestClientResponseException exceptionObject) {  // if there is a response error display status code and message
           BasicLogger.log(exceptionObject.getRawStatusCode() + exceptionObject.getStatusText());
           notifyUser.printErrorMessage();
         }
	     catch (ResourceAccessException exceptionObject) {
           didUpdateWork = false;

           BasicLogger.log(exceptionObject.getMessage());  // if there is an error access the data resource
           notifyUser.printErrorMessage();
        }
       return didUpdateWork;
    }

    /**
     * Delete an existing reservation
     *
     * Do an HTTP DELETE
     *
     * HTTP DELETE does not require dats in the body, so not header or entity is required
     */
    public boolean deleteReservation(int id) {
        // TODONE: Implement method
        boolean didDeleteWork = false;

        // http://localhost:3000/reservations/{id}   {id} means the id of  the resource to delete
        try {
            theApiServer.delete(API_BASE_URL + "reservations/" + id);
            didDeleteWork = true;  // if no exception, assume delete worked
        } catch (RestClientResponseException exceptionObject) {  // if there is a response error display status code and message
            BasicLogger.log(exceptionObject.getRawStatusCode() + exceptionObject.getStatusText());
            notifyUser.printErrorMessage();
        } catch (ResourceAccessException exceptionObject) {
            didDeleteWork=false;  // if there is an error access the data resource
            BasicLogger.log(exceptionObject.getMessage());
            notifyUser.printErrorMessage();
        }
        return didDeleteWork;
    }

    /* DON'T MODIFY ANY METHODS BELOW */
    /* DON'T MODIFY ANY METHODS BELOW */
    /* DON'T MODIFY ANY METHODS BELOW */
    /* DON'T MODIFY ANY METHODS BELOW */

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        // Define the return object outside the try block
        //    because we use it outside the try black
        Hotel[] hotels = null;  // hold the data from the API call
                                // getForObjects() only returns an array
        try {
            //                                      api-URL           . class-to-be-returned
           hotels = theApiServer.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        } catch (RestClientResponseException e) {
            // handles exceptions thrown by rest template and contains status codes
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            // i/o error, ex: the server isn't running
            BasicLogger.log(e.getMessage());
        }
        return hotels;
    }

    /**
     * List all reservations in the hotel reservation system
     */
    public Reservation[] listReservations() {
        Reservation[] reservations = null;
        try {
            reservations = theApiServer.getForObject(API_BASE_URL + "reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * List all reservations by hotel id.
     */
    public Reservation[] listReservationsByHotel(int hotelId) {
        Reservation[] reservations = null;
        try {
            reservations = theApiServer.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservations;
    }

    /**
     * Find a single reservation by the reservationId
     */
    public Reservation getReservation(int reservationId) {
        Reservation reservation = null;
        try {
            reservation = theApiServer.getForObject(API_BASE_URL + "reservations/" + reservationId, Reservation.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

}