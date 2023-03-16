package com.techelevator.dao;

import com.techelevator.model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

// This class inherit the data and methods from the superclass
// in this case the Datasource and a rollback() method
// this was done to be sure all tests use teh same Datasource and are able to rollback()

public class JdbcCityDaoTests extends BaseDaoTests {

    // Set up City object we can use in the tests
    // Note: this match the cities inserted at start of testing by the configuration file
    private static final City CITY_1 = new City(1, "City 1", "AA", 11,111);
    private static final City CITY_2 = new City(2, "City 2", "BB", 22,222);
    private static final City CITY_4 = new City(4, "City 4", "AA", 44,444);

    private City testCity;

    // Instantiate an object represents the class with the methods to be tested
    // We want to test methods in the JdbcCityDao, so we instantiate a JdbcCitObject
    private JdbcCityDao systemUnderTest;  // reference to the class with the methods to test

    // add a City to the database before each test
    @Before
    public void setup() {
        // sut is common name for the object
        systemUnderTest = new JdbcCityDao(dataSource); // Instantiate the JdbcDAO with a datasource
        testCity = new City(0, "Test City", "CC", 99, 999);
    }

    // This test suite/file is testing the following methods:
    //
    //   getCity()
    //   getCitiesByState()
    //   createCity()
    //   updateCity()
    //   deleteCity()

    // @Test indicates the method that follows is a test
    // method names for tests should be descriptive
    // a typical method name: method-being_tested_return_expectation_parameter
    @Test
    // this test is testing the getCity() to be sure
    //                        it returns the correct City object for a give city_id
    public void getCity_returns_correct_city_for_id() {
        // method being tested:
        //      City getCity(int cityId);
        // identify what it receives: a cityId
        // identify what it returns: a City object
        // What it does:
        //     Looks in the database for the cityId given
        //           and returns it or null if the not found in the database
        // What we want to test: Does it return a city that is in the database
        // What do we need to test: a city_id that is in the database

        // Arrange - set up the dat afor the test
        int cityIdInDatabase = 1;

        // Act - run the method with the test data using object for the class for methods to test
        City city = systemUnderTest.getCity(cityIdInDatabase);

        // Assert - did we get the result expected
        // We are using a helper method (see below) to do the JUnit asserts
        // JUnit has no idea how to determine if two City objects match
        // Compare a known City to the returned from the method
        // CITY_1 is defined as instance variable for the class
        assertCitiesMatch(CITY_1, city);

        city = systemUnderTest.getCity(2);
        assertCitiesMatch(CITY_2, city);
    }

    @Test
    public void getCity_returns_null_when_id_not_found() {
        // method being tested:
        //      City getCity(int cityId);
        // identify what it receives: a cityId
        // identify what it returns: a City object
        // What it does:
        //     Looks in the database for the cityId given
        //           and returns it or null if the not found in the database
        // What is needed to test: cityId that is not in the database
        //                         because we are testing for it not found
        // What we want to test: Does it return null if city not in data base

        // Arrange - define any data needed in the test
        int nonExistantCity = 99;

        // Act - run the method with the test data and save result
        City city = systemUnderTest.getCity(nonExistantCity);

        // Assert - test to see if the result is what was expected
        Assert.assertNull(city);
    }

    @Test
    public void getCitiesByState_returns_all_cities_for_state() {
        // List<City> getCitiesByState(String stateAbbreviation);
        // Expecting: Two cities with state abbreviation 'AA' (see test data loaded for tests)
        //            CITY_1 and CITY_4 (see test data and constants defined for the class)

        // Test for multiple City returns
        List<City> cities = systemUnderTest.getCitiesByState("AA");

        // When a List is returned from a method, typically test for:
        Assert.assertEquals(2, cities.size());      // The correct number of elements in the list
        assertCitiesMatch(CITY_1, cities.get(0));   // List contains the expected elements
        assertCitiesMatch(CITY_4, cities.get(1));   // List contains the expected elements

        // Test for exact one City returned
        cities = systemUnderTest.getCitiesByState("BB");
        Assert.assertEquals(1, cities.size());     // Check size of list returned
        assertCitiesMatch(CITY_2, cities.get(0));  // check element(s) returned
    }

    @Test
    public void getCitiesByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<City> cities = systemUnderTest.getCitiesByState("XX");
        Assert.assertEquals(0, cities.size());
    }

    @Test
    public void createCity_returns_city_with_id_and_expected_values() {
        // Test to see if an Insert to a table was successful

        // Have a new created in the table
        // the createCity() method returns teh City it was passed
        //       with the city_id generated by the system

        // Act - have a testCity added to the database
        //       we inserted testCity with city_id of 0
        City createdCity = systemUnderTest.createCity(testCity);
        // Get city_if of the object returned from create
        Integer newId = createdCity.getCityId();
        // verify the city_id is now greater than 0 - system generate a new one
        Assert.assertTrue(newId > 0);

        // Set the city_id in the test city to the city_id generated by the system
        testCity.setCityId(newId);
        // verify the City returned from the method matches the testCity we sent
        assertCitiesMatch(testCity, createdCity);
    }

    @Test
    public void created_city_has_expected_values_when_retrieved() {
        City createdCity = systemUnderTest.createCity(testCity);

        Integer newId = createdCity.getCityId();
        City retrievedCity = systemUnderTest.getCity(newId);

        assertCitiesMatch(createdCity, retrievedCity);
    }

    @Test
    public void updated_city_has_expected_values_when_retrieved() {
        //  Arrange
        // get a row from the database
        City cityToUpdate = systemUnderTest.getCity(1);

        // update values in the object holding a row from the database
        cityToUpdate.setCityName("Updated");
        cityToUpdate.setStateAbbreviation("CC");
        cityToUpdate.setPopulation(99);
        cityToUpdate.setArea(999);

        // Act - do the update with the new data
        systemUnderTest.updateCity(cityToUpdate);

        // Assert - Retrieve the row again
        City retrievedCity = systemUnderTest.getCity(1);
        // verify the object from the row in the table match the object you sent for update
        assertCitiesMatch(cityToUpdate, retrievedCity);
    }

    @Test
    public void deleted_city_cant_be_retrieved() {
        // Act - Delete any existing row
        systemUnderTest.deleteCity(4);

        // try to get the row you just deleted
        City retrievedCity = systemUnderTest.getCity(4);
        // if nothing was returned you delete worked
        Assert.assertNull(retrievedCity);

        // verify the number of rows for matching data is reduced by number of rows deleted
        List<City> cities = systemUnderTest.getCitiesByState("AA");
        Assert.assertEquals(1, cities.size());
        assertCitiesMatch(CITY_1, cities.get(0));
    }

    //*******************************************************************************
    // Helper methods to assist in the testing
    //
    // no @Test before the method - not a test it's a helper
    // private rather than public to limit access to tests in this class
    //*******************************************************************************

    // Since JUnit does not know how to determine if two cities match
    // we provide a helper method to do
    //                             expected City, City from the test
    private void assertCitiesMatch(City expected, City actual) {
        // Using JUnit AssertEquals to verify each attribute in the two cities match
        Assert.assertEquals(expected.getCityId(), actual.getCityId());
        Assert.assertEquals(expected.getCityName(), actual.getCityName());
        Assert.assertEquals(expected.getStateAbbreviation(), actual.getStateAbbreviation());
        Assert.assertEquals(expected.getPopulation(), actual.getPopulation());

        // when double data is used in Java there can be issues with precision
        //      when converting the internal binary value to a decimal value
        //     instead of seeing .50 you might .4999999999999991
        // When testing using assertEquals for double, a fudge factor can be given
        //      to for discrepancy
        // fudge-factor says as long as the values are no more than this much apart, they match
        //                                                      fudge-factor
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
    }
}
