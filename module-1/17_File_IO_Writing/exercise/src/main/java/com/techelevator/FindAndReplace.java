package com.techelevator;

import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() throws IOException {
        /* Your code goes here */

        // ask for the search word and replacement word to establish those attributes

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replacementWord = userInput.nextLine();

        // ask for file path and assign teh file a variable
        System.out.println("Enter the path of a file");
        String path = userInput.nextLine();
        // File ourFile = new File(path);
//        if (!ourFile.exists()) {
//            System.exit(1);
//            System.out.println("We could not find your file, have a good day");
//        } else

//      Destination of file
        System.out.println("Enter the path to the files new destination.");
        String destinationFilePath = userInput.nextLine();
        //File fileDestination = new File(destinationFilePath);
//        if (!fileDestination.exists()) {
//            System.exit(1);
//        System.out.println("We could not find your destination, have a good day"); }
//        else


        try {
            // create filewriter object
            FileWriter newFile = new FileWriter(destinationFilePath);


            // create bufferedwriter object
            BufferedWriter fileNew = new BufferedWriter(newFile);

            // Create Scanner object
            Scanner readFile = new Scanner(new File(String.valueOf(path)));

            // check next line present or not
            while (readFile.hasNextLine()) {

                // read each line
                String firstLine = readFile.nextLine();

                // write data to destination file
                fileNew.write(firstLine.replace(searchWord, replacementWord));
                fileNew.newLine();
            }
            fileNew.close();
            readFile.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//
//        // now that i have a file object, i can use it to find things related to/inside of the file
//
//        //inspecting the file system
//
//        // see if the file exists, if not, exit program
//        if (ourFile.exists()) {
//            System.out.println("We have found your file.");
//
//            // scanner object to read file
//           // Scanner readFile = new Scanner(ourFile);
//
//            // use buffered reader to file read
//            BufferedReader reader;
//            try
//            { reader = new BufferedReader(new FileReader(ourFile));
//
//            // read first line
//                String firstLine = reader.readLine();
//
//                // create a variable for line number
//                int lineNumber = 0;
//
//                // see if first line contains search word
//                firstLine.toLowerCase();
//
//                if (firstLine.contains(searchWord.toLowerCase()));
//                {
//
//                    // replace search word line replacement word
//                    searchWord.replace(searchWord, replacementWord);
//                }
//                else {
//            }
//
//
//                 // define the line being read
//                 String currentLine = readFile.nextLine();
//
//                 //break line by space
//                 String [] lineBrokenUp = currentLine.split(" ");
//
//                 // for loop to go through the broken up lines
//                 String wordFound;
//                 for (int i = 0; i < lineBrokenUp.length; i++);
//                 if ()
//
//             }
//
//        } else {
//            System.out.println("We cannot find your file, have a good day!");
//            System.exit(1);
//        }
//
//        // get destination, see if destination exists, if not exit program
//
//        File FileDestination = new File(destinationFilePath);
//
//        if (FileDestination.exists()) {
//            System.out.println("We found your destination, creating file");
//        } else {
//            System.out.println("We cannot find your file, goodbye!");
//            System.exit(1);
//        }
//






