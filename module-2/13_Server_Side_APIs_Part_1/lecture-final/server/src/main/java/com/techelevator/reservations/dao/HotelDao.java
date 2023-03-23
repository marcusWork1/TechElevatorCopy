package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    // Return all hotels in the data source as a List of Hotels
    List<Hotel> list();

    // Return all the hotels in the data source for a given state and city
    List<Hotel> getFilteredList(String state, String city);

    // Add a hotel to the data source given a Hotel object
    void create(Hotel hotel);

    // Return the Hotel with the given id
    Hotel get(int id);

}