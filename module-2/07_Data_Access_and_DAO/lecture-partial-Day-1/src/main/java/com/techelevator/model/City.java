package com.techelevator.model;

// This is a POJO for rows in the City table in the UnitedStates database
//
// A POJO is a Java class that has at least:
//
//     1. a default constructor (actually optional but a great idea)
//     2. standard named getters/setters
//     3. recommended: toString() and equals()

public class City {  // class name is same as the table name

    // columns in the table are represented by instance variables in the class
    // variables don't have to match teh columns names,
    //       but it makes it easier if they do
    private int cityId;
    private String cityName;
    private String stateAbbreviation;
    private int population;
    private double area;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return String.format("%s, %s (ID: %d)", getCityName(), getStateAbbreviation(), getCityId());
    }
}
