package com.techelevator.reservations.dao;

import java.util.List;

import com.techelevator.reservations.model.Reservation;

public interface ReservationDao {

    // Return a List of all reservations in the data source
    List<Reservation> findAll();

    // Given a hotel id, return a List of reservations for the hotel
    List<Reservation> findByHotel(int hotelId);

    // Given a reservation id, return a Reservation object for the reservation
    Reservation get(int reservationId);

    // Given a Reservation and a hotel id,
    //     add the reservation for the hotel to the data source
    // Return the Reservation added to the data source
    Reservation create(Reservation reservation, int hotelId);

    // Given a Reservation object and a reservation id,
    //      update the reservation with the matching reservation id
    //      using the Reservation object given
    // Return the updated reservation from the data source
    Reservation update(Reservation reservation, int id);


    // Given a reservation id, delete the reservation with that id
    void delete(int id);

}