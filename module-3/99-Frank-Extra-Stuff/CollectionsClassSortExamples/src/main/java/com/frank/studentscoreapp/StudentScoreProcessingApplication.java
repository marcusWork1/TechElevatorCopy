package com.frank.studentscoreapp;

import com.frank.emojis.Emogis;
import com.frank.exceptions.DataFileErrorException;
import com.frank.exceptions.InvalidMenuResponseException;
import com.frank.types.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
/********************************************************************************************
 * Class representing the Addams Family members and various manipulation methods
 ********************************************************************************************/
public class StudentScoreProcessingApplication {

    /********************************************************************************************
    *  Keyboard object to get user input
    ********************************************************************************************/
    private static Scanner userKeyboardDevice = new Scanner(System.in);

    /********************************************************************************************
    * Constants representing menu options
    ********************************************************************************************/
    private static final String DISPLAY_ALL_STUDENTS_OPTION     = "Display all students";
    private static final String REFRESH_DATA_FROM_FILE          = "Refresh data from file";
    private static final String SORT_BY_ID                      = "Sort by Id";
    private static final String SORT_BY_NAME                    = "Sort by Name";
    private static final String SORT_BY_COURSE                   = "Sort by Course";
    private static final String SORT_BY_COURSE_AND_NAME          = "Sort by Course and Name";
    private static final String SORT_BY_TOTAL_SCORE             = "Sort by Total Score";
    private static final String SORT_BY_AVG_SCORE               = "Sort by Average Score";
    private static final String EXIT_OPTION                     = "Exit";

    /********************************************************************************************
    * Array of menu options display to users as needed
    ********************************************************************************************/
    private static final String[] mainMenuOptions = { DISPLAY_ALL_STUDENTS_OPTION
                                                    , SORT_BY_NAME
                                                    , SORT_BY_ID
                                                    , SORT_BY_COURSE
                                                    , SORT_BY_COURSE_AND_NAME
                                                    , SORT_BY_TOTAL_SCORE
                                                    , SORT_BY_AVG_SCORE
                                                    , REFRESH_DATA_FROM_FILE
                                                    , EXIT_OPTION
                                                    };
    /********************************************************************************************
     * List of students
     ********************************************************************************************/
    private List<Student> theStudents;

    /********************************************************************************************
     * Constructor for this application
     ********************************************************************************************/
    public StudentScoreProcessingApplication() throws FileNotFoundException {
            // Note: use of LinkedList rather than ArrayList due to efficiency when adding/removing
            theStudents = new LinkedList<>();  // Instantiate structure to hold s
            loadDataFromFile();         // Load data structure with s in a file
    }
    /********************************************************************************************
     * Application controller
     *
     * This is the method called to actually run the application
     ********************************************************************************************/
    public void run() throws FileNotFoundException {

            startOfApplicationProcessing();           // Display greeting
            String whatTheyChose = new String("");    // Hold response from user prompt
            boolean shouldLoop = true;                // Main processing loop control variable
            /********************************************************************************************
             * main processing loop
             ********************************************************************************************/
            while (shouldLoop) {
                try {
                    whatTheyChose = displayMenuAndGetResponse();          // Display main menu and get response
                    System.out.println("\nYou chose: " + whatTheyChose);  // Display menu option chosen

                    switch (whatTheyChose) {                              // Process based on menu option chosen
                           case DISPLAY_ALL_STUDENTS_OPTION: {
                                displayAlls();
                                break;
                           }
                           case SORT_BY_NAME: {
                                // Call the Collections class .sort method with the
                                //     comparator method in the Student class that
                                //      indicates how an attribute in one object compares to
                                //      the same attribute in another object of the class
                                theStudents.sort(Student::compareByName);
                                displayAlls();
                                break;
                           }
                           case SORT_BY_ID: {
                                theStudents.sort(Student::compareById);
                                displayAlls();
                                break;
                           }
                           case SORT_BY_COURSE: {
                                theStudents.sort(Student::compareByCourse);
                                displayAlls();
                                break;
                           }
                           case SORT_BY_COURSE_AND_NAME: {
                                theStudents.sort(Student::compareByCourseAndName);
                                displayAlls();
                                break;
                           }
                           case SORT_BY_TOTAL_SCORE: {
                                theStudents.sort(Student::compareByTotalScore);
                                displayAlls();
                                break;
                           }
                           case SORT_BY_AVG_SCORE:_SCORE: {
                                theStudents.sort(Student::compareByAvgScore);
                                displayAlls();
                                break;
                           }
                           case REFRESH_DATA_FROM_FILE: {
                                theStudents.removeAll(theStudents);  // Remove all app data structure current entries
                                loadDataFromFile();                 // Reload app data structure
                                break;
                           }
                           case EXIT_OPTION: {
                                shouldLoop = false;
                                break;
                           }
                           default: {    // if somehow an unexpected option was returned - throw an exception
                                throw new InvalidMenuResponseException("Invalid menu option " + whatTheyChose + " entered: ");
                           }
                      } // end of switch
                  } // end of try
                  catch(InvalidMenuResponseException exceptionObject){
                        System.out.println("\nUh-Oh, Looks like you entered an invalid response, please try again");
                  }
            } // end of while
            endOfApplicationProcessing();     // Perform any clean up at end of the application
    }  // End of main processing method - run()

    /**********************************************************************************************************
    * main processing helper methods
    *********************************************************************************************************/

    /********************************************************************************************
     * Display main menu, get response and return response
     ********************************************************************************************/
    public String displayMenuAndGetResponse () {

            int response = -1;  // initialze response to invalid value to be sure we store what user enters

            System.out.println("\nHello! WattaYaWannaDo? (enter number of option)\n");

            for (int i = 0; i < mainMenuOptions.length; i++) {              // Loop through menu option array
                    System.out.println(i + 1 + ". " + mainMenuOptions[i]);  //     display a menu option
            }
            System.out.print("\nYour choice: ");                               // Ask user for choice
            try {
                    response = Integer.parseInt(userKeyboardDevice.nextLine());// Get user choice and convert to int value
                    return mainMenuOptions[response - 1];                      // Return menu option from option array
            } catch (NumberFormatException exceptionObject) {
                    throw new InvalidMenuResponseException("Invalid menu option " + response + " entered: ");
            } catch (ArrayIndexOutOfBoundsException exceptionObject) {
                    throw new InvalidMenuResponseException("Invalid menu option " + response + " entered");
            }
    }  // End of displayMenuAndGetResponse()

     /********************************************************************************************
      * Starting of application setup processing - display welcome screen
      ********************************************************************************************/
     public void startOfApplicationProcessing () throws FileNotFoundException {

        // Send any error messages to a file rather than screen
        // 1. Instantiate a PrintStream object for the file to hold error messdage
        PrintStream fileProcessingErrorLogFile = new PrintStream("fileProcessingError.log");
        // 2. Tell Java to send all error message to the PrintStream file created in step 1 using setErr()
        System.setErr(fileProcessingErrorLogFile);

        // Display a welcome message
        System.out.println(Emogis.SCHOOL.repeat(40));
        System.out.printf("%1s %s \n", Emogis.SCHOOL, "Welcome to the  Score Processing app!");
        System.out.println(Emogis.SCHOOL.repeat(40));
     }  // end of startOfApplicationProcessing

     /********************************************************************************************
      * End of application takedown processing - display goodbye message
      ********************************************************************************************/
     public void endOfApplicationProcessing () {
            System.out.println(Emogis.WAVING_HAND_SIGN.repeat(25) + "\n"+Emogis.WAVING_HAND_SIGN+"Thank you for using our app!\n" + Emogis.WAVING_HAND_SIGN.repeat(25));
     }

     /********************************************************************************************
      * Display a entries in data stucture holding application data
      ********************************************************************************************/
     public void displayAlls() {
        int StudentCount = 0;
        String borderIcon = Emogis.HAPPY_LEARNER_RAISING_ONE_HAND;

        System.out.println("\n"+ (borderIcon+" ").repeat(25)) ;

        System.out.printf("%s %7s %-18s %5s %-20s %10s %10s\n", borderIcon
                                                              , "  ID "
                                                              , "     Name"
                                                              , "Course"
                                                              , "      Scores      "
                                                              , "Tot Score"
                                                              , "Avg Score");
        Iterator<Student> allIterator = theStudents.iterator();
        while(allIterator.hasNext()) {              // Loop while the iterator has a next element to process
             Student aStudent = allIterator.next(); // Get the next element from the iterator
             StudentCount++;
             System.out.printf("%s %7d %-18s %-6s %-20s %9d %10.2f",borderIcon
                                                                   ,aStudent.getId()
                                                                   ,aStudent.getName()
                                                                   ,aStudent.getCourse()
                                                                   ,aStudent.getScoresAsString()
                                                                   ,aStudent.getTotalScore()
                                                                   ,aStudent.getAverageScore()
                                                                   );
             if (StudentCount != theStudents.size())  {
                 System.out.println("");
             }
        }  // end of while
        System.out.println("\n"+ (borderIcon + " ").repeat(25)) ;
    } // end of displayAlls

    /********************************************************************************************
     * Load application data structure from data in a file
     ********************************************************************************************/
    private void loadDataFromFile() throws FileNotFoundException, DataFileErrorException {

        String aLine = null;                              // Hold a line from the file
        String S_FILE_NAME = "StudentData.txt";    // Name of file holding data to be loaded
        File sFile = null;                         // File object to represent file to be loaded
        Scanner FileReader  = null;                // Scanner object to read the file

        try {
            sFile       = new File(S_FILE_NAME);    // Instantiate File object representing data
            FileReader  = new Scanner(sFile);       // Instantiate Scanner to read file
            while (FileReader.hasNextLine()) {             // Loop as long as there is data in the file
                  aLine = FileReader.nextLine().strip();   //    Get a line from the file and store it
                  String[] Data = aLine.split(",");        //    Parse values in line based on ,
                  theStudents.add(new Student(Data[0]         //    Add to List with  input course
                                          ,Integer.parseInt(Data[1]) //      and  input id
                                          ,Data[2]                   //      and  input name and
                                          ,Arrays.asList(Integer.parseInt(Data[3]) // input scores
                                          ,Integer.parseInt(Data[4])               //    converted
                                          ,Integer.parseInt(Data[5])               //       to a
                                          ,Integer.parseInt(Data[6])))             //         list
                               );   // end of .add for s list
            }  // end of while
        }  // end of try
        catch(FileNotFoundException exceptionObj) {
             System.err.println(exceptionObj.getMessage());
             exceptionObj.printStackTrace();
             throw new DataFileErrorException(S_FILE_NAME + " not found - see error log for details");
        }
        catch (IllegalStateException exceptionObject) {
              System.err.println("Error processing s file: " + S_FILE_NAME);
              System.err.println("Call stack:");
              exceptionObject.printStackTrace();
        }
        finally {   // Whether there is an exception or not...
              FileReader.close();
        }
    }  // End of loadMembers()
} // end of StudentScoreProcessingApplication class
