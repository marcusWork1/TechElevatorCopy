package com.techelevator;

import javax.swing.text.Style;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

// map is a Collections class to hold and access key-value pairs

		// a kay is a unique identifier for data
		// a value is the data within the key

		// a Map is also known as an "associative array"

		// Types of maps:
		// HashMap - entries are stored in unknown order
		// TreeMap - entries are stored in key sequence
		// LinkedHashMap - entries are stored in the order they ar added to map (entry-sequence).

		// to define a map:

		// Map<dataTypeOfKey,k dataTypeOfValue> nameOfMap == new typeOfMap();
		// -------------------------------------------------------------------------------------------
		// define a map where key is string and value is string

		// Map<String, String> stringMap = new HashMap<>();
		// this also works.... HashMap<String, String> stringMap = new HashMap<>();
		// -----------------------------------------------------------------------------------------

		// define a map to associate a person with where they live

		// key = person name - string
		// value = where they live = string

		Map<String, String> liveMap = new HashMap<>();

		// add keys and values

		liveMap.put("Johnny", "Ohio");
		liveMap.put("Marcus", "Kentucky");
		liveMap.put("Jordan", "Ohio");
		liveMap.put("superman", "smallville");

		// to retrieve data from a map use .get method with the key

		System.out.println("Marcus lives in: " + liveMap.get("Marcus"));
		System.out.println("superman lives in: " + liveMap.get("superman"));

		System.out.println("Does anyone live in the bronx: " + liveMap.containsValue("Bronx"));

		// ---------------------------------------------------------------------------------------------

		// to iterate through a map - we need to get the set of keys for the map
		//															and iterate through the set of keys to access the map
		//
		// use the.keySet() to get the set of keys for the map
		// /keySet returns a Set object containing all they keys
		//
		// Set is a class that allows us to define a data structure of unique values

		//Define a Set object ot hold all the keys in the map
		Set<String> theKeys = liveMap.keySet();

		// go through the set of keys one at a time to access the map
		for (String aKey : theKeys) {
			System.out.println("The map entry with the key: " +aKey + "is: " + liveMap.get(aKey));
		}
// a map can only hold one value for each key
		// if you try to add an entry with a key that already exists, the entry is updated w the new value


	} // End of main ()

} // End of class holding main()
