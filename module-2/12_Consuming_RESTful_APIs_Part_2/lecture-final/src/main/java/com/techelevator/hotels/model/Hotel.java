package com.techelevator.hotels.model;

// This POJO will hold data from the API call
//
// the variables names in the POJO MUST MATCH the attributes names in the JSON
//
// only have to define the variables in th POJO for JSON attributes you want


public class Hotel {

    private int id;              // name must match the JSON attribute name
    private String name;         // name must match the JSON attribute name
    private int stars;           // name must match the JSON attribute name
    private int roomsAvailable;  // name must match the JSON attribute name
    private String coverImage;   // name must match the JSON attribute name
    private String hotelOwner;   // OK to have instance variables that aren't in JSON

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name: " + name +
                "\n Stars: " + stars +
                "\n Rooms Available: " + roomsAvailable +
                "\n Cover Image: " + coverImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }
}
