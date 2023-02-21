package com.techelevator;

public class IntroToClassesCard {
	
	//*****************************************************************************
	// This is the application program - where processing starts for our app
	//
	// main() is the starting method of all applications
	//
	// There can only be one main() in an application - that's why it's static
	//
	// The class that contains main() is the application
	//*****************************************************************************
	// public - anyone can access
	// static - only one instance and it's shared
	// void   - return type - void it returns nothing
//  access        return name(parameters)
	public static void   main(String[] args) {
        
        /*
         *  This program will demonstrate several concepts presented in the Java Cohort
		 *  in the topic Introduction to Classes 		
        */

		// I want to instantiate a new Pet
		Pets Buddy = new Pets(4,"Buddy","Dog","Frank","Beagle");
		System.out.println(Buddy);


		System.out.println("Executing: PlayingCard aCard = new PlayingCard();\n");

		// I need a PlayingCard
		PlayingCard aCard = new PlayingCard();   // Instantiate a default PlayingCard
		                                         // Default (0-arg) ctor is run

		// I need to see what values are in my PlayingCard
		aCard.showCard();                        // Use the PlayingCard object to run the ShowCard() method

		System.out.println(aCard);  // Java will use a toString() method convert a PlayingCard to a String
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		System.out.println("Executing: PlayingCard theCard = new PlayingCard(8,Spades,Green,true);\n");

		// I need an 8 of Spades

		PlayingCard theCard = new PlayingCard(8,"Spades","Green",true);   // Instantiate a new PlayingCard
		                                                                  // using the 4-arg ctor
		
		theCard.showCard();                       // Use the PlayingCard object to run the ShowCard() method
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		System.out.println("Executing: PlayingCard myCard = new PlayingCard(1,Spades);\n");
		
		PlayingCard myCard = new PlayingCard(1,"Spades");         // Instantiate a new PlayingCard 
		
		myCard.showCard();                       // Use the PlayingCard object to run the ShowCard() method                                                // using the 2-arg ctor

        System.out.println("-----------------------------------------------------------------------------------");
		
        System.out.println("Executing: PlayingCard myCard = new PlayingCard(14,Diamonds);\n");
		
		PlayingCard yourCard = new PlayingCard(14,"Diamonds");    // Instantiate a new PlayingCard with invalid value
                                                                  // using the 2-arg ctor

        yourCard.showCard();                       // Use the PlayingCard object to run the ShowCard() method

        System.out.println("-----------------------------------------------------------------------------------");
        
        System.out.println("myCard's value is: " + myCard.getValue());    // Use the PlayingCard method to retrieve
		                                                                  //     the card value in the object

		System.out.println("Change the value in myCard to 13");
		myCard.setValue(13);  // Use the member method to change the value in value
		System.out.println("myCard's value is: " + myCard.getValue());

		System.out.println("Change the value in myCard to -46");
		myCard.setValue(-46);  // Use the member method to change the value in value
		System.out.println("myCard's value is: " + myCard.getValue());

		System.out.println("Change the suit in myCard to Brian");
		myCard.setSuit("Brian");  // Use the member method to change the suit
		System.out.println("myCard's suit is: " + myCard.getSuit());

		System.out.println("-----------------------------------------------------------------------------------");

		// Determine if card value makes it a face card
		// Using a member method of PlayingCard
				
		System.out.println("Card value is: " + myCard.getValue() + " which means face card is " + myCard.isFaceCard());
		System.out.println("Changing card value to 13");
		myCard.setValue(13);
		System.out.println("Card value is: " + myCard.getValue() + " which means face card is " + myCard.isFaceCard());
			
		System.out.println("-----------------------------------------------------------------------------------");

		// Flip the card - if it's face up it should be made face down and vice-versa
		// Using a member method of PlayingCard
		
		System.out.println("   Right now, Is the card face up? " + theCard.isShowing());
		theCard.flip();          // run the flip() method on a PlayingCard object
		System.out.println("After flip(), Is the card face up? " + theCard.isShowing());
		
		System.out.println("-----------------------------------------------------------------------------------");

		PlayingCard kirksCard    = new PlayingCard(0, "Hearts"); // Define a joker of hearts
		PlayingCard picardsCard  = new PlayingCard(0, "Hearts"); // Define a joker of hearts

		// == compares the locations of reference variables - objects are reference variables
		// so == can't be used to compare two objects (kirksCard and picardsCard are objects)
		System.out.println("is kirksCard equal to picardsCard using ==? " + (kirksCard == picardsCard));

		// if we want to be able to compare two objects the class MUST provide a method to do so
		// Java does not how to compare two objects using .equals - compares locations not contents
		// If the PlayingCard class has a .equals(), it will used to do the compare
		System.out.println("is kirksCard equal to picardsCard using .equals? " + (kirksCard.equals(picardsCard)));

		System.out.println("is kirksCard equal to myCard using .equals? " + (kirksCard.equals(myCard)));




	}  // end of main()
} // End of class holding main()
		 

