package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {

	// given a file with bank routing numbers, verify the routing numbers are valid
	// we are using a method given to us that determines ifa  routing numbers is valid
	// we

	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args)  throws FileNotFoundException {
		// throws - Tell the compiler I know this checked exception can happen
		printApplicationBanner();

		File inputFile = getInputFileFromUser();   // inputFile is a File object for an existing file

		try(Scanner fileScanner = new Scanner(inputFile)) {

			while(fileScanner.hasNextLine()) {         // Loop while the file has another line
				String line = fileScanner.nextLine();  //     Read the next line into the variable line
				String rtn = line.substring(0, 9);     //     Get the first 9 chars of the line read
				System.out.print("RTN : " + rtn);      //     Display the routing number to the usewr
				if(checksumIsValid(rtn) == false) {    //     If the routing number if invalid...
					System.out.println(" - Invalid");  //          print an Invaild message
				}
				else {                             //     if the routing number is valid...
					System.out.println(" - Valid");//          print the Valid message
				}                                      //     end of If
			}                                          // End of the while()
		}                 // End of try block

	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
	private static File getInputFileFromUser() {
		Scanner userInput = new Scanner(System.in);                // Define a keyboard object
		System.out.print("Please enter path to input file >>> ");  // Prompt the user
		String path = userInput.nextLine();                        // Get a line from the keyboard

		System.out.println("Path entered: "+ path + "\n");

		File inputFile = new File(path);        // Define a File object for the input file

		if(inputFile.exists() == false) {               // checks for the existence of a file
			System.out.println(path+" does not exist"); // If not - message the user
			System.exit(1); // Ends the program         // Terminate the program with a return code 1
		} else if(inputFile.isFile() == false) {        // If it does exist, check to see if it's a file
			System.out.println(path+" is not a file");  // if not a file - message the user
			System.exit(1); // Ends the program         // terminate program with a return code 1
		}
		return inputFile;      // we have a File object that exists and IS a file - so return it
	}

	// method for validating routing numbers

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
