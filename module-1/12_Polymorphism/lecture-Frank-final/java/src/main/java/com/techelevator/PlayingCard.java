package com.techelevator;

public class PlayingCard {
	
	private int    value;
	private String color;    
	private String suit;     
	
	
	public PlayingCard(int value, String suit, String color) {
		this.value = value;
		this.suit  = suit;
		this.color = color;
	}
	
	public int    getValue() {
		return value;
	}
	public String getColor() {
		return color;
	}
	public String getSuit() {
		return suit;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	@Override
	public String toString() {
		return "PlayingCard [value=" + value + ", color=" + color + ", suit=" + suit + ", getValue()=" + getValue()
				+ ", getColor()=" + getColor() + ", getSuit()=" + getSuit() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PlayingCard other = (PlayingCard) obj;
		if (color != other.color) {
			return false;
		}
		if (suit != other.suit) {
			return false;
		}
		if (value != other.value) {
			return false;
		}
		return true;
	}

	// In order for Polymorphism to work we must define any polymorphic methods
	//    in this super class whether we need them here or not
	//    (this is dumb to do, but until tomorrow, its all we have)

	public void showCard() {}  // required for Polymorphism to work
	                           // even though it does nothing
	                           // tomorrow we learn a better way to handle this

} // End of PlayCard class
