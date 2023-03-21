package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;

public interface CityDao {

    // read a city from teh table by CityID return a city object
    City getCity(int cityId);

    // return a list of city objects for a particular state abbreviation
    List<City> getCitiesByState(String stateAbbreviation);

    // create a row in the city table from the city object provided, return the city object
    City createCity(City city);

    // update a row in teh city table using the values provided in a city object its given
    // note: use of a city object rather than a list of individual values
    // use of a list of values, is not object-oriented programming
    void updateCity(City city);

    // delete a row from the city table using the city id given
    // this is not an object oriented approach.
    // if it was, it would be void deleteCity(City city)
    void deleteCity(int cityId);
}
