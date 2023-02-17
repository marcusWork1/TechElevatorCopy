package com.techelevator;

// this class represents our generic playing card

// public indicates anyone can use this class (instantiate objects of the class)

public class PlayingCard {
    // a class contains the data and methods available in the class

    // we have identified the following characteristics of a playing card

    // value - attribute, aka something it is aka variable or object
    // suit - attribute aka variable or object
    // color - attribute, variable, object

    // face up or not - behavior. might or might not be

    // data for a class is an attribute

    // provide data members of the class
    // access type, dataType, name


    // method members of the class


    private String suit;
    private int value;
    private String color;
    private boolean faceUp;

    // create constructor, same name as class, no return type
    // if class is public, usually constructor is public
// constructor is going to be "public" or "private" with no void or datatype
    public PlayingCard() {
        value  = 1;
        suit   = "Spades";
        color  = "Black";
        faceUp = true;
    }
    // define parameters in constructor for all attributes
    public PlayingCard(int aValue, String aSuit, String aColor, boolean faceUp) {
        //this. references a name in the class. only required if data name matches the parameter names like faceUp^.
        //always use this. regardless to avoid confusion
        this.value = aValue;
        this.suit = aSuit;
        this.color = aColor;
        this.faceUp = faceUp;
    }

    // Getters and setters allow access to private data from outside the class


    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "suit='" + suit + '\'' +
                ", value=" + value +
                ", color='" + color + '\'' +
                ", faceUp=" + faceUp +
                '}';
    }






} // end of PlayingCard class
