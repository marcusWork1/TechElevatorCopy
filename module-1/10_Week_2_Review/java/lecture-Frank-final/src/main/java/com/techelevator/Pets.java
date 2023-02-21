package com.techelevator;

import java.util.Objects;

public class Pets {

    // data members

    private int    legs;
    private String name;
    private String type;
    private String owner;
    private String breed;

    // methods

    // constructor(s) - initialize data in the class

    public Pets() {} // We added this in case Java needs it

    // IntelliJ generated the basic constructor
    public Pets(int legs, String name, String type, String owner, String breed) {
        this.legs = legs;
        this.name = name;
        this.type = type;
        this.owner = owner;
        this.breed = breed;
    }

    // getters / setters - control/allow access to private data in the class

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // overrides - modify the behavior of ancestor methods you want to change

    @Override
    public String toString() {
        return "Pets{" +
                "legs=" + legs +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", owner='" + owner + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return legs == pets.legs && Objects.equals(name, pets.name) && Objects.equals(type, pets.type) && Objects.equals(owner, pets.owner) && Objects.equals(breed, pets.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legs, name, type, owner, breed);
    }

    // helper methods - provide additional processing for class


}
