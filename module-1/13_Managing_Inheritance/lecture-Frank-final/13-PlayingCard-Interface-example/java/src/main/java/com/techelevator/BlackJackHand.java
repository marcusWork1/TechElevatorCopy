package com.techelevator;

import java.util.ArrayList;

public class BlackJackHand implements CardHand {   // implement an interface
                                                     // this is a type of CardHand// it implements all the behaviors of CardHand
	private int numCardsInHand = 2;

	// Define a reference to the class data without initialization
	//          its initialize it the constructor
	private ArrayList<PlayingCard> aHand;

	// This technique works, but is not considered good practice
	// private ArrayList<PlayingCard> aHand = new ArrayList<PlayingCard>(numCardsInHand);

	// this is a constructor - same name as class
	//                         its job to initialize an object of class
	public BlackJackHand() {  // default ctor or 0-arg based the number of parameters
		// instantiate an ArrayList of PlayingCards with an initial size of the numCardsInHand
		//      new ArrayList<PlayingCard>() - create an empty ArrayList to start
		// Its more efficient to instantiate with a starting size rather empty if you know at least how many entries you need
		aHand = new ArrayList<PlayingCard>(numCardsInHand); // Create a non-empty ArrayList to start
	}

	// methods required because we implemented the CardHand interface
	// override the methods in the interface - same name, same return type, same parameters

	@Override // optional - good idea to code so you are sure you are properly define the method for the interface
	public ArrayList<PlayingCard> getHand() {
		return aHand;
	}

	@Override
	public void addCard(PlayingCard aCard) {
		aHand.add(aCard);
		numCardsInHand++;
	}
	@Override
	public void emptyHand() {
		aHand.clear();
	}
	@Override
	public void show() {
		for (PlayingCard aCard : aHand)
		{
			System.out.println(aCard);
		}
			return;
	}
	//
	// Additional methods not required by the CardHand interface
	//
	public void dealHand(CardDeck aDeck) {
		for (int i=0; i < numCardsInHand; i++ ) {
			aHand.add(aDeck.dealCard());
		}	
	}
	
}
	
