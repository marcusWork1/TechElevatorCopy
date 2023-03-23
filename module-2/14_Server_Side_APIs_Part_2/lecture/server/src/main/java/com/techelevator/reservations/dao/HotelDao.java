package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    // Return a List of all hotels
    List<Hotel> list();

    // Given a state and city, return a List of hotels in that state and city
    // Given just a state, return a List if hotels in that state
    // Given just a city, return a list if hotels in cities with that name
    // Given neither city nor state, return all hotels
    List<Hotel> getFilteredList(String state, String city);

    // Given a Hotel object, add the Hotel to the data source
    void create(Hotel hotel);

    // Given a hotel id, return the Hotel matching that id
    Hotel get(int id);

}