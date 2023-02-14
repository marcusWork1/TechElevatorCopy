package com.techelevator;

// an import statement bring into the program code required for any classes you use
// import packagename.classname;

import java.util.ArrayList;   // Give me access to the code that supports ArrayList class
import java.util.Collections; // Give me access to the code that supports Collections class
import java.util.List;        // Give me access to the code that supports List class

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
// ArrayList is a type of List that is simular to an array
// an ArrayList has elements stored next to each other and may be accessed with an index (0 is the index of 1st element)
// unlike an array we can add, remove and search an ArrayList easily

		// There are several ways to define an ArrayList
		//
		// ArrayList<data-type-it-holds>  name = new ArrayList();
		// ArrayList<data-type-it-holds>  name = new ArrayList<>();
		// ArrayList<data-type-it-holds>  name = new ArrayList<data-type-it-holds>();
		//      List<data-type-it-holds>  name = new ArrayList();  // more about this style next week

		// Define an ArrayList to hold some names
		ArrayList<String> names = new ArrayList(); // new, empty ArrayList

		// Add some elements to the ArrayList using .add() method
		names.add("Me");   // Add a String to end of the ArrayList
		names.add("Ade");
		names.add("Kamran");
		names.add("Laura");
		names.add("Keith");
		//names.add(1); // error because all this ArrayList will store is String


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// Display all the elements in the ArrayList using their index
		// .get(index) will retrieve the element at the index given - similar to array[index]
		// .size() returns the number of elements in ArrayList - it was .length() for an array

		for(int i=0; i < names.size(); i++) {
			System.out.println("Element #" + i +" is: " + names.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("not all Collections classes do)");
		System.out.println("####################");

		names.add("Laura");  // add a value to the ArrayList that is already in the ArrayList and its OK

		// display all element in the ArrayList
		for(String theName : names){
			System.out.println("Element is: " + theName);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// .add(index-for-insert, object)

		// add Matthew after Ade (after index 1)
		names.add(2, "Matthew"); // specify the index where you want the object to be placed

		// add Joseph after Kamran (after index 3)
		names.add(4,"Joseph");


		// display all element in the ArrayList
		for(String theName : names){
			System.out.println("Element is: " + theName);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		// .remove(index-of-element-to-remove)
		// .remove(object-to-be-removed)

		// remove the first element (index 0)
		names.remove(0);

		// remove the first element that matched the object given
		names.remove("Laura");  // remove the first element that matches the String

		// display all element in the ArrayList
		for(String theName : names){
			System.out.println("Element is: " + theName);
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if(names.contains("Joseph")) {
			System.out.println("Name is in the List");
		}
		else {
			System.out.println("Name is Not in the List");
		}

		System.out.println("Is the name in the list? " + names.contains("Frank"));

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		// .indexOf(Object) - returns the index of an object in the list

		System.out.println("Keith is at index " + names.indexOf("Keith"));

		// remove Joseph from the list using his index
		names.remove(names.indexOf("Joseph"));

		// add Frank after Keith
		// find index of Keith to determine where to add Frank
		// Use the index of Keith + 1 to add after Keith
		names.add(names.indexOf("Keith")+1,"Frank");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// If something your are using requires an array rather than an ArrayList
		// You can convert the Arraylist into an array using:
		//   .toArray(new datatype[0] - convert the arrayList to the type given and return
		 String[] newNames = names.toArray(new String[0]);

		 for(String aName : newNames) {
			 System.out.println("New Name array element: " + aName);
		 }
		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		// Collections.sort(ArrayList) - sort the ArrayList back into itself
		//                               Strings are sorted alphabetically

		Collections.sort(names);  // Sort names back into itself

		for(String aName : names) {
			System.out.println("New Name array element: " + aName);
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		// Collections.reverse(ArrayList name) //Reverse the order of elements in the ArrayList back itself

		Collections.reverse(names);

		for(String aName : names) {
			System.out.println("New Name array element: " + aName);
		}

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		// for-each is short hand way for coding a for-loop
		//
		// for-each always goes through from the beginning to the end of an array or ArrayList
		//    cannot stop processing in the middle of the array/Arraylist
		//    cannot start at anywhere but the first element in the array/ArrayList
		//    cannot skip elements during the processing (eg. every other element, everyt  3rd element etc)
		//    Always goes one element at a time
		//    You do not know which element is being processed at any point in time
		//
		// format of for-each loop:   for(data-type-of-element name-for-element : array/ArrayList-name
		//
		// As the for-each goes through the array/ArrayList given it assigns the current element to the name specified
		//    Use the element-name specified in the body of the loop to reference the current

		// Use a for-each to go through the entire ArrayList and display the elements

		int currentElementNumber = 0;   // represent the index of teh current element processing in the for-each

		// name-current   ArrayList
		//   element     : name
		for(String aName : names) {
			System.out.println("A name from the ArrayList is at index " + currentElementNumber + ": " + aName);  // display the current name from the ArrayList
			currentElementNumber++;  // increment the current element number
		}
		// The for-each is similar to this for-loop
		for(int i=0; i < names.size(); i++) {
			System.out.println("Element #" + i +" is: " + names.get(i));
		}

	} // End of lecture code
} // End of clas hold lecture code
