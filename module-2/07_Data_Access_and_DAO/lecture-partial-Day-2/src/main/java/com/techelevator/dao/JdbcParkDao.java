package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    // Used to interact with the JBDC-DAO Framework
    private final JdbcTemplate theDatabase;


    // Constructor receives a data source and instantiate the JdbcTemplate for the datasource
    public JdbcParkDao(DataSource dataSource) {
        this.theDatabase = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {
        // Instantiate a Part to return
        Park aPark = new Park();  // Create a default Park

        // Define a String with the SQL statement
        //  Be sure to add a space after each thing coded on a line if you concatenate multiple lines
        String sql = "select park_id, park_name, date_established, area, has_Camping " +
                     "from park " +
                     "where park_id = ? ";

        // Send the String with the SQL statement to database
        //    storing the result in SqlRowSet

        SqlRowSet parkResults = theDatabase.queryForRowSet(sql, parkId);

        // extract the data from SQL result into our Park return object
        //    using the mapRowToPark() method

        // If at least one row came back from the SQL query
        if(parkResults.next()) {
           aPark= mapRowToPark(parkResults);  // populate the Park return object with the row data
        }

        // Return the new Park object populated with teh data from the table
        return aPark;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        // Define an object to be return - a list of parks
        List<Park> bunchOfParks = new ArrayList<>();

        // Define SQL statement with ? for program variable values
        String sql = "select park_id " +
                "from park_state " +
                "where state_abbreviation= ? ";

        // send sql statement to data base manager
        SqlRowSet stateAbbreviationResults = theDatabase.queryForRowSet(sql, stateAbbreviation);

        // as long as we have rows in the result
        while(stateAbbreviationResults.next()) {
            //    create a park - from the park_id we got from the park_state table
            //                    using the getPark() method
            Park jamesNewPark = getPark(stateAbbreviationResults.getInt("park_id"));
            //    add it to our list
            bunchOfParks.add(jamesNewPark);
        }
        // return list of parks
        return bunchOfParks;
    }

    @Override
    public Park createPark(Park park) {
        return new Park();
    }

    @Override
    public void updatePark(Park park) {

    }

    @Override
    public void deletePark(int parkId) {

    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {

    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {

    }

    // Create a new Park object and populate it with data from SQL results
    private Park mapRowToPark(SqlRowSet rowSet) {
        // define the PArk object to be returned
        Park newPark = new Park();   // Create a new empty object

        // extract the data from the table row columns and populate the object using the setters
        newPark.setParkId(rowSet.getInt("park_id")); // put the park_id column value in the park_id of object
        newPark.setArea(rowSet.getDouble("area"));
        // In the object we have LocalDate object, the column has a Date object
        //        we can use toLocalDate() method of getDate() to convert Date to LocalDate
        newPark.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        newPark.setParkName(rowSet.getString("park_name"));
        newPark.setHasCamping(rowSet.getBoolean("has_camping"));

        return newPark;
    }
}
