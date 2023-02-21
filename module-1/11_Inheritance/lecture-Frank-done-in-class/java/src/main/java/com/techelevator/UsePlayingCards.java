package com.techelevator;

import Cards.ItalianPlayingCard;

public class UsePlayingCards {

	public static void main(String[] args) {
		System.out.println("\nInstantiating aUSACard as an ace of Hearts");
		//                                                  value, suit
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");  // Instantiate an Ace of Hearts
		System.out.println("aUSACard is : \n" + aUSACard);

		// change the value in the existing aUSACard object
		System.out.println("\nChange the value in aUSACard to a 6");
		aUSACard.setValue(6);  // Use the super class method for the subclass to change the data
		System.out.println("aUSACard is : \n" + aUSACard);

		System.out.println("\nInstantiating aUSACard2 with a value that exceeds maximum");
		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES"); // Value exceeds maximum
		System.out.println("aUSACard2 is : \n" + aUSACard2);

		System.out.println("\nInstantiating aUSACard3 with a value that is below minimum");

		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES"); // Value less than minimum
		System.out.println("aUSACard3 is : \n" + aUSACard3);	

		System.out.println("\nComparing aUSACard2 and aUSACard3");
		
		if (aUSACard2.equals(aUSACard3)) {
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
		}

		ItalianPlayingCard donCorleone = new ItalianPlayingCard(1,"Coins", "Yellow");
		System.out.println("donCoreleone is:\n " + donCorleone);

		ItalianPlayingCard diNiro = new ItalianPlayingCard(10, "Swords", "Blue");
		System.out.println("diNiro is:\n " + diNiro);

		// this is using the super class .equals method
		if(donCorleone.equals(diNiro)) {
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
		}

	} // end of main()
} // end of class holding main()
