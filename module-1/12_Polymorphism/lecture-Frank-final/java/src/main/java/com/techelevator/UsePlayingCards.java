package com.techelevator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UsePlayingCards {

	public static void main(String[] args) {
		
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");
		System.out.println("aUSACard is :");
		aUSACard.showCard();

		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES");
		System.out.println("aUSACard2 is :" );
		aUSACard2.showCard();
		
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES");
		System.out.println("aUSACard3 is :");
		aUSACard3.showCard();
			
		AmericanPlayingCard aUSACard4 = new AmericanPlayingCard(11, "Keith");
		System.out.println("aUSACard4 is :");
		aUSACard4.showCard();
		
		ItalianPlayingCard anItalianCard1 = new ItalianPlayingCard(13, "SWORDS");
		System.out.println("anItalianCard1 is :");
		anItalianCard1.showCard();
		
		ItalianPlayingCard anItalianCard2 = new ItalianPlayingCard(9, "COINS");
		System.out.println("anItalianCard2 is :");
		anItalianCard2.showCard();
		
		ItalianPlayingCard anItalianCard3 = new ItalianPlayingCard(11, "Kevin");
		System.out.println("anItalianCard3 is :");
		anItalianCard3.showCard();
		
		SwissPlayingCard aSwissCard1 = new SwissPlayingCard(13, "ROSES");
		System.out.println("aSwissCard1 is :");
		aSwissCard1.showCard();
		
		SwissPlayingCard aSwissCard2 = new SwissPlayingCard(9, "SHIELDS");
		System.out.println("aSwissCard2 is :");
		aSwissCard2.showCard();
			
		SwissPlayingCard aSwissCard3 = new SwissPlayingCard(10, "ACORNS");
		System.out.println("anSwissCard3 is :");
		aSwissCard3.showCard();
			
		SwissPlayingCard aSwissCard4 = new SwissPlayingCard(11, "JASON");
		System.out.println("anSwissCard4 is :");
		aSwissCard4.showCard();		

		System.out.println("-----------------------------------------------");
		System.out.println("   Polymorphism examples start here");
		System.out.println("-----------------------------------------------");

		// To use Polymorphism:
		//   1. Instantiate a reference to the super class
		//   2. Assign subclass object to the super class reference
		//   3. Use the super class reference to run methods

		PlayingCard aCard;      // instantiate a super class reference

		aCard = aUSACard;       // assign a subclass object to the super class reference
		aCard.showCard();       // use the super class reference to run a method

		aCard = anItalianCard1;  // assign a subclass object to the super class reference
		aCard.showCard();        // use the super class reference to run a method

		aCard = aSwissCard3;     // assign a subclass object to the super class reference
		aCard.showCard();        // use the super class reference to run a method


		System.out.println("\nDisplay cards in the ArrayList \n");

		// Define an ArrayList of super class references
		List<PlayingCard> someCards = new LinkedList();

		// Add subclass objects to the super class ArrayList
		someCards.add(anItalianCard1);
		someCards.add(aUSACard);
		someCards.add(anItalianCard3);
		someCards.add(aSwissCard2);

		// Process the ArrayList to run the showCard() method for each object
		for(PlayingCard aPlayingCard : someCards){
			aPlayingCard.showCard();  // This runs the appropriate showCard() method for the class if current element
		}
	}  // End of main()
} // end of class that holds main
