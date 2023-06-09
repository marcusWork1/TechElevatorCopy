package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * WordSearch
 * 
 * Part 1
 * 
 * Write a program that, given a search string and a path for a text file, searches the file for occurrences of
 * the search string and each time it finds the search string, displays the line number and contents of the line it was found 
 * in on the console.
 * 
 * The output would start with:
 * 1) Project Gutenberg's Alice's Adventures in Wonderland, by Lewis Carroll
 * 9) Title: Alice's Adventures in Wonderland
 * 43) [Illustration: "Alice"]
 * 
 * Part 2
 * 
 * Modify the program to ask the user if the search should be case-sensitive.
 * 
 * The output should change to:
 * 1) Project Gutenberg's Alice's Adventures in Wonderland, by Lewis Carroll
 * 9) Title: Alice's Adventures in Wonderland
 * 41) ALICE'S ADVENTURES IN WONDERLAND
 * 43) [Illustration: "Alice"]
 */
public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */
		try (userInput) {

			// Get the path of the input file
			System.out.println("What is the file that should be searched?");
			String path = userInput.nextLine();
			File inputFile = new File(path);
			if (!inputFile.exists()) {
				System.out.println(path + " does not exist");
				System.exit(1); // Ends the program
			}
			if (!inputFile.isFile()) {
				System.out.println(path + " is not a file");
				System.exit(1); // Ends the program
			}

			// Get the search word from the user
			System.out.println("What is the search word you are looking for?");
			String searchWord = userInput.nextLine();
			if ((searchWord == null) || (searchWord.isEmpty())) {
				System.out.println("The search word is empty");
				System.exit(1);
			}
			
			// Ask if the search should be case-sensitive
			System.out.println("Should the search be case sensitive? (Y\\N)");
			boolean caseSensitive = userInput.nextLine().toLowerCase().equals("y");

			// Perform word search
			int lineNumber = 1;
			try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())){
				while (inputScanner.hasNextLine()) {
					String line = inputScanner.nextLine();
					if (!caseSensitive) {
						if (line.toLowerCase().contains(searchWord.toLowerCase())) { // lower-case strings to make case-insensitive
							System.out.println(lineNumber + ") " + line);
						}
					}
					else {
						if (line.contains(searchWord)) {
							System.out.println(lineNumber + ") " + line);
						}
					}
					lineNumber += 1;
				}
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
