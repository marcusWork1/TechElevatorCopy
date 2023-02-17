package com.techelevator;

import java.time.Year;

public class HomeworkAssignment {

    // create instance variables... don't forget to add getters and setters later
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade; // this string is derived from earnedMarks result

    // create constructor
    public HomeworkAssignment(int possibleMarks, String submitterName) {
        this.possibleMarks = possibleMarks;
        this.submitterName = submitterName;

    }

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public String getLetterGrade() {
        if (earnedMarks / possibleMarks >= (int) 90) {
            letterGrade = "A";
        }
        if (earnedMarks / possibleMarks < (int) 90 && earnedMarks >= (int) 80) {
            letterGrade = "B";
        }
        if (earnedMarks / possibleMarks < (int) 80 && earnedMarks >= (int) 70) {
            letterGrade = "C";
        }
        if (earnedMarks / possibleMarks < (int) 70 && earnedMarks >= (int) 60) {
            letterGrade = "D";
        }
        if (earnedMarks / possibleMarks < (int) 60) {
            letterGrade = "F";
        }
        return letterGrade;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    @Override
    public String toString() {
        return "HomeworkAssignment{" +
                "earnedMarks=" + earnedMarks +
                ", possibleMarks=" + possibleMarks +
                ", submitterName='" + submitterName + '\'' +
                ", letterGrade='" + letterGrade + '\'' +
                '}';
    }
}
        // end of class
