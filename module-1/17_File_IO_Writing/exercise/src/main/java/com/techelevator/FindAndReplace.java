package com.techelevator;

import javax.sound.midi.SysexMessage;
import java.awt.*;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class FindAndReplace {
    public static void main(String[] args) {
// create scanner object
        Scanner input = new Scanner(System.in);
// Read all information from the user
        System.out.println("What is the search word?");
        String search = input.nextLine();
        System.out.println("What is the replacement word?");
        String replacementWord = input.nextLine();
        System.out.println("What is the source file?");
        String source = input.nextLine();
        System.out.println("What is the destination file?");
        String destination = input.nextLine();
        input.close();
        try {
// create FileWriter object
            FileWriter fileOut = new FileWriter(destination);
// create BufferedWriter object
            BufferedWriter bw = new BufferedWriter(fileOut);

// create scanner object
            Scanner fileRead = new Scanner(new File(source));
// check next line present or not
            while (fileRead.hasNextLine()) {
// read each line
                String data = fileRead.nextLine();
// write data to the destination file
                bw.write(data.replace(search, replacementWord));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fileRead.close();
            System.out.println("Data replaced successfully.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}

//    // Use this scanner for all user input. Don't create additional Scanners with System.in
//    private final Scanner userInput = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        FindAndReplace findAndReplace = new FindAndReplace();
//        findAndReplace.run();
//    }
//
//    public void run() throws IOException {
//        /* Your code goes here */
//
//        // ask for the search word and replacement word to establish those attributes
//
//        System.out.println("What is the search word?");
//        String searchWord = userInput.nextLine();
//
//        System.out.println("What is the replacement word?");
//        String replacementWord = userInput.nextLine();
//
//        // ask for file path and assign teh file a variable
//        System.out.println("Enter the path of a file");
//        String path = userInput.nextLine();
//        // File ourFile = new File(path);
////        if (!ourFile.exists()) {
////            System.exit(1);
////            System.out.println("We could not find your file, have a good day");
////        } else
//
////      Destination of file
//        System.out.println("Enter the path to the files new destination.");
//        String destinationFilePath = userInput.nextLine();
//        //File fileDestination = new File(destinationFilePath);
////        if (!fileDestination.exists()) {
////            System.exit(1);
////        System.out.println("We could not find your destination, have a good day"); }
////        else
//
//
//        try {
//            // create filewriter object
//            FileWriter newFile = new FileWriter(destinationFilePath);
//
//
//            // create bufferedwriter object
//            BufferedWriter fileNew = new BufferedWriter(newFile);
//
//            // Create Scanner object
//            Scanner readFile = new Scanner(new File(path));
//
//            // check next line present or not
//            while (readFile.hasNextLine()) {
//
//                // read each line
//                String firstLine = readFile.nextLine();
//
//                // write data to destination file
//                fileNew.write(firstLine.replace(searchWord, replacementWord));
//                fileNew.newLine();
//            }
//            fileNew.close();
//            readFile.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}





