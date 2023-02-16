package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

// Map is a Collections class to hold and access key-value pairs
//
// a key is unique identifier for data
// a value is the data associated with a unique key
//
// A Map is also known as an "associative array"
//
// Types of Maps:
//
//    HashMap       - entries are stored in an unknown order
//    TreeMap       - entries are stored in key sequence
//    LinkedHashMap - entries are stored in the order that are added to Map (entry-sequence)

// To define a Map:
//
// Map<data-type-of-key, data-type-of-value> name-of-map = new typeOfMap();

// To define a Map where the key is a String and the value is a String:

//    Map<String, String>   myMap = new HashMap();
//	HashMap<String, String> myMap = new HashMap();

//	Map<String, String>     myMap = new HashMap<String, String>();
//	HashMap<String, String> myMap = new HashMap<String, String>();


	// Define a Map to associate a person with where they live:
	//
	// key - person-name - String
	// value - where they live - String
		Map<String, String> peopleLocations = new HashMap();

	// add some people and where they live to out Map
	// add to a Map using .put(key, value)

		peopleLocations.put("Superman", "Smallville");
		peopleLocations.put("Spiderman","Queens");
		peopleLocations.put("Stan Lee", "Bronx");
		peopleLocations.put("John", "Bronx");
		peopleLocations.put("Frodo", "Shire");

	// To retrieve data from a Map use .get(key)
	// .get(key) will search the Map for a matching key value
	//      and return the value associated with the key
	//                 or null is the key is not in the Map

		System.out.println("John lives in: " + peopleLocations.get("John"));
		System.out.println("Frodo lives in: " + peopleLocations.get("Frodo"));
		System.out.println("frodo lives in: " + peopleLocations.get("frodo"));

		System.out.println("Does anyone live in Bronx? " + peopleLocations.containsValue("Bronx"));
		System.out.println("Does anyone live in Phoenix? " + peopleLocations.containsValue("Phoenix"));

		// To iterate through a Map - we need to get the set of keys for the Map
		//                            and iterate through the set of keys to access the Map
		//
		// Use the .keySet() to get teh set of keys for the Map
		//     .keySet() returns a Set object containing all the key values
		//
		// Set is class that allows use to define a data structure of unique values

		// Define a Set object to hold all the keys in the Map
		Set<String> theKeys = peopleLocations.keySet();

		// Go through the Set of keys one at a time to access Map entries
		for(String aKey : theKeys) {
			System.out.println("The Map entry with key: " + aKey + " is: " + peopleLocations.get(aKey));
		}

         // A Map can hold one value for each key
	    //  if your try add an entry with a key that already exists,
		//  the entry is updated with the new value

		// Add "John" living at "JPMC"
		peopleLocations.put("John", "JPMC");

		// Add "Superman", if he's not already in the Map:
		if(!peopleLocations.containsKey("Superman")) {
			peopleLocations.put("Superman", "Metropolis");
		}
		else {
			System.out.println("Superman already in the Map");
		}

		// Define a Set object to hold all the keys in the Map
		theKeys = peopleLocations.keySet();

		// Go through the Set of keys one at a time to access Map entries
		for(String aKey : theKeys) {
			System.out.println("The Map entry with key: " + aKey + " is: " + peopleLocations.get(aKey));
		}

		// Entries may be removed from a Map using .remove()

		peopleLocations.remove("John");

		// Define a Set object to hold all the keys in the Map
		theKeys = peopleLocations.keySet();

		// Go through the Set of keys one at a time to access Map entries
		for(String aKey : theKeys) {
			System.out.println("The Map entry with key: " + aKey + " is: " + peopleLocations.get(aKey));
		}

		// To find all the keys for a specific value
		//
		// Suppose we want to find everyone living a city?
		// City is a value not a key in the Map
		//
		// There is no method provided to search values in a Map
		// So you write your own:
		//
		//     1. Get all the keys in the Map
		//     2. Loop through the keys one at a time
		//        a. if the value for the current key matches the value we want - process it

		peopleLocations.put("Beaver Cleaver", "Mayfield");
		peopleLocations.put("Wally Cleaver", "Mayfield");
		peopleLocations.put("Eddie Haskell", "Mayfield");
		peopleLocations.put("Lumpy Rutherford", "Mayfield");

		// Find all the people in map living in specific city

		String valueWeWant = "Smallville";

		// Get all the keys in the Map
		Set<String> keysInMap = peopleLocations.keySet();

		//  Loop through the keys one at a time
		for(String aPersonsName : keysInMap){
		    // if the value for the current key matches the value we want - process it
			// Should use a .equals() to compare String
			//     (== sometimes works with Strings, but not always)
			if(peopleLocations.get(aPersonsName).equals(valueWeWant) ){
				System.out.println(aPersonsName + " lives in " + valueWeWant);
			}
		}

	} // End of main()
} // End of class holding main()
