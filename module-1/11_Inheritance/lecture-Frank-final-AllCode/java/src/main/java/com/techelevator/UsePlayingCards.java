package com.techelevator;

public class UsePlayingCards {

	public static void main(String[] args) {
		System.out.println("Instantiating aUSACard as an ace of Hearts");
		AmericanPlayingCard aUSACard  = new AmericanPlayingCard(1, "HEARTS");  // Instantiate an Ace of Hearts
		System.out.println("aUSACard is : \n" + aUSACard);
		
		System.out.println("Instantiating aUSACard2 with a value that exceeds maximum");
		AmericanPlayingCard aUSACard2 = new AmericanPlayingCard(14, "SPADES"); // Value exceeds maximum
		System.out.println("aUSACard2 is : \n" + aUSACard2);

		System.out.println("Instantiating aUSACard3 with a value that is below minimum");
		AmericanPlayingCard aUSACard3 = new AmericanPlayingCard(-1, "SPADES"); // Value less than minimum
		System.out.println("aUSACard3 is : \n" + aUSACard3);	

		System.out.println("Cloning aUSACard4 from aUSACard3");
		PlayingCard aUSACard4 = aUSACard3.clone();
		System.out.println("aUSACard4 is : \n" + aUSACard4);
		
		System.out.println("Comparing aUSACard3 and aUSACard4");
		
		if (aUSACard3.equals(aUSACard4)) {
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
		}

		System.out.println("\nComparing aUSACard2 and aUSACard3");
		
		if (aUSACard2.equals(aUSACard3)) {
			System.out.println("They are equal");
		}
		else {
			System.out.println("They are NOT equal");
		}

		System.out.println("Instantiating ItalianPlayingCard as an Ace of CUPS");
		ItalianPlayingCard donCorleone = new ItalianPlayingCard(1, "CUPS");
		donCorleone.showCard();

		System.out.println("Instantiating ItalianPlayingCard as an 8 of SWORDS (8 is invalid value)");
		ItalianPlayingCard deNiro = new ItalianPlayingCard(8, "SWORDS");
		deNiro.showCard();
	}

}
