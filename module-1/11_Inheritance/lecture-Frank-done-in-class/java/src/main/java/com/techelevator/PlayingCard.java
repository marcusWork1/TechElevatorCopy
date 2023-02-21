package com.techelevator;

/***************************************************************************************
 * Generic Playing Card Class
 ***************************************************************************************/
public class PlayingCard {
	/***************************************************************************************
	 * Member Instance Variables - Each instance of the class gets a set
	 ***************************************************************************************/
	private int    value;       // Card value
	private String color;       // Card color  
	private String suit;        // Card suit 

	/***************************************************************************************
	 * 3-arg constructor when user uses value, suit and color to instantiate 
	 ***************************************************************************************/
	
	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit  = suit;
		this.color = color;
	}

	/***************************************************************************************
	 * Getters - allow users to "see" the values in a Playing Card object
	 ***************************************************************************************/
	public int getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	public String getSuit() {
		return suit;
	}
	/***************************************************************************************
	 * Setters - allow users to change the values in a Playing Card object
	 *
	 * make the access of the setters protected instead of public
	 *
	 *  protected access means this class and any subclass can use the method
	 *  public access means anyone with an object can use the method
	 ***************************************************************************************/
	protected void setValue(int value) {
		this.value = value;
	}
	protected void setColor(String color) {
		this.color = color;
	}
	protected void setSuit(String suit) {
		this.suit = suit;
	}
	/***************************************************************************************
	 * Overrides are coded when you want to modify the behavior of a super class method
	 *
	 * Common overrides:
	 *
	 *  .toString() - because the Object (super class) toString() does not return the object as a String
	 *                             it returns the package.class.@location instead as String
	 *
	 *  .equals() - because the Object (super class) equals() does not compare the contents of objects
	 * 	                           it compares the locations of the object
	 *
	 *  .clone() - because the Object (super class) clone() does not copy the contents of objects
	 * 	 	                           it copies the locations of the object
	 *
	 *  .hashCode() - because the Object (super class) hashCode() does not use the contents of objects
	 * 	                          it uses the locations of the object
	 */
	/***************************************************************************************
	 * toString() override for the Object class: String toString() 
	 *                            to present the values of a Playing Card object as a String
	 ***************************************************************************************/
	@Override   // for the Object class: String toString() 
	public String toString() {
		return "PlayingCard [value=" + value + ", color=" + color + ", suit=" + suit + ", getValue()=" + getValue()
				+ ", getColor()=" + getColor() + ", getSuit()=" + getSuit() + "]";
	}
	/***************************************************************************************
	 * equals() override for the Object class: boolean equals(Object) 
	 *                   to allow users to see if two Playing Cards have all the same values
	 ***************************************************************************************/
	@Override  // for the Object class: boolean equals(Object)
	//    aCard.equals(anotherCard)
	//    this. - references aCard (whatever is to the left of the . when method was invoked)
	//    obj.  - references anotherCard (parameter passed to the method)
	public boolean equals(Object obj) {    // Note: Parameter is a generic Object class because this is an override
		if (this == obj) {                 // If PlayingCard is being compared to itself...
			return true;                   //      it must be equal - return false
		}
		if (obj == null) {                 // If PlayingCard is being compared to a null object...
			return false;                  //       it must be unequal - return false
		}
		// getClass() returns the Class of an object
		if (getClass() != obj.getClass()) {// If PlayingCard is being compared to a non-PlayingCard object...
			return false;                  //       it must be unequal - return false
		}
		PlayingCard other = (PlayingCard) obj; // Instantiate a PlayingCard from the generic object passed as parameter
		                                       //     so we can access PlayingCard variables and methods

		// compare the values in the object to left of the . (this.)
		//      to the values in the object inside the .equals() - other. instantiate from parameter obj

		if (color != other.color) {            // If colors are not	equal...
			return false;                      //       it must be unequal - return false
		}
		if (suit != other.suit) {              // If suits are not equal...
			return false;                      //       it must be unequal - return false
		}
		if (value != other.value) {            // If values are not equal...
			return false;                      //       it must be unequal - return false
		}
		return true;                           // All of the above are true, the objects are equal - return true
	}
	/***************************************************************************************
	 * clone() method to create a copy of a PlayingCard from a PlayingCard
	 *
	 * Method is needed to make a copy of a PlayingCard because the Object class clone() method
	 *        has no idea what data is in ths class - so it copies the location
	 ***************************************************************************************/
	public PlayingCard clone() {
		return new PlayingCard(this.value, this.suit, this.color);  // Use 3-arg ctor to create new object
	}
}
