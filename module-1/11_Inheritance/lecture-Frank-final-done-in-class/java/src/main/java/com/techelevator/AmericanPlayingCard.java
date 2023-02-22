package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/****************************************************************************************************
 * American Playing Card Class - subclass of generic PlayingCard
 *
 * This class has the methods and data in the super class
 ***************************************************************************************************/

// This is a subclass of PlayingCard (extends indicates a subclass)
//
// We define what we want to add or change to the data methods of superclass
//
public class AmericanPlayingCard extends PlayingCard{
	/************************************************************************************************
	 * Constants for values related to American Playing Cards
	 *
	 * final indicates the variable is constant (cannot be changed after it is assigned a value)
	 * CONSTANT_NAMES, by convention, are coded in all uppercase with _ separating words
	 * static indicates there is only one occurrence of teh variable regardless of the number of object defined
	 *      (more about static later)
	 *
	 * Constants are often defined as static
	 ***********************************************************************************************/	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;

	/**************************************************************************************************
	 * Maps used to validate/limit suits, colors and value names for American Playing Cards
	 *
	 * These Maps are made static because we only need on copy of the Map
	 *              regardless of how many PlayingCard object exist
	 *
	 * The Suit/colors and value/names are the same for all PlayingCards
	 *      so we don't need a Map for them individually
	 *************************************************************************************************/	
	
	private static Map<String,  String> suitMap  = new HashMap<String , String>(); // ~ indicates same as on the left side
	private static Map<Integer, String> valueMap = new TreeMap();    // the data types are optional on right side
	                                                                 // TreeMap keeps entries in key sequence
	/***************************************************************************************************
	 *Invoke method to populate maps with valid suits, colors & value names for American Playing Cards
	 **************************************************************************************************/	
	// to initialize static data in a class, we need a static method (more later)
	static {             // static method to initialize maps before are ever used
       initializeMaps(); // methos to initialize the Maps
    }
	/***************************************************************************************************
	 * 0-arg / Default Constructor in case Java needs it (if Java needs default ctor and it's missing
	 *                                                    you get an error)
	 *
	 *                 if you create an array of objects, Java runs the default ctor for each element
	 *                 PlayingCard[] deck = new PlayingCard[52]; // Java will run the default ctor 52 times
	 *
	 * This default AmericanPlayingCard ctor defines a default PlayingCard
	 * (call the super class ctor with our default values)
	 **************************************************************************************************/
	public AmericanPlayingCard() 
	{
		// We are required to run a super class ctor from a subclass ctor
		// Since PlayingCard (super class) has only one ctor, its the only choice we have
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);  // Invoke 3-arg ctor in superclass
	} 
	/***************************************************************************************************
	 * 2-arg Constructor for a user provided value and suit
	 *
	 * the super class has one ctor that takes a value, suit and a color
	 *
	 * we get the value and suit from the user when instantiate an object of this class
	 *
	 * the color of the card is determined from the suitMap
	 ***************************************************************************************************/	

	// method parameters represent what you want the user to specify when instantiating an object
	//        they are indicated by datatype name
	//        method parameters CANNOT call methods
	public AmericanPlayingCard(int value, String suit) {
// super ctor:value, suit, color (call the Map .get() method to get the color for the suit)
		super(value, suit, suitMap.get(suit));       // Determine color and call super class 3-arg ctor
// Because the call to super class ctor must be the first statement in the subclass ctor
//         we must call the superclass ctor with whatever data the user sends us
//         and validate and change it afterward

		// After the super class is initialized, verify we have valid data
		//       and change it to be valid if it's not

		if (value > MAXVALUE) {          // If value provided is greater than max value allowed
			setValue(MAXVALUE);          //      set it to max value allowed
			                             //      using the super class method which we have access to
		}
		if (value < MINVALUE) {          // If value provided is greater than min value allowed
			setValue(MINVALUE);          //      set it to min value allowed
			                             //      using the super class method which we have access to
		}
	}
	private void setColor(){};
	/****************************************************************************************************
	 * Initialize Maps to valid suit/color combinations and value names
	 ***************************************************************************************************/	
	private static void initializeMaps() {
		suitMap.put("SPADES"  , "BLACK");
		suitMap.put("CLUBS"   , "BLACK");
		suitMap.put("DIAMONDS", "RED");
		suitMap.put("HEARTS"  , "RED");
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Eight");
		valueMap.put(9,"Nine");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Jack");
		valueMap.put(12,"Queen");
		valueMap.put(13,"King");
	}
}
