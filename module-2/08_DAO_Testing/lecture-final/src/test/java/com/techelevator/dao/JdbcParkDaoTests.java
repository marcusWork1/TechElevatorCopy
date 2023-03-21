package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao systemUnderTest;

    @Before
    public void setup() {
        systemUnderTest = new JdbcParkDao(dataSource);
    }

//    Look at DAO Interface to see what methods should be tested.
//
//        Park getPark(int parkId);
//        List<Park> getParksByState(String stateAbbreviation);
//        Park createPark(Park park);
//        void updatePark(Park park);
//        void deletePark(int parkId);
//        void addParkToState(int parkId, String stateAbbreviation);
//        void removeParkFromState(int parkId, String stateAbbreviation);
//
//    Pick a method to test
//        Park getPark(int parkId);
//
//                What does it receive? a parkID
//                What does it return? a Park object
//
//    What is it supposed to do? Look at documentation, comments or code for the method.
//         return the Park for park_id given or null if park_id not in database
//
//    Determine what we need to test it:
//         park_id for an existing Park
//         park_id for non-existing Park
//
//    How do we do the test?
//
//       1. Try to find an existing Park in the database and verify we got a Park object
//       2. Try to find a non-existing Park and verify we got null back
//

    @Test
    public void getPark_returns_correct_park_for_id() {
    // Try to find an existing Park in the database and verify we got a Park object

        // Arrange - set up data needed for the test
        int existingParkId = 2;  // Look at data inserted for test

        // Act - run the method with the test data
        Park parkFromDatabase = systemUnderTest.getPark(existingParkId);

        // Assert - verify the expected result was returned by method
        //          see if teh object coming back from the table matches
        //             the object we set up for class (see top)
        //          we need a helper method since JUnit doesn't know our Park objects
        //          (given below)
        assertParksMatch(PARK_2, parkFromDatabase);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        // Arrange
        int nonExistingPark = 0;

        //Act
        Park parkFromDatabase = systemUnderTest.getPark(nonExistingPark);

        //Assert
        Assert.assertNull(parkFromDatabase);
    };

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        Assert.fail();
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        Assert.fail();
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Assert.fail();
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        Assert.fail();
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        Assert.fail();
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        Assert.fail();
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
