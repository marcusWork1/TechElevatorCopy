package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() throws FileNotFoundException {
		/* Your code goes here */

		// first ask for the destination file

		System.out.println("what is the destination file?");
		String destinationFile = userInput.nextLine();


		try {
// create a new file with given filename
			PrintWriter writer = new PrintWriter(destinationFile);

// loop from 1 to 300(inclusive)
			for(int n=1;n<=300;n++)
			{
				if(n%3 == 0 && n%5 == 0) // n is divisible by 3 and 5, output "FizzBuzz" to file
					writer.println("FizzBuzz");
				else if(n%3 == 0 || (n+"").contains("3")) // n is divisible by 3 or n contains 3, output "Fizz"
					writer.println("Fizz");
				else if(n%5 == 0 || (n+"").contains("5")) // n is divisible by 5 or n contains 5, output "Buzz"
					writer.println("Buzz");
				else // else output n
					writer.println(n);
			}

			writer.close(); // close the file


		} catch (FileNotFoundException e) {
// invalid destination file, display error and exit
			System.out.println("ERROR: Invalid destination file.");
		}
	}

//		// create new file with given name
//		try {
//			PrintWriter newFile = new PrintWriter(destinationFile);
//
//			// loop from 1-300
//			for (int i = 0; i < 300; i++)
//			{
//				if(i%3 == 0 && i%5 == 0) { // i is divisible by 3 and 5
//					newFile.println("FizzBuzz");
//				} else if (i%3 == 0) { // i is divisible by 3
//					newFile.println("Fizz");
//			} else if ((i % 5) == 0) { // i is divisible by 5
//					newFile.println("Buzz");
//				} else { newFile.println(i);; // is is not divisible by 3 or 5
//				}
//			} newFile.close();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}



	}

