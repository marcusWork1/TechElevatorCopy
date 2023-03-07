package com.techelevator.menu;
/***********************************************************************************
 * This will demonstrate how to use the Menu process given to
 * students in the Tech Elevator Java bootcamp:
 * 
 * 
 * The menu process requires a array of Strings containing the options to be 
 * presented to the user.  So any array of Strings can be used for the options.
 * ie. the array of Strings may be created using literals, constants, loaded from a file
 *     or any other method you can contrive to create an array of Strings
 * 
 * 
 * General use directions:
 *   
 * 1. Define an array of Strings to hold options for each Menu.
 *    
 *    
 * 2. Call the getChoiceFromOptions() method in the provided Menu class,
 *    passing it the array of Strings containing the menu options
 *    to display the menu options and get the option choice from the user.
 *    (ie. getChoiceFromOptions(name-of-array-of-Strings)
 * 
 *      The getChoiceFromOptions() method will:
 * 
 *         a. Display the elements of the menu option array of Strings passed to it
 *            as numbered menu options
 *            
 *         b. Ask the user to pick one by number
 *         
 *         c. return the element from the array of Strings passed to it
 *            for the option number the user picked 
 *            
 * 3. To determine what option was chosen by the user compare the String returned from 
 *    the getChoiceFromOptions() method with elements in the array of Strings passed to 
 *    getChoiceFromOptions().  When a match is found, process the option accordingly
 *    
 ************************************************************************************/ 
 
import com.techelevator.view.Menu;  // Menu processing class

public class UseMenuCLI {  // Class representing the MenuCLI process to be used

	public static void main(String[] args) {
//							keyboard	, screen
		Menu menu = new Menu(System.in, System.out);  // Define Menu object with input and output sources (keyboard, screen)		

		/********************************************************************************
		 * Define String constants for the menu option text/choices
		 * named constants are a good idea s they make the code easier
		 * to follow and use
		 *******************************************************************************/

		final String MAIN_MENU_OPTION_1 = "Pizza";
		final String MAIN_MENU_OPTION_2 = "Taco";
		final String MAIN_MENU_OPTION_3 = "Noodles";
		final String MAIN_MENU_OPTION_4 = "subMenu";
		final String MAIN_MENU_OPTION_EXIT = "Exit";
		final String SUB_Menu_Option_1 = "corn";
		final String SUB_Menu_Option_2 = "eggs";
		final String SUB_MENU_OPTION_EXIT = "Exit";

		/**********************************************************************
		 * Define array of String constants representing the menu option 
		 * text/choices to be displayed to the user using constants
		 **********************************************************************/

		final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_1,
				MAIN_MENU_OPTION_2,
				MAIN_MENU_OPTION_3,
				MAIN_MENU_OPTION_EXIT};

		final String[] subMenu = {SUB_Menu_Option_1,
				SUB_Menu_Option_2,
				SUB_MENU_OPTION_EXIT};


		/********************************************************************************
		 * Define array of String constants representing the menu option 
		 * text/choices to be displayed to the user using literals.
		 *
		 * Note: named constants need not be used, but may make use of the
		 *       menu more difficult.
		 ********************************************************************************/

		final String[] INSTRUCTOR_OPTIONS = {"Frank",
				"Jason",
				"Josh",
				"Craig",
				"Dan",
				"Brett",
				"End Process"
		};

		boolean shouldLoop = true;  // Loop control variable

		// main processing loop - independent of the menu class processing
		while (shouldLoop) {         // Loop while loop control variable is true

			/****************************************************************************
			 * Define a String variable to hold user menu choice & display menu to get it
			 *
			 * getChoiceFromOptions will:
			 * (pass it the String Array of options)
			 *
			 *  1. Display the elements of  the menu option String array passed to it
			 *  2. Ask the user to pick one
			 *  3. return the constant defined in the menu option String array passed 
			 *          to it for the option the user picked    
			 ****************************************************************************/

			String choice = (String) menu.getChoiceFromOptions(INSTRUCTOR_OPTIONS);

			/****************************************************************************
			 * Examine choice made and process accordingly
			 ****************************************************************************/

			switch (choice) {
				case "Brett": {  // Actual wording of the option
					// process for option "Brett" choice - good place for a method call
					break;
				}
				case "Jason": {
					// process for option "Joe" choice - good place for a method call
					break;
				}
				case "Frank": {
					// process for option "Frank" choice - good place for a method call
					break;
				}
				case "Josh": {
					// process for option "Josh" choice - good place for a method call
					break;
				}
				case "Dan": {
					// process for option "Dan" choice - good place for a method call
					break;
				}
				case "Craig": {
					// process for option "Craig" choice - good place for a method call
					break;
				}
				case "End Process": {
					// do any end of loop processing
					shouldLoop = false;
					break;
				}
			}

		}

		/****************************************************************************
		 * Define a String variable to hold user menu choice & display menu to get it
		 *
		 * getChoiceFromOptions will:
		 *
		 *  1. Display the elements of  the menu option String array passed to it
		 *  2. Ask the user to pick one
		 *  3. return the constant defined in the menu option String array passed 
		 *          to it for the option the user picked    
		 ****************************************************************************/


		shouldLoop = true;
		while (shouldLoop) {         // Loop while loop control variable is true

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			/****************************************************************************
			 * Examine choice made and process accordingly
			 ****************************************************************************/
			switch (choice) {
				case MAIN_MENU_OPTION_1: {  // use the constant for the menu choice to test what was selected
					// process for option 1 choice - good place for a method call
					break;
				}
				case MAIN_MENU_OPTION_2: {
					// process for option 1 choice - good place for a method call
					break;
				}
				case MAIN_MENU_OPTION_3: {
					// process for option 1 choice - good place for a method call
					break;
				}
				case MAIN_MENU_OPTION_4: {

				 static subMenuProcessing(menu, subMenu);
				}
				case MAIN_MENU_OPTION_EXIT: {
					// do any end of loop processing
					shouldLoop = false;
					break;
				}
			}

		}

		System.out.println("\n*************************************");
		System.out.println("   Thanks for your participation");
		System.out.println("       Have a Java-rific day!");
		System.out.println("*************************************");

		public static void subMenuProcessing (Menu aMenu, String[]subMenu){
			String subMenuChoice = (String) aMenu.getChoiceFromOptions(subMenu);
			System.out.println("You chose" + subMenuChoice);
			switch (subMenuChoice) {
				case ("sub-option1"): {
					// sub option 1 process
				}
				case ("suboption2"): {
					// sub option 2 process
				}
			}
		}
	}
}




