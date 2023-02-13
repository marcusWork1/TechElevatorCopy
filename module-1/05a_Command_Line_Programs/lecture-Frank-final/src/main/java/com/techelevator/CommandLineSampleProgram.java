// Everything in Java is in a Class
// A Class is a collection of data and methods to process the data
// A package is a collection of Classes for an application
//   every class in Java is part of a package

// Frequently package names are the URL that uses the package in reverse
// package name corresponds to the directories that hold the package components

// NEVER change the package name in the code!!
// If you need to change the package name - have Intellij do it
//                                          or get someone experienced to help

package com.techelevator;  // This identifies the package this code belongs in

// NEVER change the Class name in the code!!
// If you need to change the package name - have Intellij do it
//                                          or get someone experienced to help

import java.util.Scanner;

public class CommandLineSampleProgram { // This Class hold all things related to our process

	// Every application contains a method called main()
	// main() is where processing starts when the application is executed
	//
	// anything belonging to the application must be defined inside main()
	//    (inside the {} defining the body of main)
	//
	// the main method must be defined exactly as you see it here
	public static void main(String[] args) { // method that starts when the application is run

		// Java is Object Oriented language
		// Use Objects to perform processing
		// To do processing:  object.method-name()
		//
		//         Object.method()
		//   Class.object.method()
		//   System.out.println() - Use the System.out object to run println() method

		// Use the System.out object to print a line to the screen
		System.out.println("Welcome to Frank's Command Line Sample Program");

		// Command line programming is interacting with a human using the keyboard and screen
		// In bash/GitBash/Terminal gives you a command line in which to type

		// Define a Scanner object for the keyboard
		// Scanner is a class provided by Java to get input into a program
		//         Scanner can get input from several places - keyboard, disk file, et al
		//
		// A class is a programmer defined datatype
		// Use a class just like any other data type
		//
		// to define and int:
		//   int variable-name;
		//
		// To define an object:
		//   Classname name-of-object = new Classname(optional-parameters)

		// Define a Scanner object to represent the keyboard in this program
		Scanner userInput = new Scanner(System.in);  // System.in is the object Java defined for keyboard

		// Get a line of input from the keyboard
		//     a line is a series of characters typed on the keyboard followed by enter key
		//     Scanner will return all the characters in the line EXCEPT the enter key

		// Define a variable to hold the line from the keyboard
		String aLine;

		// Send a message to the human describing what ijkhanput you expect
		System.out.println("Please enter a line");

		// Get a line from teh keyboard and store it in our String variable
		aLine = userInput.nextLine();

		// For verification: Display the line we got to be sure we received it correctly
		System.out.println(aLine);

		// When asking for a specific type of data from the human
		//      it is usually better if the program checks the data and finds the error that letting Java do it
		//
		// since we don't know what the human will type and all characters are valid for Strings
		// Receive a String from the user and check for validity
		//    if it's valid - convert to the type we need
		//    if it's not valid - issue an error message and end the program gracefully

		// Send a message to the human describing what input you expect
		System.out.println("Please enter a whole number between 0 and 100 (number with out decimal places");

		// define a variable to hold the number entered by the human
		int userNumber;

		// Get the number from the human as a String
		String numberFromHuman = userInput.nextLine();

		// Check what the human entered to be sure it's a valid whoe number
		// A valid whole number in a String between "0" and "100"

		// parse will convert one datatype to another
		// Integer.parseInt(aString) - convert the value in the String to an int

		userNumber = Integer.parseInt(numberFromHuman); // Convert the String entered from keyboard to an int
		                                                //     using the Integer class parseInt() method

		// For verification: Display the number we got to be sure we received it correctly
		System.out.println("You entered: " + userNumber);

		//-----------------------------------------------------------------------------------
		// Get 3 numbers from the human - a process that is repeated multiple times - a loop
		// Add the numbers to get a sum - a process that is repeated multiple times - a loop
		// Find the average of the numbers - a process is done once - NOT a loop

		// 1. analyze problem to be sure I understand the process
		// 2. Identify and define the data needed (variables or objects)
		// 3. Write the code

		// Data for problem
		int    numberInputted;
		int    sum = 0;
		double average;

		// code the problem solution

		// code the loop to process the data
		// we know we want loop 3 times - use a for-loop when you know how many times loop
		// for(loop-var=initial-value; loop-condition; modification)
		// i < 4 - i=0-loop, i=1-loop, i=2-loop, i=3-loop, i=4-no-loop - loop 4 time
		// i < 3 - i=0-loop, i=1-loop, i=2-loop, i=3-no-loop - loop 3 time
		// if you start the loop-var at 0, the condition is loop-var < the-number-of-times-to-loop
		// if you start the loop-var at 1, the condition is loop-var <= the-number-of-times-to-loop
		// if you start the loop-var at 1, the condition is loop-var < the-number-of-times-to-loop+1
		for(int i=0; i < 3; i++){
			// get a number from the human
			System.out.println("Please enter a number");
			// Replaced the following line to avod left over data in the buffer that might cause an issue
			// numberInputted = userInput.nextInt();// get the number from the keyboard

			String aNumber = userInput.nextLine();       // Get the input as a Sting
			numberInputted = Integer.parseInt(aNumber);  // Convert the String input to an int

			// Alternate technique to get a number and clear keyboard
			//numberInputted = userInput.nextInt(); // get the number from the keyboard
			//userInput.nextLine();                 // Clear the keyboard buffer of teh enter left by nextInt();

			// Add the number to sum;
			sum = sum + numberInputted; // sum += numberInputted;
		}
		System.out.println("The average of the numbers is " + (sum / 3));

		System.out.println("Enter your name: ");
		// Java did not wait for the line of input here
		String theName = userInput.nextLine();
		System.out.println("Hello " + theName + " how are you?");

	} // end of main
}  // end of the Class
