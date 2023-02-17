package com.techelevator;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //
        // An Application Program instantiate, manipulate and use objects of classes
        //
        // An Application Program App always has exactly one method called main()
        //
        // The main() method controls processing for the application
        //
        // main() is the first method executed when an App is run
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        */
	        // To instantiate an object of a class:  class-name object-name = new class-name();

            // Instantiate a default PlayingCard
            PlayingCard aCard = new PlayingCard();  // run the default ctor for class

            // Instantiate a PlayingCard with specific values
            PlayingCard card2 = new PlayingCard(13, "hearts", "Red", true);

            // Display a PlayingCard
            System.out.println(aCard);  // Display a PlayingCard
            // System.out.println() - displays Strings
            // Whatever you give to System.out.println() between the () must be a String
            // If it is not a String, Java will try to convert it to a String
            // aCard is a PlayingCard class object - not a String
            // Java will try to convert a PlayingCard to a String using a toString() method
            // A toString() method is a method in a class to return an object as a String
            // When Java is looking for a method for an object it looks:
            //    1. In the class of the object
            //    2. Any class the class object is a part of
            //  if it can't find a method anywhere in the class hierarchy, a compile error occurs
            //
            // System.out.println(aCard);
            //     1. Look in PlayingCard class for a toString() method - IT found one, so it runs it
            //     2. Look in the next higher class to PlayingCard for a toString()
            //         next higher class is the Object class, which has a toString() method
            //              so the Object class toString() method is run
            //        the Object class toString() returns "packagename.classname.@memory-location"
            //     3. If no toString() method was found in class hierarchy, we get a compile error

	}
}
		 

