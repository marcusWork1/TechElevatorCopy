package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() throws IOException {
		/* Your code goes here */

		// prompt user to search for a file
		System.out.println("Hello, welcome to the program. What is the file you are looking for?");

		String filename = userInput.nextLine();

		// prompt user to enter a word to search for in the file
		System.out.println("What word are you searching for in the file?");
		String theWord = userInput.nextLine();

		// prompt user for choice
		System.out.println("Is this search going to be Case-Sensitive? (Y/N)");
		String choice = userInput.nextLine();

		// choice is N then make word to lower case and set marker as 1
		int marker = 0;
		if(choice.equals("N"))
		{
			theWord = theWord.toLowerCase();
			marker = 1;
		}

		// create bufferedReader object for rile reading
		BufferedReader reading;

		try {
			// open the file
			reading = new BufferedReader(new FileReader(filename));

			// read first line and define it
			String line = reading.readLine();

			// create variable for line number
			int lineNumber = 0;

			// increase line number by 1
			lineNumber++;

			// now do a while loop for the remaining lines
			while (line != null) {

				// check if marker is 1
				if(marker == 1)
				{
					//convert line to lowercase
					String lowerCaseLine = line.toLowerCase();

					// now check and see if line has the given word
					if (lowerCaseLine.contains(theWord)) {
						// if yes, then print line number and line
						System.out.println(lineNumber + ") " + line);
					}
				}
				else {
					// directly check for word in the line
					if(line.contains(theWord)) {
						System.out.println(lineNumber + ") " + line);
					}
				}
				// read next line and increase line number by 1
				line = reading.readLine();
				lineNumber++;
			}
			reading.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
