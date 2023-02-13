// everything in java is in a class
// a class is a collection of data and methods to process that data
// a package is a collection of classes for an application
// every class in java is a part of a package

// frequently package names are the URL that uses the package in reverse order
// package name corresponds to the directories that hold the package

// NEVER change the package name in the code
// if you need to change the package name - have intelliJ do it


package com.techelevator; // this identifies the package this code belongs in

import java.util.Scanner;

public class CommandLineSampleProgram { // this class holds all things related to our process

	// every application has a method called main()
	// main is where the processing starts when the application is executed

	// anything belonging to application, must be inside main ()

	// main method must be defined exactly as you see it here. cannot change 	ANYTHING  about main() definition

	public static void main(String[] args) { // the method that starts when application is run

		// java is object oriented language
		// use objects to perform processing
		// to do processing: object.method-name()

		//       object.method()
		// alt syntax you may see Class.out.method() as with system.out.println
		// System.out.println() - use System.out object to run println() method
		
		System.out.println("Welcome to Frank's Command Line Sample Program");

		// command line programming is interacting with a user using keyboard and screen
		// in bash/gitbash/terminal gives you a command line to type in

		// define a scanner object for the keyboard
		// scanner is a class provided by java to get input into the program
		// scanner can get input from several places. keyboard, disk file, etc.

		// a class is a collection of data and methods to process that data, use class like data type
		// to define an object:
		// classname name-of-object = new Classname(optional-parameters)

		// define a scanner object to represent the keyboard in this program

		Scanner userInput = new Scanner(System.in); // system.in is the object java defined for the keyboard
// scanner will return all the characters in a line typed on a computer except the enter key.
		// define a variable to hold the line from the keyboard
		String typedCharacters;

		System.out.println("please enter a line");

		typedCharacters = userInput.nextLine();


		// send a message to the user describing what input you expect ^
		// Display the line we got to be sure we received it correctly

		System.out.println(typedCharacters);

		// when asking for a specific type of data from the user/
		// it is usually better if the program checks the data and finds error

		// receive a string from user and check for validity
		// if it's valid - convert to type we need
		// if it is not valid - issue error message and end program

		System.out.println("please enter a whole number between 0 and 100 ( number without a decimal place");

		// define a variable to hold the number entered by user
		int userNumber;

		// get the number from the human as a string
		String numberFromUser = userInput.nextLine();

		// check what the user entered to be sure it's a valid whole number
		// a valid whole number in a string between "0" and "100"

		// parse will convert one datatype to another
		// Integer.parseInt(aString) - convert the value in the String to an int

		userNumber = Integer.parseInt(numberFromUser); // convert the string entered from keyboard to an int
														// using the Integer class parseInt() method
		// verification, display number we got .
		System.out.println( " you entered " + userNumber);
		// ---------------------------------------------------------
		// get 3 numbers from the human - process repeated multiple times - loop
		// add the numbers to get a sum - a process repeated multiple times - loop
		// get the average of the numbers - process repeated once - NOT a loop

		// 1. analyze problem to be sure i understand the process
		// 2. Identify and define the data needed (variables or objects)
		// 3. write the code

		// Data for the problem
		int numberInput;
		int sum = 0;
		double avg;

		// code the problem solution
		// code the loop to process data
		// we want loop 3 times - use a for loop
		// for(loop-var; loop condition; modification)
		for(int i= 0; i < 3; i++) {
			// get number from human
			System.out.println("Please enter a number");
			// replace the following line to avoid left over code stuck in buffer
			String aNumber = userInput.nextLine(); // get the input as a string
			numberInputted = Integer.parseInt(aNumber);
			// add the numbers to get sum
			sum = sum + numberInputted;
		}

		;// sum += numberInput
		avg = sum / 3;

		System.out.println("The sum of the numbers is " + sum + " and the average of the numbers is " + avg);

		System.out.println("enter your name");
		// java did not wait for the line of input here
		String theName = userInput.nextLine();
		System.out.println("Hello" + theName + " how are you");



	}
}
