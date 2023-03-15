package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.List;

// This is a DAO interface for JDBC access
// Define the CRUD methods required for access using this DAO
//   Create  -- SQL INSERT
//   Read    -- SQL SELECT
//   Update  -- SQL UPDATE
//   Delete  -- SQL DELETE
// Typically named: tableNameDao (you can name it whatever you want)

public interface CityDao {


// Read a City from the table by cityId, return a City object
//  return
//  type  method(parameters)
    City  getCity(int cityId);   // Read a City from the table by cityId, return a City object

    // Return a List of City objects for a particular stateAbbreviation
    List<City> getCitiesByState(String stateAbbreviation);

    // Insert a row in the City table from the City object provided, return the City object
    City createCity(City city);

    // Update a row in the City table using the values provided in a City object it is given
    // Note: use of a City object rather than a list of individual values
    //       void updateCity(int cityId, String cityName, double area...);
    // Use of a list of values is NOT object oriented programming
    // In object oriented programming objects are used for most processing
    void updateCity(City city);

    // delete a row from the City table usng the cityID given
    //     (not an object oriented coding style)
    // void deleteCity(City city) - object oriented approach
    //                              an City containing the cityId to be deleted
    void deleteCity(int cityId);
}
