package com.techelevator.myFileProcessingCode;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MyFileProcessor {

	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and write each number in the line and the sum of those numbers to a file
	 * @throws FileNotFoundException and IOException
	 *********************************************************************************/
	
	// throws indicates you know a checked  exception might occur
	//      you may handle it or not
	public static void main(String[] args) throws IOException {

		Timestamp currentTimeStamp = Timestamp.valueOf(LocalDateTime.now());
		System.out.println("Program started at " + currentTimeStamp + "...");
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified is not an existing file");
			System.exit(16);   // terminate program with return code 16; 0==good; not 0==bad
		}
		
		Scanner theFile = new Scanner(myFile);         // Assign the input File Object to a Scanner

		Scanner theKeyboard = new Scanner(System.in);  // define an object represent keyboard

		// Define the file to hold the output
		// Associate a file name with a File object
		File outputFile = new File("theDataFromTheProgram.clayton");

		// Tell Java to create the file on the disk
		//      will destroy an existing copy of the file
		// outputFile.createNewFile();

		// Define a PrintWriter object for the file
		// PrintWriter theDiskFile = new PrintWriter(outputFile);

		// If the output file already exists, ask user if they want to add to it
		boolean addToFile = false;  // hold whether or not to file or not

		if(outputFile.exists()) {
			System.out.println("Output file exists, do you want to add to it (Y / N)");
			String theResponse = theKeyboard.nextLine();
			// convert the response to uppercase and check the first letter
			if(theResponse.toUpperCase().substring(0,1).equals("Y")) {
				addToFile = true;
			}
			else {
				addToFile = false;
			}
		}

		// We want to add to end of existing file - define FileWriter with true
		// and assign it to the File Object
		//                           FileWriter(fileObject, append?) true - append; false - don't append
		FileWriter aFileWriter = new FileWriter(outputFile, addToFile);

		// then assign the FileWriter object to a BufferedWriter object
		// gives us the ability to write to a File
		// BufferedWriter does not allow teh same methods as System.out
		BufferedWriter aBufferWriter = new BufferedWriter(aFileWriter);

		// Define a PrintWriter for the BufferedWriter object
		//     so we can use the same methods as System.out to write data to file
		PrintWriter theDiskFile = new PrintWriter(aBufferWriter);



		int lineTotal  = 0;  // hold the sum of the numbers in the line we read
		String theLine = ""; // hold the line with the numbers from the file

		// Record the time we started writing to the file
		// Define a Timestamp object to hold the current timestamp
		//        a Timestamp is contains the date and time
		//
		// LocalDateTime.now() returns the current date and time according to your computer
		// Timestamp.valueOf() return a Timestamp value for whatever is in ()
		Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

		theDiskFile.println("-".repeat(5)+ timestampNow + "-".repeat(5));
		// theDiskFile.println("------" + timestampNow + "------");

		// Loop through the file one line at a time while there are lines in the file
		while(theFile.hasNextLine()) {
			// Read a line from the file and store it in theLine
			theLine = theFile.nextLine();
			// Break the line up into separate values based on the , separating the value
			String[] theValues = theLine.split(",");
			//    For each value in the line...
			for(int i=0; i < theValues.length; i++) {
				// Convert the individual value from String to numeric so we can add them
				try {
					int aValue = Integer.parseInt(theValues[i]);
					// Add each value from the line to sum
					lineTotal += aValue;

					// Display the values in the line
					//System.out.println("Input Line Value[" +i+"] is: " + aValue);

					// Write the values from the line to the file
					theDiskFile.println("Input Line Value[" +i+"] is: " + aValue);
				}
				catch (NumberFormatException exceptionObject) {
					System.out.println("Invalid input: \"" + theValues[i] + "\" skipping to next value");
				}
			}
		//  Display the sum of the values
		//	System.out.println("The sum of the values in the line is: " + lineTotal);

		// Write the sum of teh values to the disk
			theDiskFile.println("The sum of the values in the line is: " + lineTotal);

		//    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}
		// Close the file to avoid a resource leak
		theFile.close();
		theDiskFile.close();  // force data from output buffer to the disk

		currentTimeStamp = Timestamp.valueOf(LocalDateTime.now());
		System.out.println("Program ended at " + currentTimeStamp + "...");
	}
}