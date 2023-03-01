package com.techelevator.myFileProcessingCode;

import java.io.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MyFileProcessor {

	/*********************************************************************************
	 * This program will read each line from the numbers.txt file
	 * and write each number in the line and the sum of those numbers to a file
	 * @throws FileNotFoundException 
	 *********************************************************************************/
	
	public static void main(String[] args) throws IOException {
		
		// Define the input file and Scanner object to read it - file is in the data folder of the project folder
		File myFile = new File("./data/numbers.txt");  // Assign a File object to numbers.txt

		// Check to be sure the File Object is assigned an existing file - terminate if not
		if (!myFile.exists() || !myFile.isFile()) {
			System.out.println("path specified is not an existing file");
			System.exit(16);   // terminate program
		}
		
		Scanner theFile = new Scanner(myFile);         // Assign the File Object to a Scanner

		// define the file to hold the output
		// the file name is associated with file object
		File outputFile = new File("theDataFromProgram");

		// tell java to create the file on disk
		// outputFile.createNewFile();

		// we want to add to the end of an existing file so we define a fileWriter with a "true" attribute
		// and assign it to output file object

		FileWriter aFileWriter = new FileWriter(outputFile, true);

		// then assign filewriter object to bufferedwriter object

		BufferedWriter aBufferWriter = new BufferedWriter(aFileWriter);

		// define a printWriter for the bufferedWriter object
		PrintWriter theDiskFile = new PrintWriter(aBufferWriter);

		// PrintWriter theDiskFile = new PrintWriter(outputFile);
		
		int lineTotal  = 0;  // hold the sum of the numbers in the line we read
		String theLine = ""; // hold the line with the numbers from the file

		// record the time we starting writing to the file
		// Define a timeStamp object to hold the current timestamp

		// localDateTime.now returns local date and time according to computer
		// timestamp.value of gives you a timestamp from localDatetime.
		Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

		theDiskFile.println("-".repeat(5) + timestampNow + "-".repeat(5));
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
					// System.out.println("Input Line Value[" +i+"] is: " + aValue);

					// Write the values form the line to the file
					theDiskFile.println("Input Line Value[" +i+"] is: " + aValue);
				}
				catch (NumberFormatException exceptionObject) {
					System.out.println("Invalid input: \"" + theValues[i] + "\" skipping to next value");
				}
			}
		//    Display the sum of the values
			theDiskFile.println("The sum of the values in the line is: " + lineTotal);
		//    Reset sum before looping again to be sure we only get the sum of the numbers in the line
		    lineTotal = 0;
		}
		// Close the file to avoid a resource leak
		theFile.close();
		theDiskFile.close();
	}
}