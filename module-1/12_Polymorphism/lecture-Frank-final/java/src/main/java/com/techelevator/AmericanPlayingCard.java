package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AmericanPlayingCard extends PlayingCard{
	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	// Because our maps are static (more later)
	//    they should not be initialized in a constructor
	//
	// static data may exist without any objects being instantiated

	// constructors run only when an object of the class is instantiated
	// if no objects of the class are instantiated, no constructors have run
	// if static data in the class is initialized in constructors
	//       and no constructors have been run, the static data os uninitialized
	//
	// if any data (including static data) is used before it is initialized
	//        huge opportunities for errors.
	//
	// All data should be initialized before any possible use
	//
	// Since static data can exist without any objects being instantiated,
	//       it is unsafe to initialized them in constructor.
	//
	// Java provides a means to initialize static data by defining a static method with no name

	// this is a static data initializer for the class
	// a static method with no name, no return type and no parameters
	// Java runs this method ro initialized static data when the static data is instantiated
	//    by Java
	static {
		initializeMaps();  // go run the class method provided to initialize the Maps
	}
	
	public AmericanPlayingCard() 
	{
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);
	} 

	// Conditional operator (?) is a short-hand for if-else - provides a conditional value
	// Allows use of conditional data where an if-else if not allowed
	//
	//  access   method-name(parameters)
	//
	// occasionally the parameters used with teh method depend on conditions
	// since an if-else is not allowed in the parameter list,
	//       the conditional operator (?) is a great way to provide a conditional parameter value
	//
	// The way conditional operator works: (condition) ? value-if-true : value-if-false


	public AmericanPlayingCard(int value, String suit) {

		// we need to call the super class constructor passing it a value, suit, color
		//
		// Be sure we pass a valid suit and color to super class constructor
		//
		// We have a suitMap with valid suits and associated color
		//
		// if the suit the user sends us is in the suitMap we know it's a valid suit
		// if the suit the user sends us is in the suitMap we can get the associate color
		//
		// if we get an invalid suit - use DEFAULTSUIT and DEFAULTCOLOR for the class

//		super(value,                                                        // Call super ctor with value passed
//			  suitMap.containsKey(suit) ? suit : DEFAULTSUIT,               // If valid suit passed, use it otherwise use DEFAULTSUIT
//		      suitMap.get(suit) != null ? suitMap.get(suit) : DEFAULTCOLOR);// If valid suit passed, use color for suit otherwise use DEFAULTCOLOR

// Alternative to super class constructor call above
		// initialize the super class object with possibly invalid suit and color
		super(value, suit, DEFAULTCOLOR);

		// if super class object was initialized with invalid make it valid
		if(!suitMap.containsKey(suit)) { // if the suit we got is not in the suitMap - it's invalid'
			setSuit(DEFAULTSUIT);        //    set the suit to the DEFAULTSUIT
		}
		String suitColor = suitMap.get(getSuit());  // get the color for suit of the card
		setColor(suitColor);

		// if the value provided was invalid set the value to min or max depending in if it was too big or too small
		if (value > MAXVALUE) {
			setValue(MAXVALUE);
		}
		if (value < MINVALUE) {
			setValue(MINVALUE);
		}
	}


	// This method is static because it works with static data (more later)
	//             is private so no one outside the class can use it
	static private void initializeMaps() {
		suitMap.put("SPADES"   , "BLACK");
		suitMap.put("CLUBS"    , "BLACK");
		suitMap.put("DIAMONDS" , "RED");
		suitMap.put("HEARTS"   , "RED");
		suitMap.put(DEFAULTSUIT, DEFAULTCOLOR);
		
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
	
	@Override
	public String toString() {
		return "AmericanPlayingCard: " 
	          +"Value: "  + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";
	}

	// Display the contents of an AmericanPlayingCard object
	public void showCard() {
		System.out.println(this.toString());
	}

}
