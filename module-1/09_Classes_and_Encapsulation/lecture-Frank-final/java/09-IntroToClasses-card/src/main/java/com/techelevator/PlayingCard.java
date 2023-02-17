package com.techelevator;

// This class represent a our generic PlayingCard
//
// A class is used to instantiate objects of the class
//

// public indicates anyone can use this class (instantiate objects of the class)
public class PlayingCard {
    // A class contains the data and methods available in the class
    //
    // A class is programmer defined data type.
    // A class may be used anywhere Java allow a datatype to be used.
    //
    // The creator/owner of class is responsible for the data and methods in the class
    // The creator/owner decides the data and methods in the class and
    //                               who can access them
    //
    // A variable or an object should be initialized when its defined to avoid potential errors
    //
    // The class must initialize its data members when an object of class is instantiated
    // constructor methods are used in a class to initialize the data when object is instantiated
    //
    // The data in a class is sometimes referred to as the state of the class
    //   (the current values in the data of the class is the state of the class)
    // The methods in a class define its behavior
    //
    // We have identified the following characteristics of a PlayingCard:
    //
    //  value (attribute    - variable or an object in the class)
    //  suit  (attribute)   - variable or an object in the class)
    //  color (attribute)   - variable or an object in the class)
    //  face-up (attribute) - variable or an object in the class)
    //  indicate face-up or not (behavior - method in the class)
    //
    // The data for a class is sometimes referred to as attributes of the class
    //
    // Anything defined in a class is called a member of the class
    //
    // A class contains member attributes (variable or objects)
    //                  member methods

    //************************************************************************************
    // Data members of the class
    //************************************************************************************

    // member data is class is defined:
    //
    //      access-type   data-type name;
    //
    //      access-type - who can access the data
    //                    private - only members of the class can access the data
    //                    public  - anyone with an object of the class can access data
    //
    //    private is used to enforce/implement encapsulation
    //    encapsulation means protect the data from access outside the class

    //        Human value:     A                     J  Q  K
    private int     value;  // 1,2,3,4,5,6,7,8,9,10,11,12,13
    private String  suit;
    private String  color;
    private boolean faceUp; // attribute to hold whether face up or not


    //************************************************************************************
    // method members of the class
    //************************************************************************************

    //-----------------------------------------------------------------------------------
    // Constructors (ctor) - initialize objects of the class when instantiated
    //-----------------------------------------------------------------------------------
    //
    // Constructors (ctor) are special methods in a class:
    //   1. Have same name as the class
    //   2. Cannot return a value (not even void)
    //   3. Take parameters used to initialize an object
    //      (a constructor with no parameters is called: default constructor
    //   4. Usually public (if the class is public, ctors should be public)
    //
    // A class should always have at least a default constructor
    //
    // If a default constructor is not provided, Java runs its own default constructor
    // The Java default ctor sets numerics to 0 and objects to null, boolean=false
    //
    // If any ctor is defined for a class, it MUST define a default ctor (Java default ctor won't run)

    // Define a default card:  value=1, suit="Spades", color="Black", faceUp=true
    public PlayingCard() {  // default ctor / 0-arg ctor
        value  = 1;
        suit   = "Spades";
        color  = "Black";
        faceUp = true;
    }

    // Define a ctor that lets the user specify all the attributes
    // Define parameters to the ctor for all the attributes you want user to be able to specific
    public PlayingCard(int aValue, String aSuit, String aColor, boolean faceUp){
    //  this. references a name in the class
    //  member   parameter
    //  data   = data
        this.value  = aValue;  // Set the attribute to what was sent in the parameter
        this.suit   = aSuit;   // Set the attribute to what was sent in the parameter
        this.color  = aColor;  // Set the attribute to what was sent in the parameter
        // if the name of the parameter is the same as the name data member
        //    code this. in front of the member data name to indicate its the member data
        this.faceUp = faceUp;  // Set the attribute to what was sent in the parameter
    }
    //-----------------------------------------------------------------------------------
    // Getters and Setters - Allow access to private data from outside the class
    //                       Encapsulation requires member data to be private
    //                       Access to member data is controlled by class methods
    //                       No one outside the class has direct access to member data
    //-----------------------------------------------------------------------------------
    //
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
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
    
    //-----------------------------------------------------------------------------------
    // Other methods provided by class
    //-----------------------------------------------------------------------------------
    public String toString() {
        return "PlayingCard{" +
                "value=" + value +
                ", suit='" + suit + '\'' +
                ", color='" + color + '\'' +
                ", faceUp=" + faceUp +
                '}';
    }

} // end of PlayingCard class
