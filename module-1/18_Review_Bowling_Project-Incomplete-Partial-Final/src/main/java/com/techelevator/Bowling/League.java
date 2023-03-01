package com.techelevator.Bowling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class League {

    private String leagueName;

    // Store set of Bowlers by team
    //    key   - team number
    //    value - set of Bowlers
    //      Map<key-type, value-type>
    private Map<Integer, List<Bowler>> leaguemembers;

    // Since we want a default and non-standard ctors
    //     IntelliJ cannot generate them

    // Default constructor - initialize with default values
    public League() {
        leaguemembers = null;
        leagueName    = null;
    } // end of default ctor

    // 2-arg constructor - receive league-name and file-name
    //   load the file into the league members
    //   Initialize data members
    //   Failure to initialize objects that data members are a common cause of NullPointerExceptions
    public League(String leagueName, String nameOfFile2Load) throws FileNotFoundException {
        // when a parameter has the same name as the data member
        // use this. to indicate the data member in the object
        this.leagueName = leagueName;  // Assign the object league name the value in the parameter league name
        leaguemembers = new HashMap<Integer, List<Bowler>>();

        // load the file into leagueMembers Map
        // use a "helper method" in the class to actually load the file into leagueMembers
        //     loading a file into an object is several, if not, alot of code
        //     using a helper method allows us to keep this method relatively easy to understand
        //     as a general rule of thumb, if a method is larger than 1 screen (or just seems big)
        //     consider breaking up into several helper methods

        loadFileIntoLeagueMembers(nameOfFile2Load);   // call the helper method to load the file

    }  // end of 2-arg ctor

    // Helper method to load file
    public void loadFileIntoLeagueMembers(String fileName) throws FileNotFoundException {
        // Define a File object for the file
        // Define a Scanner object using the file object
        // Loop as long as the file has a line to read
        //   Get a line from the file
        //   Break the line from the file into values
        //   Store the values into the receiving object
        // Close the file

        // Define a File object for the file
        File theFile = new File(fileName);

        // Define a Scanner object using the file object
        Scanner diskFile = new Scanner(theFile);

        // Loop as long as the file has a line to read
        while(diskFile.hasNextLine()) {
            String aLine = diskFile.nextLine();       //   Get a line from the file
            String[] valuesInLine = aLine.split(","); //   Break the line from the file into values based on ","
            //  [0]  [1]    [2]             [3]     [4]   [5]
            //   1,   1,  Fred Flintstone,  230,   228,   229

            //   Store the values into the receiving object
            // Define variables to hold the values in the line
            int teamNumber    = Integer.parseInt(valuesInLine[0]);   // convert the team #from a String to int
            int bowlerNumber  = Integer.parseInt(valuesInLine[1]);   // convert the bowler # from a String to int
            String bowlerName = valuesInLine[2];
            int score1        = Integer.parseInt(valuesInLine[3]);
            int score2        = Integer.parseInt(valuesInLine[4]);
            int score3        = Integer.parseInt(valuesInLine[5]);

            // Define a Bowler to add to the Map
            Bowler aNewBowler = new Bowler(teamNumber
                                         , bowlerNumber
                                         , bowlerName
                                         , Arrays.asList(score1, score2, score3));

            // Add the Bowler to the Map
            // ********* This process is incomplete right now ************
            leaguemembers.put(teamNumber,aNewBowler);

        }  // End of while() loop
        // Close the file
        diskFile.close();

        }  // End of loadFile method

} // end of league class
