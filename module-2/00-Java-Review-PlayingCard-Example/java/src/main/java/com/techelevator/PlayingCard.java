package com.techelevator;

/***************************************************************************************************
 * Class to Simulate an American Playing Card
 ***************************************************************************************************/

public class PlayingCard {
	/***************************************************************************************************
	 * Define constants to represent card attributes
	 * 
	 * public is OK since they are constants and cannot be changed
	 * 
	 * static so it can be referenced using the class name. ie. no object required
	 * 
	 * enum - define a set of constant values that may be referenced as a data type
	 *        allows the assign of a word to a constant value to limit the values in a variable
	 *        make it easier to code (get rid using "magic" numbers to represent data
	 *        used as data-types - define variable as enums, parameters as enum - anywhere a variable is allowed
	 *        Java will ensure that an enum type only has values valid for the enum (we don't have to check)
	 *        enum are actual integer values starting at 0 inside Java
	 ***************************************************************************************************/
	// Making the enum public allows application programs to use the enum as constant too

	public static enum CardColor {  // define words to represent allowable card colors (instead of String)
		BLACK, RED                  // These are the only valid values Java will allow
	};

	public static enum CardSuit {          // public is OK since they are constants and cannot be changed
		SPADE, CLUB, HEART, DIAMOND, JOKER // static so it can be referenced using the class name. ie. no object required
	};

	public static enum CardValue {  // Using the fact that enums are really integers inside value to name our values
		JOKER, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	};

	/***************************************************************************************************
	 * Define constants to represent defaults for card attributes
	 *
	 * protected means members of this class and members of any subclass can access the data / method
	 *           directly without having to use methods to do so
	 *
	 * protected so subclasses may access is OK since they are constants and cannot be changed
	 * 
	 * static so it can be referenced using the class name. ie. no object required
	 ***************************************************************************************************/
	
	protected static final CardValue DEFAULTCARDVALUE = CardValue.JOKER;   // enum data-type for value
	protected static final CardColor DEFAULTCOLOR     = CardColor.BLACK;   // enum data-type for value
	protected static final CardSuit  DEFAULTSUIT      = CardSuit.JOKER;    // enum data-type for value
	/***************************************************************************************************
	 * Member data
	 * 
	 * private to protect as prescribed by encapsulation - method must be used to access the data 
	 ***************************************************************************************************/
	
	private CardValue value;   // use enum for data type - Java will enforce allowable values
	private CardColor color;   // use enum for data type - Java will enforce allowable values
	private CardSuit  suit;    // use enum for data type - Java will enforce allowable values

	/***************************************************************************************************
	 * Default constructor
	 ***************************************************************************************************/
	
	public PlayingCard() 
	{
		value = DEFAULTCARDVALUE;
		suit  = DEFAULTSUIT;
		setColor(suit);     // Set color in object based on suit - NOTE: suit must have a value before this
	} 
	/***************************************************************************************************
	 * 2-arg (CardValue and CardSuit) constructor
	 ***************************************************************************************************/
	public PlayingCard(CardValue value, CardSuit suit) {
		this.value = value;   // Set value in object to value passed as argument
		setColor(suit);       // Set color in object based on suit passed as argument
		this.suit = suit;     // Set suit in object to suit passed as argument
	}
	/***************************************************************************************************
	 * 2-arg (int and CardSuit) constructor
	 ***************************************************************************************************/
	public PlayingCard(int value, CardSuit suit) {
		this.value = setValue(value);  // Set value in object based on int value passed as argument
		setColor(suit);                // Set color in object based on suit passed as argument
		this.suit = suit;              // Set suit in object to suit passed as argument
	}
	/***************************************************************************************************
	 * getter methods
	 ***************************************************************************************************/
	public CardValue getValue() { // Return the CardValue stored in the object
		return value;
	}

	// Return the integer value assigned to the card - value is a enum called CardValue
	public int getIntValue() {    // Return integer value of CardValue stored in the object
		return value.ordinal();
	}  // .ordinal returns the integer value of enum
	
	public CardColor getColor() { // Return CardColor stored in the object
		return color;
	}
	
	public CardSuit getSuit() {   // Return the CardSuit stored in the object
		return suit;
	}
	/***************************************************************************************************
	 * setter methods
	 ***************************************************************************************************/
	public CardValue setValue(int ivalue) {  // Set the CardValue based on an int value
		/*
		 * switch is alternative to a set of nested if-then-else-if statements
		 * switch is followed by a series of case statements which are the value you want to check in the variable
		 * when a case is true the statements following the case AND ALL OTHER CASES are run too
		 *        unless you have break at end of the case
		 *        when a case is true all statements in the switch following the case are run until
		 *        it hits a break statement or the end of the switch - no other cases are checked
		 *
		 * stacking cases to simulate an equal-or condition
		 * There is not a way to simulate an equals-and in a switch
		 *
		 * switch(variable) { - check the value in this variable
		 *      case value:  - if the value for the switch equals the case value
		 *           statements-to-run if value in the case matches the one in the switch
		 *
		 *      default: - if none of t eases were true
		 *           statement-to-run if none of cases were true
		 * }
		 *
		 * if the code below was written as a set of nested if-then-else-if
		 *
		 *  if (ivalue == 1) {
		 *     return CardValue.ONE;
		 *  }
		 *  else if (ivalue == 2 {
		 *           return cardValue.TWO;
		 *       }
		 *       else if (ivalue == 3 {
		 *               return cardValue.THREE;
		 *            }
		 *            else if (ivalue == 4 {
		 *                     return cardValue.FOUR;
		 *                 }
		 *
		 *
		 */
		// a break is NOT required at the end of the case in this example to prevent falling through to the next case
		//         because the cases contain a return statement which ends the method and returns to the caller
		//                 so we can't fall through to next case.


		switch (ivalue) {            // Check ivalue
		case 1:                      // if ivalue == 1
			return CardValue.ONE;    //     do this
		case 2:                      // if ivalue == 2
			return CardValue.TWO;    //      do this
		case 3:                      // ivalue == 3
			return CardValue.THREE;  //      do this
		case 4:
			return CardValue.FOUR;
		case 5:
			return CardValue.FIVE;
		case 6:
			return CardValue.SIX;
		case 7:
			return CardValue.SEVEN;
		case 8:
			return CardValue.EIGHT;
		case 9:
			return CardValue.NINE;
		case 10:
			return CardValue.TEN;
		case 11:
			return CardValue.JACK;
		case 12:
			return CardValue.QUEEN;
		case 13:
			return CardValue.KING;
		default:
			return CardValue.JOKER;
		}
	}
	// Note: the processing done by this switch statement may also be accomplished using the values() method
	//       and the variable ivalue as an index to the array returned by values
	//       i.e. instead of this switch statement, we could have coded:
	//
	//            return CardValue.values()[ivalue];
	//
	// The switch statement was used to illustrate how a switch statement works.


	private void setColor(CardSuit suit) {  // Set the color based on the suit of the object
		// if (suit == cardSuit.SPADE or suit == cardSuit.CLUB - stack cases does this
		switch (suit) {
		case SPADE:       // Stacking cases simulates an equal or condition
		case CLUB:
			this.color = CardColor.BLACK;
			break;      // break is required so we don't fall through to the next case - we exit the switch
		case DIAMOND:
		case HEART:
			this.color = CardColor.RED;
			break;      // break is required so we don't fall through to the next case - we exit the switch
		default:
			this.color = DEFAULTCOLOR;  // no break is needed here because it is the last case
		}
	}

	public void setSuit(CardSuit suit) {  // Set the suit of the object 
		this.suit = suit;
	}

	/***************************************************************************************************
	 * Object super class overrides
	 ***************************************************************************************************/
@Override   // Ask compiler to assure this is a valid super class override

	public String toString() {                         // Return a String representation of the object
		//-------------------------------------------------------------------------------------------------
		// StringBuffer is a mutable version of String - allows a new value to be assigned to the same String
	    //              a more efficient type than String
	    //
	    // It's just a regular class, not special like String, so Java has no built-in support for it
	    //
	    //  To concatenate values: String + String - Java knows tha + with a String means concatenation
	    //                         StringBuffer.append(otherString) - methods are required
		//
	    // String are immutable - if you assign a new value to a String Java destroy olds String and creates
	    //                               a new one
		//-------------------------------------------------------------------------------------------------
		StringBuffer stringCard = new StringBuffer();  // Define an object to hold String version of object

		int firstColumnSize = 16;                      // position of first tab position of screen line
		stringCard.append("Value: " + value);          // Add literal to StringBuffer
		stringCard.append(" (" + getIntValue() + ")"); // Add integer value of CardValue to StringBuffer
		if (stringCard.length() < firstColumnSize) {   // If current StringBuffer size less than first tab position
			stringCard.append("\t");                   //     tab to first tab position
		}
		stringCard.append("\tSuit: " + suit);          // Add tab and suit value
		stringCard.append("\tColor: " + color);        // Add tab and color value
		return stringCard.toString();                  // Convert StringBuffer to String and return
	}

@Override   // Ask compiler to assure this is a valid super class override

public boolean equals(Object otherObject) {   // Compare two PlayingCards for equality - note generic Object parameter
	
		if (otherObject == this) {   // if object being compared to itself
			return true;             // objects are equal
		}
		else {
			// instanceof returns true if an object is an instance of the class specified
			if ((otherObject instanceof PlayingCard)) {            // If the object being compared to is the same class as object 
				PlayingCard otherCard = (PlayingCard) otherObject; // Define a PlayingCard object from object being compared to
				return (this.value == otherCard.value && this.color == otherCard.color && this.suit == otherCard.suit);
			}
	    return false;    // Required so IntelliJ realizes we are returning a boolean
		}
		
}
@Override   // Ask compiler to assure this is a valid super class override

	public int hashCode() {      // Generate hashCode for object if Java needs one e.g. for a HashMap
	                             // HashCode is a unique value representing an instance of an object
		int hashValue = 17;      // A prime number used in calculating the HashCode
		int primeMultipler = 59; // A prime numbet used in calculating the HashCode

		hashValue = hashValue * primeMultipler + value.ordinal();  // Same values used in equals() 
		hashValue = hashValue * primeMultipler + suit.ordinal();   //     should be used in the 
		hashValue = hashValue * primeMultipler + color.ordinal();  //        HashCode method
		return hashValue;
	}

	/***************************************************************************************************
	 * Miscellaneous class methods
	 ***************************************************************************************************/
	public void showCard() {                 // Display an instance of a PlayingCard
		System.out.println(this.toString());
	}

	public void showCardWithHash() {          // Display an instance of a PlayingCard wirh HashCode
		System.out.println(this.toString() + "\thashCode: " + hashCode());
	}
}
