package com.techelevator;


public class HomeworkAssignment {

    // create instance variables... don't forget to add getters and setters later
    private int earnedMarks;
    private int possibleMarks; //
    private String submitterName;
    private String letterGrade; // this string is derived from earnedMarks result. earned/possible

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
        if ((this.earnedMarks * 100) / this.possibleMarks >= 90) {
            return "A";
        }
        if ((this.earnedMarks * 100) / this.possibleMarks >= 80) {
            return "B";
        }
        if ((this.earnedMarks * 100) / this.possibleMarks >= 70) {
            return "C";
        }
        if ((this.earnedMarks * 100) / this.possibleMarks >= 60) {
            return "D";
        } else if ((this.earnedMarks * 100) / this.possibleMarks < 60) {

        }
        return "F";
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
