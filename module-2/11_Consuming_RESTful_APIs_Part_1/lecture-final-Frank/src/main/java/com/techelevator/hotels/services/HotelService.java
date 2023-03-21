package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

// This will use RESTful API calls to get data from a server when requested

// REST is current protocol for interacting with server
// (REST replaced SOAP as a server protocol)
// a protocol is a set runs to communicate between components of an app

public class HotelService {

    // Set a constant for the server name part of the URL (optional)
    private static final String API_BASE_URL = "http://localhost:3000/";

    // RestTemplate a framework for making and managing RESTful API call
    private final RestTemplate theApiServer = new RestTemplate();

    // return an array of all the hotels from API server

    public Hotel[] listHotels() {

        // we need to get all the hotels from the API server
        // the server has resource path: http://localhost:3000/hotels
        // to return all the Hotels (tested it in Postman and it worked)

        // getForObjects() will take a server URL path and issue an HTTP GET request with i
        //                           and the class of objects to be returned
        //
        //                 will automatically convert the JSON returned from the HTTP request
        //                 into the class od objects specified.
        //
        // getForObject() can return an array of objects (cannot a List, ArrayList or any other Java structure)
        //                if you need a Java structure like an ArrayList YOU must convert the array returned
        //
        // RestTemplate is expecting a POJO exists for class specified for the returned object
        // A POJO has standard getters and setters and either a default constructor or no constructors
        // (it uses the default constructor and setters to create object from the JSON)

        //                               server-URL-path      , class-of-returned-object
        return theApiServer.getForObject(API_BASE_URL+"hotels", Hotel[].class);
    }

    // Get all the reviews from API server and return them as an array of Reviews
    public Review[] listReviews() {
        return theApiServer.getForObject(API_BASE_URL+"reviews", Review[].class);
    }

    // Get all the information for a specific hotel from API server and return the Hotel
    //
    // Server resource path is:  http://localhost:3000/hotels/:id

    public Hotel getHotelById(int id) {
        //                               server-URL-path      , class-of-returned-object
        return theApiServer.getForObject("http://localhost:3000/hotels/"+id, Hotel.class);
    }

    public Review[] getReviewsByHotelId(int hotelId) {
        return null;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return null;
    }

    public City getWithCustomQuery(){
        return null;
    }

}
