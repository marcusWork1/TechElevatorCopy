package com.techelevator;

public class Airplane {
    private String planeNumber;		//		The six-character plane number.
    private int totalFirstClassSeats;		//		The total number of first class seats.
    private int bookedFirstClassSeats;	//		The number of already booked first class seats.
    private int availableFirstClassSeats; //(derived)	int	X		The number of available first class seats.
    private int totalCoachSeats;	//intX		The total number of coach seats.
    private int bookedCoachSeats;	//int			The number of already booked coach seats.
    private int availableCoachSeats; //(derived)


    protected Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {

        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;

        availableFirstClassSeats=totalFirstClassSeats;
        availableCoachSeats=totalCoachSeats;
    }


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
        return availableFirstClassSeats;
    }


    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }


    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }


    public int getAvailableCoachSeats() {
        return availableCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass , int  totalNumberOfSeats) {

        if(forFirstClass && getAvailableFirstClassSeats()>=totalNumberOfSeats)
        {
            bookedFirstClassSeats+=totalNumberOfSeats;
            availableFirstClassSeats=totalFirstClassSeats-bookedFirstClassSeats;
            return true;
        }
        else if(!forFirstClass && getAvailableCoachSeats()>=totalNumberOfSeats){
            bookedCoachSeats+=totalNumberOfSeats;
            availableCoachSeats=totalCoachSeats-bookedCoachSeats;
            return true;
        }

        else
            return false;


    }


}
