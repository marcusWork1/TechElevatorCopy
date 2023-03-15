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
        // results.next() position the SqlResults to the next row in the row in the result
        //                                
        //
        //    results:   41   Columbus  OH   <---- pointer to the current row in result
        //               23   Plano     TX
        //               496  San Diego CA
        //               12   Phoenix   AZ
        //

        // 'if' used because we know there is only one row in the result (city_id is primary key of table)
        // 'while()' would have been OK too
        if (results.next()) {     // if we are positioned to a result row in the SQLResults
            // mapRowToCity() is a helper method we wrote to create an object from an SQLRowSetObject
            //                it is passed the result set with the pointer to the current row positioned
            //                    at row to be used in creating the object
            //                the method name can be anything you want
            theCityFromTheTable = mapRowToCity(results); // call a method to create an object from the result row
        }
        // return the object instantiated as the return object
        return theCityFromTheTable;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        // Return all the rows that are in the result of the SQL query

        // Define object we are returning
        List<City> cities = new ArrayList<>();

        // Set up the SQL String to be run in the database manager
        //     using '?' where you want program variables substituted/used
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE state_abbreviation = ?;";  // use the state abbreviation received as parameters

        // send the sql to database manager with the program variable(s) for the query
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        // loop through the result set to create the list to be returned
        // 'while()' used as there may be multiple rows in the result of the SELECT
        while (results.next()) {
            //City aCity = mapRowToCity(results);  // define a City object and populate with data from a row
            //cities.add(aCity);                   // add City object to list
            cities.add(mapRowToCity(results));     // create a object from the current row and add to list
        }
        // return object from the method
        return cities;
    }

    @Override
    public City createCity(City city) {
        // Add a Java object to the database - extract the values from object for use in the SQL INSERT

        // Define a String with the SQL INSERT statement to be run
        //     using '?' where you want to have program variables substituted
        // DO NOT include columns with system generated values (serial, DEFAULT)
        // Typically in an INSERT the VALUES clause contains all '?'
        //      one '?' for each program variable you want to use to insert data
        //
        // Use the object passed in's getter to extract the values from the object
        //
        // the optional RETURNING option on the INSERT tells SQL to return the value in the column specified
        // city_id is a system generated value (serial) and it's the primary key of the table
        // since it's system generated we don't know what value it has
        //      we can ask the INSERT to tell us what value was assigned using RETURNING option
        // We need to tell the method the class to assign to the value from the RETURNING

        //   Note: city_id column is not included in the INSERT as it is system generated
        String sql = "INSERT INTO city (city_name, state_abbreviation, population, area) " +
                     "          VALUES (   ?     ,       ?           ,     ?     ,   ? ) RETURNING city_id;";
        // Note use of queryForObject() instead of queryForRowSet() used for SELECT
        // queryForObject() returns an object of the class specified in the second parameters

        //                                     SQL-String, class-of-object-to-be-returned(cannot be a primitive)

        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,   // return an Integer class object
                city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());
        //        first '?' value , second '?' value           , third '?' value     , fourth '?' value

        // the newId object defined above will contain the system generated value for city_id

        return getCity(newId);  // return the City object for the row just added to the table
                                //     using the system generated value for city_id returned from the INSERT
    }

    @Override
    // Note: an object containing the values to be used in the update is passed in
    //       NOT individual values (Object Oriented Programming - use objects whenever possible)
    //
    //  Supposed a table row has 20 different updatable values
    //      requiring an object with the values to be changed and those unchanged
    //                means you only need one method that accepts an object
    //      defining update methods that use individual values
    //               means you might need as many as 20 methods
    //
    // Application programs using this method must send an object with all the values populated
    //     even the ones that haven't changed.
    public void updateCity(City city) {
        // Update row(s) in a table with values from an Object
        // we must extract the values from the object (using getters) to do the update

        // Define a String to hold the SQL statement using '?' for value from program variables
        String sql = "UPDATE city " +
                    "SET city_name = ?, state_abbreviation = ?, population = ?, area = ? " +
                    "WHERE city_id = ?;";

        // Send the SQL string to the database manager with the program variables with the values we want
        jdbcTemplate.update(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(),
                city.getArea(), city.getCityId());
    }

    @Override
    public void deleteCity(int cityId) {
        // delete a row from table using the primary key value(s) passed in

        // Define a String to hold SQL statement using '?' where you want program variables
        String sql = "DELETE FROM city WHERE city_id = ?;";

        // Send the SQL String to the database manager with the program variables with values you want
        // Note: use the update() method to do a delete
        jdbcTemplate.update(sql, cityId);  // 'update' implies a change to the database (includes removing a row)
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
