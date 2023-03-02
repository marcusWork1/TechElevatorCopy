package com.techelevator.Bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BowlingClass {

    // create attributes or references
    private String bowlerName;
    private int bowlerNumber;
    private int teamNumber;
    // created arraylist because bowling scores can be duplicated and we'd like to manipulate the list easily
    private List<Integer> scores;


    // create constructor to initialize the references/attributes
    public BowlingClass ( String bowlerName, int bowlerNumber, int teamNumber, List scores) {
        this.bowlerName = bowlerName;
        this.bowlerNumber = bowlerNumber;
        this.teamNumber = teamNumber;
        this.scores = scores;
    }

    //create getters and setters.... these allow controlled access to data from outside the class
    // getter allow those outside to see the value in an attribute
    // setters allow those outside the class ot change the value in an attribute

    public String getBowlerName() {
        return bowlerName;
    }

    public void setBowlerName(String bowlerName) {
        this.bowlerName = bowlerName;
    }

    public int getBowlerNumber() {
        return bowlerNumber;
    }

    public void setBowlerNumber(int bowlerNumber) {
        this.bowlerNumber = bowlerNumber;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
// equals and toString override methods

    @Override
    public String toString() {
        return "BowlingClass{" +
                "bowlerName='" + bowlerName + '\'' +
                ", bowlerNumber=" + bowlerNumber +
                ", teamNumber=" + teamNumber +
                ", scores=" + scores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BowlingClass that = (BowlingClass) o;
        return bowlerNumber == that.bowlerNumber && teamNumber == that.teamNumber && Objects.equals(bowlerName, that.bowlerName) && Objects.equals(scores, that.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bowlerName, bowlerNumber, teamNumber, scores);
    }

    // additional methods for the class
    ///     derived values
    //      or helper methods (used by the class to do work)
    //      or display object
    //      or additional processing

    /**
    // Calculate the total of all scores and then average them
    // (derived value) - name starts with get and looks like a getter ot the user
    // recieves no parameters
    //
    // @return the sum of the scores
     */
    public int getTotalScore() {
        // define variable to hold return/result
       int sumOfScores = 0;
        for(int i = 0; i < scores.size(); i++ ) {
            sumOfScores += scores.get(i);
        } return sumOfScores;
        // same thing in for-each
        // for(int i : scores) {
            // sumOfScores += i;
        // return sumOfScores; }
        }
    public double getAverageScores() {
        double averageScore = 0.0;
        averageScore = getTotalScore() / scores.size();
        return averageScore;
    }


} // end of class
