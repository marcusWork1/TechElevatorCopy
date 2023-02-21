package com.techelevator;

	/** identifies a special type comment know as a JavaDoc (Javadoc) comment
 	* 
	* A JavaDoc can be used to generate standard formatted documentation
 	* and it shows when in intellisense of the IDE
 	* 
 	* May different annotations (@-word) to identify specific components of code
	* 
	* @param
 	* @returns
 	* @author student
 	*
 	* Refer to the Topic in Cohort Google Doc for a link to more than you want to about JavaDoc
 	*
	 */


public class PlayingCard {
	/*********************************************************************************************
	 * static - means there is only copy - shared by all objects
	 * 
	 * No matter how many objects of the class exist there is only one copy of the static data
	 * 
	 * static data exists even if no object of the class have been instantiated
	 * 
	 * non-static variables are referred to as instance variables because they exist for each
	 *            instance of the class
	 *            
	 * static data members can only be changed by static methods.
	 * 
	 * static methods can only refer to static data members
	 * 
	 * static method is one that processes static data
	 * 
	 * static methods may be invoked with any object of the class or class name
	 * 
	 *      System.out.println()   -   System is the class name; out is the object; println() is the method
	 * 
	 *      Integer.parseInt()     -   Integer is the class name; parseInt() is the method
	 ********************************************************************************************/
	/******************************************************************************************************
	 * this. - indicates the current object being processed by the method
	 *
	 * "this method's copy of the object"
	 *
	 * Only are required to use this. when a parameter for the method has the same name as member variable
	 ******************************************************************************************************/
	//********************************************************************************************
	// Class member constants - a value that cannot be changed once it is set
	// Use a constant to represent a value rather than just coding the value when needed (loosely coupled)
	// final indicates a variable is a constant - Java convention says constant names should be UPPERCASE
	//                                            and separate words with underscores
	//********************************************************************************************
	private final int MINVALUE    = 0;             // Minimum valid card value 
	private final int MAXVALUE    = 13;            // Maximum valid card value
	private final int JOKER_VALUE = 0;             // Joker value
	private final int DEFAULT_VALUE = JOKER_VALUE; // Used if no value provided
		
	//********************************************************************************************	
	// Class member data - attributes of a class object
	//
	// Make member data private so no one outside the class has direct access to the data (Encapsulation)
	//
	// The class provides getters and setters to control access to member data from outside the class
	//
	// The only way something outside the class can access the classes data is through getters and setters
	//
	// a getter is a method that returns the value of data in the class
	// a setter is a method that allows the changing of data in a class
	//
	// the standard getter name: getAttributeName()
	// the standard setter name: setAttributeName()
	// the standard getter name for a boolean: isAttributeName()
	//
	// IntelliJ can generate generic getter and setters with standard names
	//
	//********************************************************************************************
	private String  suit;
	private int     value;   // 0=Joker, 11=Jack, 12=Queen, 13=King
	private String  color;   // derived from the suit - derived value - value is based on some other attribute
	private boolean showing; // true-face-up     false-face-down
	private String  shape;   // read-only - no Setter or argument to a constructor
	
//********************************************************************************************
// Constructors for the class - initialize the data members for a class
//
// Constructors are automatically used by Java when it needs to create an object of a class
//
// Constructors have the same name as the class have no return type - NOT EVEN void	
//
// Constructors are frequently overloaded (same name, same behavior,  different parameters)
//              overloading ctors allows users flexibility in defining objects of the class
//*********************************************************************************************

	/**
	 * default constructor - has no parameters
	 */
	public PlayingCard() {
		value   = DEFAULT_VALUE;
		suit    = "Clubs";
		showing = false;
		determineColor();    // Use class member method to set the color based on the suit - set derived value
		shape   ="Rectangle";
	}
	/**
	 * 4-arg constructor - allow the user to create a card with a specific value, suit, color, showing
	 */
	public PlayingCard(int value, String suit, String color, boolean showing) {
		setValue(value);          // Use member method to set value in case value passed is invalid
		this.suit    = suit;      // this.suit is required because there is a parameter called suit
		this.showing = showing;   // this.showing is required because there is a parameter called showing
	//	showing = showing;        // assign the parameter named showing to the parameter named showing
		determineColor();         // Use class member method to set the color based on the suit
		                          //     ignore color sent is as a parameter by user
		shape="Rectangle";        // no need to use this.shape because no parameter called shape for method
	}
	/**
	 * 2-arg constructor - allow the user to create a card with a specific value and suit
	 */
		public PlayingCard(int value, String suit) {
			setValue(value);          // Use member method to set value in case value passed is invalid
			this.suit       = suit;
			this.showing    = false;
			determineColor();         // Use class member method to set the color based on the suit
			shape="Rectangle";
		}
//********************************************************************************************
// Getters	- Allow the user to retrieve values in the private data members (Encapsulation)
//********************************************************************************************
	/**
	 * @return the PlayingCard suit attribute
	 */
		
	public String getSuit() {
		return suit;
	}
	
	/**
	 * @return the PlayingCard value attribute
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @return the PlayingCard color attribute
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @return if the PlayingCard showing or not
	 */
	public boolean isShowing() {
		return showing;
	}  // boolean getters start with is rather that get
	
	/**
	 * @return the shape attribute of the PlayingCard
	 */
	public String getShape() {
		return shape;
	}

//*************************************************************************************************
// Setters	- allow users to change the values in private data members (Encapsulation)
//
//  Not all data members require setters - if you don't want to all a user to change the data
//                                         don't provide a setter; You are making the attribute read-only
//
//  If a data member has a getter without a setter it is said to be read-only (shape in this class)
//*************************************************************************************************
	/**
	 * @param suit is the value to set PlayingCard suit attribute
	 * @return void
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	/**
	 * @param value is the value to set PlayingCard value attribute
	 * <br><br>
	 * If value is outside the valid range of values for a PlayingCard
	 * a default value will be assigned
	 * <br><br>
	 * @return void
	 */
	public void setValue(int value) {
		// Since this function requires access to the parameter passed by the user
		//       that parameter is passed to this function
		if (value >= MINVALUE && value <= MAXVALUE) { // Is the value passed in the range for a valid card?
			this.value = value;                       //     Yes - assign it to the value data member
		}
		else {
			this.value = DEFAULT_VALUE;               //     No - assign DEFAULT_VALUE to value data member
			}
	}
	/**
	 * @param color is the the value to set PlayingCard color attribute
	 *        color passed is ignored and actually color is set based on suit
	 * @return void
	 */
	public void setColor(String color) {
		determineColor();               // Use class member method to set the color based on the suit
	}
	/**
	 * @param showing is the the value to set PlayingCard showing attribute
	 * @return void
	 */
	public void setShowing(boolean showing) {
		this.showing = showing;
	}
	
//********************************************************************************************
// Additional member methods
//
// Provide functionality to class beyond the basics
//********************************************************************************************
	/**
	 * Return whether PlayingCard value is what one would consider a face card (value greater than 11)
	 *
	 * @return whether card is a face card or not
	 */
	
	public boolean isFaceCard() {
		// Determine the value for the derived property FaceCard
		// A derived property/attribute is a value based on some other data
		//
		// A FaceCard is based on the value of the card being greater than or equal to 11
		//
		// its considered good programming practice to use getters in the class to access data in the class
		//     from methods in the class - teh method gets the same data the user would see with an extra processing

		if(getValue() >= 11) {
			return true;
		}
		else {
			return false;
		}

    //  return (getValue() >= 11);  // use class method to retrieve class data
	// 	return (value >= 11);  // directly access the class member
	//	return (getValue() >= 11) ? true : false;
	}
	/**
	 * Flip card from showing to not showing
	 * @return void
	 */
	
	public void flip() {
		// the shortest way to reverse a boolean: !booleanVariable
		showing = !showing;  // Reverse the current value of showing true to false; false to true 
	}

	// Determine card color based on suit
	// So we control what color is set and can be sure it is correct for the suit
	// private so only members of the class may use it - application programs cannot use it
	
	private void determineColor() { // set the cardColor based on the cardSuit - card suit is already set
	// Because this method uses only data members (suit) no parameters are necessary
	// it has access to all the data it needs
		if (suit.equals("Spades")      // if the object's suit data member equals "Spades"
		 || suit.equals("Clubs")
		 || suit.equals("Joker")) {
			color = "Black";
		} else {
			color = "Red";
		}
	}	
	/**
	 * Display the attributes of a PlayingCard one at a time
	 * @return void
	 */
	// Display the attributes of a PlayingCard
	// void - method does not return anything
	public void showCard() {
		System.out.println("      Suit: " + suit);
		System.out.println("     Value: " + value);
		System.out.println("     Color: " + color);
		System.out.println("   Showing: " + showing);
		System.out.println("     Shape: " + shape);
//		System.out.println("-----------------------------------------------------------------------------------");
	}

//********************************************************************************************
// Overrides - Define new behavior that is different than ancestor behavior
//             Overriding methods have same name, same parameters, but different behavior
//
// If an ancestor class has a method that doesn't do what you want it to do, override it
//
// Common Object class overrides:
//
//    toString() - Object class toString() returns package.class.@memoryLocation
//                 Should return a String representation of the object
//
//    equals()	 - Object class equals() compares the location of the Objects, not the content of the object
//                 Should compare the contents of the objects
//
// IntelliJ will generate generic override method that are usually ok to use
//********************************************************************************************

	/**
	 * Define .equals() method to compare two PlayingCards to see if they equal
	 *
	 * A PlayingCard is equal to another PlayingCard when the value and suit are equal
	 *
	 * @params PlayingCard - the card to compare to
	 * @return boolean
 	 */

		public boolean equals(PlayingCard theOtherCard) {
			// to use this method:   aPlayCardObject.equals(anotherPlayCardObject)
			//
			//     this. = represents the PlayingCard to the left of the .equals
			//
			//     danielsCard.equals(briansCard) - this. - represents danielsCard
			//                                      the OtherCard - represents briansCard
			//
			// use the String.equals() to compare suit as suit is a String
			//
			//                                      suit is a String so .equals is the String .equals
			if (this.value == theOtherCard.value && this.suit.equals(theOtherCard.suit)) {
				return true;
			}
			return false;

			// return this.value == theOtherCard.value && this.suit.equals(theOtherCard.suit)
			//        is ok too
		}

	/**
	 * Construct a String representation of the object
	 * due to the Object class toString() didn't do what we wanted it to (returned package.class.@memoryLocation)
	 * @return String containing the attributes of the object
	 */

	@Override           // Ask the compiler to verify this is a proper override of Object class toString()
	public String toString() {
		return "PlayingCard [suit=" + suit + ", value=" + value + ", color=" + color + ", showing=" + showing
				            + " shape=" + shape +"]";
	}
}


