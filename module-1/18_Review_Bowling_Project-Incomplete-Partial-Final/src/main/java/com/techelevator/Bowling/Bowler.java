package com.techelevator.Bowling;

import java.util.List;
import java.util.Objects;

public class Bowler {

    /****************************************************************
     * Define references to the member data
     * (initialization of references occurs in the constructor)
     ****************************************************************/

    private int teamNumber;
    private int bowlerNumber;
    private String bowlerName;
    private List<Integer> bowlerscores;

    /*******************************************************************
    * Constructors - initialize member data when object is instantiated
    *******************************************************************/
    public Bowler(int teamNumber, int bowlerNumber, String bowlerName, List<Integer> bowlerscores) {
        this.teamNumber = teamNumber;
        this.bowlerNumber = bowlerNumber;
        this.bowlerName = bowlerName;
        this.bowlerscores = bowlerscores;
    }
    /**************************************************************************
     * Getters and setters - allow controlled access to data
     *                       from outside the class
     *
     * Getter - allows those outside the class to see the value in an attribute
     *
     * Setter - allows those outside the class to change a value in an attribute
     *
     * You do not need to provide getters and setters if app doesn't need them
     ***************************************************************************/
    public int getTeamNumber() {
        return teamNumber;
    }
    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }
    public int getBowlerNumber() {
        return bowlerNumber;
    }
    public void setBowlerNumber(int bowlerNumber) {
        this.bowlerNumber = bowlerNumber;
    }
    public String getBowlerName() {
        return bowlerName;
    }
    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }
    public List<Integer> getBowlerscores() {
        return bowlerscores;
    }
    public void setBowlerscores(List<Integer> bowlerscores) {
        this.bowlerscores = bowlerscores;
    }
    /***************************************************************************
     * Overrides to standard Object methods (equals, toString, clone, hashCode)
     *
     * Overrides to super class methods whose behaviors you to change
     ***************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bowler)) return false;
        Bowler bowler = (Bowler) o;
        return getTeamNumber() == bowler.getTeamNumber() && getBowlerNumber() == bowler.getBowlerNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeamNumber(), getBowlerNumber());
    }

    @Override
    public String toString() {
        return "Bowler{" +
                "teamNumber=" + teamNumber +
                ", bowlerNumber=" + bowlerNumber +
                ", bowlerName='" + bowlerName + '\'' +
                ", bowlerscores=" + bowlerscores +
                '}';
    }
    /***************************************************************************
     * Additional methods for the class
     *
     *     derived values
     *     helper methods (used by the class to do work)
     *     display object
     *     additional processing
     ***************************************************************************/

    /**
     * Calculate the total of all the scores
     *   derived value - name starts with get; looks a getter to the user
     *                   a value that appears to user as a stored value
     *                    (because it has a getter)
     *
     * Receives no parameters
     *
     * @return - the sum of the scores
     */
    public int getTotalScore() {
        // define a variable/object to hold return/result
        int totalOfTheScores = 0;

        // go through the list of bowlers and add them up
        //  scores is a List - use a for or for-each
        for(int i=0; i<bowlerscores.size(); i++) {
            totalOfTheScores += bowlerscores.get(i); // totalOfTheScores = totalOfTheScores + bowlerscores.get(i);
        }
        // to do same thing in for-each
        // for(int aScore : bowlerScores) {
        //    totalOfTheScores += aScores; // totalOfTheScores = totalOfTheScores + bowlerscores.get(i)
        // }
        // return the variable/object holding result
        return totalOfTheScores;
    }
    /**
     * Calculate the average of all the scores
     *   derived value - name starts with get; looks a getter to the user
     *                   a value that appears to user as a stored value
     *                    (because it has a getter)
     *
     * Receives no parameters
     *
     * @return - the average of the scores
     */
    public double getAverage() {
        // Define a variable to hold return value
        double theAverage = 0.0;
        // divide the total of scores by the number of scores
        theAverage = getTotalScore() / bowlerscores.size();

        // return the variable with the result
        return theAverage;
    }
} // end of Bowler Class
