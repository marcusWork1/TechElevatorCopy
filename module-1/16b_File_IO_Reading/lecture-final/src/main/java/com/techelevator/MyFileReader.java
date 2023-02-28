package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {

    // Every Java application must have a method called main()

    // throws on the method signature tells Java you know that a checked Exception might occur
    //        you don't have to handle the Exception, just acknowledge it might occur
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Welcome to Franks File Reading Program");

        // Read in the file called numbers.txt and display each line

        // Define a File object to represent the file in the program
        // File objectName = new File("path-to-the file");
        //
        // "path-to-the-file" may be absolute or relative
        //
        //      absolute - code all parts of the path for the file
        //
        //      relative - code the parts of the path relative to where you are now
        //                 Java assumes application is relative to the project folder
        //                 (lecture or exercise folder for class applications)
        //
        // relative paths are preferred because absolute paths are specific to
        //          a computer containing the application.
        //
        // ~/workspace/your-name-student-code/module-1/16b_File_IO_Reading/lecture/numbers.txt
        //     only works on computers with that exact directory structure
        //
        // ./numbers.txt
        //      work on any computer where numbers.txt is in the project folders
        //

        // Define a File object to represent the file in the program
        File textDocument = new File("./myData/numbers.txt");

        // Define a Scanner object for the File object
        Scanner theDataInTheFile = new Scanner(textDocument);

        // Go through each line in the file display it and teh sum of the numbers in the line
        //   1. Get a line from the file
        //   2. Display it

        // Go through each line in the file and display it
        // while(condition) - loop while condition is true
        while(theDataInTheFile.hasNextLine()) { // Loop while the file has a nextLine
             String aLine = theDataInTheFile.nextLine();   // Get a line from the file
             // Sum the numbers in the line
             int sum = 0;  // hold the sum of the numbers
             // break the line into the individual numbers
             String[] theNumbers = aLine.split(" "); // Split the value in teh line based on a space
             // convert each number from a String to an int, one at a time, so I can add it
            // for-each - is shorthand for loop
            //    it runs through the array ro ArrayList one element at a time
            //       assiging  the current element to the name you gave it
            //    datatype
            //    name-for-element : array or ArrayList
             for(String aNum : theNumbers) {  // for (int i=0; i<theNumber.length; i++) {
                 try {  // Since we might get a NumberFormatException, we will trap/catch it
                        //       allow program to continue
                     sum = sum + Integer.parseInt(aNum); // Integer.parseInt(aNum[i])
                 }
                 catch (NumberFormatException exceptionObject) {
                     // an Exception object is passed to the catch - name it whatever you want
                     // it contains information about the Exception and methods you might use
                     //             in your Exception handling
                     exceptionObject.printStackTrace(); // display the call stack (series of methods up to exception)
                     System.out.println("Invalid numeric value: " + aNum);
                     System.out.println("Skipping to next value");
                     exceptionObject.printStackTrace(); // display the call stack (series of methods up to exception)
                     System.out.println("Java says, this is the problem: " + exceptionObject.getMessage());
                 }
             }  // end of for loop
             System.out.println("Line is: " + aLine + " sum of numbers: " + sum);      // Display it
        }
    }
}
