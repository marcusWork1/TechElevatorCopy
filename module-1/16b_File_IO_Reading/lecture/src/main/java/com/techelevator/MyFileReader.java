package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {
    public static void main(String[] args) throws FileNotFoundException {
        File textDocument = new File("./myData/numbers.txt");

        Scanner dataInFile = new Scanner(textDocument);

        while (dataInFile.hasNextLine()) { // loop while data in file has next line
            String aLine = dataInFile.nextLine(); // get a line from file
            // sum the numbers in the line
            // break the line into individual numbers
            // convert each number from string into an int, one at a time, so i can add it

            int sum = 0;
            String[] theNumbers = aLine.split(" "); // split the values in the line based on spaces

            for (String aNumber : theNumbers) {
                try {
                    sum = sum + Integer.parseInt(aNumber);
                } catch (NumberFormatException exceptionObject) {
                    // an Exception Object is passed to the catch - name whatever you want
                    // it contains information about the exception and methods you might use in exception handling

                    System.out.println("Invalid entry" + aNumber);
                }
            }
            System.out.println("Line is: " + aLine + "sum of numbers: " + sum);
        }

    }
}


