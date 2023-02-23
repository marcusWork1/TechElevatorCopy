package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class CardDeck {
	// Using a Queue to hold the deck of PlayingCards
	// a Queue is FiFO data structure in Collections class (cousin to ArrayList)
	// A LinkedList was used to implement the Queue do to it's efficiency Queue
	LinkedList<PlayingCard> deckOfCards = new LinkedList<PlayingCard>();

	private int numCardsInDeck = 54;  // 52 usual cards plus 2 jokers

	public CardDeck() {
		resetDeck(true); // reset deck with jokers
	}

	public void showDeck() {
		System.out.println("Number of Cards in Deck: " + deckOfCards.size());
		for (PlayingCard aCard : deckOfCards) {
			System.out.println(aCard);
		}
	}

	public boolean anyCardsInDeck() {
		if (deckOfCards.size() > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public PlayingCard dealCard() {      // return the first card in the deck, unless it's empty
		if (deckOfCards.size() > 0) {
			return deckOfCards.remove();
		}
		else {
			 return null;
		}
	}

	public void resetDeck(boolean withJoker) {  // Create a deck of PlayingCards withoptional Jokers
		deckOfCards.clear();

		// because we start the loop variable at 1 intead of zero
		// our loop condition is specified as < number-we-want+1
		// instead of for(i=0; i <= 13; i++)  ---- wanted to use < like we usually do
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "CLUBS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "HEARTS"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "Spades"));
		}
		for (int i = 1; i < 14; i++) {
			deckOfCards.add(new PlayingCard(i, "DIAMONDS"));
		}

		if (withJoker) {
			deckOfCards.add(new PlayingCard(0, "JOKER"));
			deckOfCards.add(new PlayingCard(0, "JOKER"));
		}
	}

	public void shuffleDeck() {            // Use the Collections class shuffle method to randomize the cards in the deck
		resetDeck(false);                  // give me a new deck without Jokers (false)
		// Using the Collections class method to shuffle the deck
		// We can use the Collections class methods because an LinkedList is
		//    a subclass of the Collections class (inheritance of interface)
		Collections.shuffle(deckOfCards);  // Randomize the cards in the deck
	}

}