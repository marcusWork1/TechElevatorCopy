package com.techelevator.hotels;

import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    // Instantiate service objects used in it processing
    //
    // ConsoleService handles all interactions with the user/human
    // HotelService handles all interaction related to hotel data/information

    // Use of a service to interact with the user allow a change to the interactions
    //     to made easily.    For now we are using Command Line interaction (Console-keyboard & Screen)
    // if we want to change to a web based interaction, no coding changes are required to the application

    // Use of a service to data retrieval allows a change to data source without changing application

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService   hotelService   = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();   // call console service to display menu
            menuSelection = consoleService.promptForMenuSelection(); // call console service to get a meun choice
            if (menuSelection == 1) {
               // Use the Hotel service to get the hotels from the API server
               // and pass it to the ConsoleService printHotels() method to display them
               consoleService.printHotels(hotelService.listHotels());

            } else if (menuSelection == 2) {
                // Use the Hotel service to get the reviews from the API server
                // and pass it to the ConsoleService printReviewss() method to display them
                consoleService.printReviews(hotelService.listReviews());
            } else if (menuSelection == 3) {
                // Use the Hotel service to get the information for hotel #1
                // and pass it to the ConsoleService printHotel() method to display them
                consoleService.printHotel(hotelService.getHotelById(1));
            } else if (menuSelection == 4) {
                System.out.println("Not implemented");
            } else if (menuSelection == 5) {
                System.out.println("Not implemented");
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();  // tellteh console service to wait for enter
        }
    }

}
