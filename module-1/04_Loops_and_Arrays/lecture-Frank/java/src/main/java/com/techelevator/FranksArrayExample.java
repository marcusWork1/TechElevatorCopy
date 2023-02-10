package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {  
		
		System.out.println("Welcome to Frank's Array Example Program"); 


		// this code is what we call "tightly coupled"
		// this means the code is tied to the data. a change in the data requires a change to the code.
//
		// when code is tightly coupled, there are opportunity for error if not all code is affected by the change in data.
		//
		// tightly coupled code should be avoided if possible.

		// arrays can make code loosely coupled, not tight.
		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 40;
		int score5 = 42;
		// get the sum of the scores
		int sum; // holds the sum of the scores
		sum = score1 + score2 + score3 + score4 + score5; // had to be changed because the data changed and added more.

		// get teh average of the scores
		int average;
		average = sum / 5;

		// display the sum and average of the scores
		System.out.println("The sum of the scores is " + sum + " and the average is " + average);
// ----------------------------------------------------------------------------------------------
		// use array for scores instead of independent variables
		// we can use array because scores are same data type

		// define empty array to hold scores. add elements later
		// size of array is set when you define it - cannot change size after its defined.
													// to change size - change code and recompile

	// datatype[] name = new datatype[number-of-elements]
		int[] scores = new int[3]; // define an empty int array for 3 elements

		// add some data to elements in array
		// array-name[index] = value to assign to the element
		scores[0] = 10;// assign the value of 10 to first element
		scores[1] = 20;// assign 20 to second element
		scores[2] = 30;// assign 30 to third element

		// sum the elements in the array
		int arraySum = 0; // holds sum of array value

		// a for-loop is a great way to process all elements in array
		// for(loopvar=initial-value; loop-condition; loop-var-modification)
		for(int i = 0; i < scores.length; i++) {
			arraySum = arraySum + scores[i]; // add the current element to arraySum

		}

		System.out.println("som of the elems in array" + arraySum);

		double arrayAvg = arraySum / scores.length;
		System.out.println("Avg of elems" + arrayAvg);
	} // end of main


   
}// end of class