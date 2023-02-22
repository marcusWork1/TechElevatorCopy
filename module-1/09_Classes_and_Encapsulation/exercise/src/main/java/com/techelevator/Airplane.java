package com.techelevator;

import java.util.Objects;

public class Airplane {
    private String planeNumber;		//		The six-character plane number.
    private int totalFirstClassSeats;		//		The total number of first class seats.
    private int bookedFirstClassSeats;	//		The number of already booked first class seats.
    private int availableFirstClassSeats; //(derived)	int	X		The number of available first class seats.
    private int totalCoachSeats;	//intX		The total number of coach seats.
    private int bookedCoachSeats;	//int			The number of already booked coach seats.
    private int availableCoachSeats; //(derived)

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
      availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        return availableFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return availableCoachSeats;
    }

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
    this.planeNumber = planeNumber;
    this.totalCoachSeats = totalCoachSeats;
    this.totalFirstClassSeats = totalFirstClassSeats;
}
 public boolean reserveSeats ( boolean forFirstClass, int totalNumberOfSeats) {
     if (forFirstClass && getAvailableFirstClassSeats() >= totalNumberOfSeats) {
         bookedFirstClassSeats += totalNumberOfSeats;
         availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
         return true;
     }
     if (!forFirstClass && getAvailableCoachSeats()>= totalNumberOfSeats) {
         bookedCoachSeats += totalNumberOfSeats;
         availableCoachSeats = totalCoachSeats - bookedCoachSeats;
         return true;
     } else return false;
 }

    @Override
    public String toString() {
        return "Airplane{" +
                "planeNumber='" + planeNumber + '\'' +
                ", totalFirstClassSeats=" + totalFirstClassSeats +
                ", bookedFirstClassSeats=" + bookedFirstClassSeats +
                ", availableFirstClassSeats=" + availableFirstClassSeats +
                ", totalCoachSeats=" + totalCoachSeats +
                ", bookedCoachSeats=" + bookedCoachSeats +
                ", availableCoachSeats=" + availableCoachSeats +
                '}';
    }
} // end of class


