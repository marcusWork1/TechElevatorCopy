package com.techelevator;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class IntroToClassesCard {
        //------------------------------------------------------------------------------------------------------------
        // Application program for the Intro To Classes App
        //------------------------------------------------------------------------------------------------------------
        public static void main(String[] args) {
        /*
        *  This program will demonstrate several concepts presented in the Java cohort
        *  in the topic Introduction to Classes 		
        */
            // instantiate a default playing card
	PlayingCard aCard = new PlayingCard();

    // instantiate a playing card with specific values
            PlayingCard card2 = new PlayingCard(13, "hearts", "Red", true);

            // display a playing card

            System.out.println(aCard); // display a playing card
	}


}
		 

