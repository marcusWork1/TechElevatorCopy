package com.techelevator.reservations.model;

// The class designer (whoever creates the class) decides what valid data means
//
// Spring Bean Validation Annotations are used to indicate valid values for data
// Validation annotation precedes the instance variable to which it applies

// Spring will automatically validate the data IF THE SERVER TELLS IT TO

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Reservation {

    private int id;
    @Min(value=1, message="The hotel id is required and must be 1 or more")
    private int hotelId;

    @NotBlank(message="full name is required for a reservation")
    private String fullName;

    //  Require m/d/yy and mm/dd/yyyy
    //          allowing any combination of one or two digits for the day and month
    //          and two or four digits for the year:
    @Pattern(regexp="^(1[0-2]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])/(?:[0-9]{2})?[0-9]{2}$")
    private String checkinDate;

    //  Require m/d/yy and mm/dd/yyyy
    //          allowing any combination of one or two digits for the day and month
    //          and two or four digits for the year:
    @Pattern(regexp="^(1[0-2]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])/(?:[0-9]{2})?[0-9]{2}$")
    private String checkoutDate;

    @Min(value=1, message="the minimum number of guests is 1")
    @Max(value=5, message="the maximum number of guests is 5")
    private int guests;

    public Reservation(int id, int hotelId, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelId = hotelId;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelId
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
