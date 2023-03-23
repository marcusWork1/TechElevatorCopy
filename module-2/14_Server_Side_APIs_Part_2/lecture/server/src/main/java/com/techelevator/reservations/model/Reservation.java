package com.techelevator.reservations.model;

// the class designer (class creator) decides how data is validated and what is valid

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

// spring bean validation annotations are used to indicate valid values
// spring will automatically validate data IF server tells it to
public class Reservation {

    private int id;
    @Min(value=1, message="The hotel id is required and must be 1 or more")
    private int hotelId;

    @NotBlank(message="full name is required for reservation")
    private String fullName;

    @NotBlank(message="check in date is required for reservation")
    private String checkinDate;

    @NotBlank(message="check out date is required for reservation")
    private String checkoutDate;

    @Min(value = 1, message="the number of guest must be greater than 1")
    @Max(value = 5, message = "the max guest number is 5")
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
