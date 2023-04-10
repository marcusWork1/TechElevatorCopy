import com.frank.studentscoreapp.StudentScoreProcessingApplication;

import java.io.FileNotFoundException;
/********************************************************************************************
 * Application manager
 *
 * This is the application program because it has the main()
 ********************************************************************************************/
public class ApplicationProgram {
        public static void main(String args[]) throws FileNotFoundException {
                // instantiate an instance of the application to be run
                StudentScoreProcessingApplication aStudentScoreProcessingApplication = new StudentScoreProcessingApplication();

                // invoke the application controller to start the application
                aStudentScoreProcessingApplication.run();
        }
}
