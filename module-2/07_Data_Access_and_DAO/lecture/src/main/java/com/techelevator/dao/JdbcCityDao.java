package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
// concrete class for the CityDao
// typically named JdbcTableNameDao - not required you follow the naming conventions

// concrete class contains the implementation processing for the dao.

public class JdbcCityDao implements CityDao { // uses the dao interface

    // instance object for accessing the JDBCTemplate framework
    private final JdbcTemplate jdbcTemplate; // does not have to be final

    // class constructor - receives the datasource and will connect to it
    //                  class       object
    public JdbcCityDao(DataSource theDataSource) {
        this.jdbcTemplate = new JdbcTemplate(theDataSource);
    }

    @Override
    public City getCity(int cityId) { // get a row from the city table for the city id specified
        // instansiate the object to be returned
        City cityFromTable = null; // initialize to default not found value
        // define a string to hold the SQL statement we want to execute
        // using ? to represent variables from the program in the SQL statement
        // ? is known as a parameter marker(marks the place for a parameter)
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE city_id = ?;"; // where the city id column in the table = a program variable

        // Instansiate an SqlRowSet object to have the result from the queryForRowSet() method
        // SqlRowSet is an JDBC class to hold the resulting rows from a query
        // queryForRowSet will take an sQL string and a list of program variables
        //                       and replace the ? in the sql string with teh values in the program variables
        //                          and send the SQL string to the database manager
        //                          and store the rows that come back in an sqlRowSet object
        //                                        SQLString, program-variables for ?
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId); // value in the cityID variable
                                                                    //  will replace the first ?
                                                                        // in the SQL string
        // we need to convert the results from the SQL statement SQL rowset
        // to a java object(since java only speaks java objects)

        // loop through set of rows that the result of the select brings back
        //      call a method to map the result row to a java object

        // the sql results object contains the results from the query and a pointer to the current result
        // initially the pointer is set Before the row in the result

        //                     <-------- pointer to the current result
        // results =
        // 41, columbus, OH
        // 23 plano tx
        // 496 san diego ca
        // 12 phoenix az

        // results.next() position in the sqlresults to get the next row in the result
        if (results.next()) {// loop while we get positioned to a result row in the sql results
            cityFromTable = mapRowToCity(results); // call a method to create an object from result row
        }
        // return the object insantiated as the return object
        return cityFromTable;
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

    // create city object from the row we are positioned at in the SQLRowSet
    private City mapRowToCity(SqlRowSet rowSet) {
        //instantiate object to be returned
        City city = new City(); // default/empty object

        // extract column data from the table row and assign it to the object using the setter
        // SQLrowsetobject.getDataType(Column name)
        city.setCityId(rowSet.getInt("city_id")); // get int value of city id columb
        city.setCityName(rowSet.getString("city_name"));
        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        city.setPopulation(rowSet.getInt("population"));
        city.setArea(rowSet.getDouble("area"));

        // return objected filled with data from the row
        return city;
    }
}
