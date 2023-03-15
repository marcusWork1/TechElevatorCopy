package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
// concrete class for the CityDao
// typically named JdbcTableNameDao - not required you follow the naming conventions
//
// The concrete class contains the implementation processing required by the DAO interface

public class JdbcCityDao implements CityDao { // use the DAO interface

    // instance object for accessing JDBCTemplate framework methods
    private final JdbcTemplate jdbcTemplate; // final is not required

    // Class constructor - receives the datasource and will connect to it
    //                  class      object
    public JdbcCityDao(DataSource theDataBaseWithOurTables) {
        this.jdbcTemplate = new JdbcTemplate(theDataBaseWithOurTables);
    }

    @Override
    public City getCity(int cityId) {  // get a row from City table for the cityId given
        // Instantiate the object to be returned
        City theCityFromTheTable = null;  // initialize to default not found value

        // Define a String to hold the SQL statement we want to execute
        //     Using ? to represent variables from the program in the SQL statement
        //      ? is known as a parameter marker (marks the place for a parameter)
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE city_id = ?;";  // WHERE the city_id column in the table = a program variable

        // Instantiate an SqlRowSet object to hold the result from the queryForRowSet() method
        // SqlRowSet is an JDBC class to hold the resulting rows from a query
        // queryForRowSet()  will take a SQL string and a list program variables
        //                   replace ? in the SQL string with the values in the program variables
        //                   send the SQL String to the database manager
        //                   store the rows that come back in an SqlRowSet object
        //                                           SQLString, program-variables for ?
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql   , cityId); // value in the cityID variable
                                                                         //   (passed in as parameters)
                                                                         //   will replace the first ?
                                                                         //   in the SQL string
        // We need to convert the results from the SQL statement SqlRowSet
        //    to a Java object (since only works with Java objects)
        //
        // Position at the first row in the result of the SELECT
        //      call a method to map the result row to a Java object
        //
        // the SqlResults object contains the results from the query
        //     and a pointer to the current result being processed
        // initially the pointer is set BEFORE the row in result
        //                                
        //                                   
        //    results:   41   Columbus  OH   <---- pointer to the current row in result
        //               23   Plano     TX
        //               496  San Diego CA                       
        //               12   Phoenix   AZ
        //
        // results.next() position the SqlResults to the next row in the row in the result
        if (results.next()) {     // if we are positioned to a result row in the SQLResults
            // mapRowToCity() is a helper method we wrote to create an object from an SQLRowSetObject
            //                it is passed teh result set with the pointer to the current row positioned 
            //                    at row to be used in creating the object
            //                the method name can be anything you want
            theCityFromTheTable = mapRowToCity(results); // call a method to create an object from the result row
        }
        // return the object instantiated as the return object
        return theCityFromTheTable;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        List<City> cities = new ArrayList<>();
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            cities.add(mapRowToCity(results));
        }
        return cities;
    }

    @Override
    public City createCity(City city) {
        String sql = "INSERT INTO city (city_name, state_abbreviation, population, area) " +
                     "VALUES (?, ?, ?, ?) RETURNING city_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());

        return getCity(newId);
    }

    @Override
    public void updateCity(City city) {
        String sql = "UPDATE city " +
                    "SET city_name = ?, state_abbreviation = ?, population = ?, area = ? " +
                    "WHERE city_id = ?;";
        jdbcTemplate.update(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(),
                city.getArea(), city.getCityId());
    }

    @Override
    public void deleteCity(int cityId) {
        String sql = "DELETE FROM city WHERE city_id = ?;";
        jdbcTemplate.update(sql, cityId);
    }


    // Create a City object from the row we are positioned at in the SQLRowSet
    private City mapRowToCity(SqlRowSet rowSet) {
        // Instantiate City object to be returned
        City city = new City();  // Default/Empty object

        // Extract column data from the table row and assign to City object using setters
        //    SqlRowSetObject.getDataType(column-name)
        city.setCityId(rowSet.getInt("city_id"));         // get the int value from the city_id column
        city.setCityName(rowSet.getString("city_name"));  // get the String value from the city_name column
        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        city.setPopulation(rowSet.getInt("population"));
        city.setArea(rowSet.getDouble("area"));

        // Return object filled in with data from the row
        return city;
    }
}
