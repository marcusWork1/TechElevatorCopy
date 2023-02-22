package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ItalianPlayingCard extends PlayingCard {
	/************************************************************************************************
	 * Constants for values related to Italian Playing Cards
	 ***********************************************************************************************/	
	private static final int    DEFAULTCARDVALUE = 0;
	private static final String DEFAULTCOLOR     = "BLACK";
	private static final String DEFAULTSUIT      = "Joker";
	private static final int    MAXVALUE         = 13;
	private static final int    MINVALUE         = 0;

	/**************************************************************************************************
	 * Maps used to validate/limit suits, colors and value names for Italian Playing Cards
	 *************************************************************************************************/	
	
	private static Map<String,  String> suitMap  = new HashMap<String , String>();  
	private static Map<Integer, String> valueMap = new TreeMap<Integer, String>(); 
	
	/***************************************************************************************************
	 *Invoke method to populate maps with valid suits, colors & value names for Italian Playing Cards
	 **************************************************************************************************/	
	// Since static data can exist without an object - we can't use an object to invoke them
	// We can define an anonymous method to initialize them - method with no name or parameters
	//
	// only static methods can change static data
	
	static {             // static method to initialize maps before are ever used
       initializeMaps();
    }
	/***************************************************************************************************
	 * 0-arg / Default Constructor
	 **************************************************************************************************/		
	public ItalianPlayingCard() 
	{
		// invoke the super class ctor with default values
		super(DEFAULTCARDVALUE, DEFAULTSUIT, DEFAULTCOLOR);  // Invoke 3-arg ctor in superclass
	} 
	/***************************************************************************************************
	 * 2-arg Constructor for a user provided value and suit
	 ***************************************************************************************************/	
	public ItalianPlayingCard(int value, String suit) {
		// a sub-class ctor must call a super class ctor as the very first thing it does
		// the keyword "super" refers to something in the super class
		
		super(value, suit, suitMap.get(suit));       // Determine color and call super class 3-arg ctor
	
		if (value > MAXVALUE) {                      // If value provided is greater than max value allowed         
			setValue(MAXVALUE);                      //      set it to max value allowed
		}
		if (value < MINVALUE             // If value provided is greater than min value allowed
		|| (value == 8 || value ==9)) {  //    or value is an 8 or 9
			setValue(MINVALUE);          //    set the value to min value allowed
		}
	}
	/****************************************************************************************************
	 * Initialize Maps to valid suit/color combinations and value names
	 ***************************************************************************************************/	
	private static void initializeMaps() {  // must be a static method since it changes static data (the Maps)
		suitMap.put("COINS"  , "YELLOW");
		suitMap.put("CUPS"   , "BLUE");
		suitMap.put("SWORDS" , "RED");
		suitMap.put("BATONS" , "BLACK");
		
		valueMap.put(0,"Joker");
		valueMap.put(1,"Ace");
		valueMap.put(2,"Two");
		valueMap.put(3,"Three");
		valueMap.put(4,"Four");
		valueMap.put(5,"Five");
		valueMap.put(6,"Six");
		valueMap.put(7,"Seven");
		valueMap.put(8,"Invalid");
		valueMap.put(9,"Invalid");
		valueMap.put(10,"Ten");
		valueMap.put(11,"Fante");
		valueMap.put(12,"Cavallo");
		valueMap.put(13,"Re");
	}
	/****************************************************************************************************
	 * toString() Override
	 ***************************************************************************************************/
	@Override
	public String toString() {
		return "ItalianPlayingCard: " 
	          +"Value: "  + valueMap.get(getValue())
	          +" - Color: " + suitMap.get(getSuit()) 
			  +" - Suit: "  + getSuit()
			  +" - super.toString()=" + super.toString() + "\n";  // Invoke super class toString()in case we need it
	}
	/***************************************************************************************
	 * clone() method to create a copy of an ItalianPlayingCard from an ItalianPlayingCard
	 ***************************************************************************************/
	public ItalianPlayingCard clone() {
		return new ItalianPlayingCard(this.getValue(), this.getSuit()); // Use the 2-arg ctor to create new object
	}
	/****************************************************************************************************
	 * method to display an Italian PlayingCard
	 ***************************************************************************************************/
	public void showCard() {
		System.out.println(this.toString());  // Use the toString() method to format the data
	}
}
