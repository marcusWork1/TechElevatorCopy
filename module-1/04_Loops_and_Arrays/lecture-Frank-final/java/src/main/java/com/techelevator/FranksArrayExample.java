package com.techelevator;

public class FranksArrayExample {
	
	public static void main(String[] args) {

		System.out.println("Welcome to Frank's Array Example Program");

		// This code is tightly coupled
		// the  code is tied to data - a change to the data requires a change to the code
		//
		// When code is tightly coupled, there are opportunities for error if not all code
		//      affected by the change in data actually changed
		//
		// Tightly should be avoided if possible

		int score1 = 10;
		int score2 = 20;
		int score3 = 30;
		int score4 = 40;  // added this after the code was written
		int score5 = 42;  // added this after the code was written
		int score6 = 56;  // added this after the code was written

		// get the sum of the scores
		int sum;    // hold the sum of the scores
		sum = score1 + score2 + score3 + score4 + score5 + score6; // had to be changed because the data changed

		// get the average of the scores
		int avg;    // hold the average of teh numbers
		avg = sum / 6; // had to be changed because the data changed

		// display the sum and the average of the scores
		System.out.println("The sum of the scores is: " + sum);
		System.out.println("The average of the scores is: " + avg);

	    //----------------------------------------------------------------------------------------
		// Use an array for scores instead of independent variables
		// We can use an array because the scores are all the same datatype
		//
		// Using the array made the code loosely coupled to data
		// Changing data DID NOT require changing the code
		// Fewer opportunities for error when the data changes

		// Define an empty array to hold scores - add elements later
		// size of the array is set when you define it - cannot change the number in array once defined
		//                                               to change size - change code and recompile

//      datatype[]  name = new datatype[number-of-elements]
		int[] scores = new int[5]; // define an empty int array for 5 elements

		// add some data to the elements in the array
		// array-name[index] = value-to-assign-to-the-element
		scores[0] = 10;  // assign the value 10 to the first element
		scores[1] = 20;  // assign the value 20 to the second element
		scores[2] = 30;  // assign the value 30 to the third element
		scores[3] = 14;  // added after program was coded assign the value 30 to the third element
		scores[4] = 24;  // added after program was assign the value 30 to the third element

		// sum all the elements in the array
		int arraySum = 0;  // hold the sum of the array values

		// a for-loop is a great way to process all elements in an array
		// for(loopvar=initial-value; loop-condition; loop-var-modification)
		//
		// The format of the for-loop is pretty much the same every time you process and array
		//    the only thing that usually changes is the name of the array
		//
		//    for(int i=0; i < scores.length; i++)
		//
		// in example: i will be 0, 1, 2 - used to represent the current element in array
		for(int i=0; i < scores.length; i++) {
			arraySum = arraySum + scores[i];  // add the current element to arraySum
		//  arraySum += scores[i];  // alternative code -add the current element to arraySUm
		}
		// display the sum of elements in the arry
		System.out.println("Sum of elems in the array: " + arraySum);

		// display the average of elements in the array
		double arrayAvg = arraySum / scores.length;  // divide the sum by the number of elements
		System.out.println("Sum of elems in the array: " + arrayAvg);

	}  // end of main()
   
} // end of our program's class