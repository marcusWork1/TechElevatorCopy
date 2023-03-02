package com.techelevator.Bowling;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BowlingLeague {
    // create attributes
    private String leagueName;

    // store set of bowlers by team
    //team is key,
    // set of bowlers is value

    private Map<Integer, List<BowlingClass>> leagueMembers;

    public BowlingLeague(String leagueName, Map leagueMembers) {
        leagueName = null;
        leagueMembers = null;
    } // end of default constructor

    // 2 arg ctor - receive a leagueName and fileName
    // load the file into league members
    // initialize data members
    // failure ot initialize objects that data members are a common cause of null pointer exceptions

    public BowlingLeague(String leagueName, String nameOfFile) throws FileNotFoundException {
        // when a parameter has the same name as the data member
        // use this. to indicate the data member in the object
        this.leagueName = leagueName;
        leagueMembers = new HashMap<Integer, List<BowlingClass>>();

        // load teh file into league members Map
        // use a "helper method" in the class to load the file
        // loading a file into an object is a lot of code
        // using a helper method allows us to keep this method relatively easy to follow
        // if a method is larger than one screen or seems big, consider breaking up into smaller methods
        // general rule of thumb^

        loadFileIntoLeagueMembers(nameOfFile); // call helper method to load the file

        } // end of 2 arg ctor

        // helper method to load file
    public void loadFileIntoLeagueMembers(String fileName) throws FileNotFoundException {
        // define a file object for the file
        // define a Scanner object using file object
        // loop as long as the file has a line to read
        // get a line from the file inside the loop
        // break the line from the file into values
        // Store the values into the receiving object
        // close the file

        //define a file object
        File theFile = new File(fileName);

        // define a Scanner object using file object
        Scanner diskFile = new Scanner(theFile);

        // loop as long as the file has a line to read
        while (diskFile.hasNextLine()) {
            // get a line from the file
            String aLine = diskFile.nextLine();

            // break the line from the file into values

            String[] lineValues = aLine.split(",");
            // [0],[1], [2],              [3],    [4],    [5]
            // 1,   1,  Fred Flintstone,  230,    228,    229


            // store the values into the receiving object
            // define variables to hold the values in the line
            int teamNumber = Integer.parseInt(lineValues[0]);
            int bowerNumber = Integer.parseInt(lineValues [1]);
            String bowlerName = lineValues[2];
            int score1 = Integer.parseInt(lineValues[3]);
            int score2 = Integer.parseInt(lineValues[4]);
            int score3 = Integer.parseInt(lineValues[5]);

            // define a bowler to add to the map
            BowlingClass aNewBowler = new BowlingClass(bowlerName, bowerNumber, teamNumber, Arrays.asList(score1, score2, score3));

            // add bowler to map

            leagueMembers.put(teamNumber,aNewBowler);
        }// end of while loop
        // close the file
        diskFile.close();




    } // end of helper method


}// end of class
