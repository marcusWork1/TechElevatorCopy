package com.techelevator.hotels.services;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Reservation;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();

    // Hold the JWT from the login
    private String authToken = null;

    // Set the authToken to JWT token passed in by the App
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * Create a new reservation in the hotel reservation system
     */
    public Reservation addReservation(Reservation newReservation) {
        Reservation returnedReservation = null;

        //TODO: Add implementation
        BasicLogger.log("HotelService.addReservation() has not been implemented");

        return returnedReservation;
    }

    /**
     * Updates an existing reservation by replacing the old one with a new reservation
     */
    public boolean updateReservation(Reservation updatedReservation) {
        boolean success = false;
        try {
            restTemplate.put(API_BASE_URL + "reservations/" + updatedReservation.getId(),
                    makeReservationEntity(updatedReservation));
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    /**
     * Delete an existing reservation
     *
     * Only allowed by those with admin role
     *
     * We need to provide an Authorization header with the request containing our JWT
     *
     * a JWT contains: user, role, expiration-time-stamp
     *
     */
    public boolean deleteReservation(int id) {
        boolean success = false;

        // Helper makeAuthEntity() creates an Authorization header with JWT
        try {
            // .exchange() RestTemplate method cn be used with HTTP Request
            restTemplate.exchange(API_BASE_URL + "reservations/" + id, HttpMethod.DELETE,
                    makeAuthEntity(), Void.class);  // Void.class indicates no data returned
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    /**
     * List all hotels in the system
     */
    public Hotel[] listHotels() {
        Hotel[] hotels = null;
        try {
            ResponseEntity<Hotel[]> response = restTemplate.exchange(API_BASE_URL + "hotels", HttpMethod.GET,
                            makeAuthEntity(), Hotel[].class);
            hotels = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
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
            ResponseEntity<Reservation[]> response = restTemplate.exchange(API_BASE_URL + "reservations",
                    HttpMethod.GET, makeAuthEntity(), Reservation[].class);
            reservations = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
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
            ResponseEntity<Reservation[]> response =
                    restTemplate.exchange(API_BASE_URL + "hotels/" + hotelId + "/reservations",
                            HttpMethod.GET, makeAuthEntity(), Reservation[].class);
            reservations = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
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
            ResponseEntity<Reservation> response =
                    restTemplate.exchange(API_BASE_URL + "reservations/" + reservationId,
                            HttpMethod.GET, makeAuthEntity(), Reservation.class);
            reservation = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return reservation;
    }

    /**
     * Creates a new HttpEntity with the `Authorization: Bearer:` header and a reservation request body
     *
     * Used for an HTTP request with data in the body (POST or PUT)
     *
     * Sets two values in the header:  CONTENT_TYPE and BEAREr
     */
    private HttpEntity<Reservation> makeReservationEntity(Reservation reservation) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // type of data in the body
        headers.setBearerAuth(authToken);                   // JWT
        return new HttpEntity<>(reservation, headers);
    }

    /**
     * Returns an HttpEntity with the `Authorization: Bearer:` header
     *
     * Used when an HTTP request with no data in the body is issued (GET or DELETE)
     *
     * Create an HTTP Authorization Header with the save JWT
     *
     * returns an Entity that return nothing (void) in the response body
     */
    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();  // Create an HTTP Header
        headers.setBearerAuth(authToken);         // Set the Authorization Bearer to the JWT
        return new HttpEntity<>(headers);         // Return the header
    }

}
