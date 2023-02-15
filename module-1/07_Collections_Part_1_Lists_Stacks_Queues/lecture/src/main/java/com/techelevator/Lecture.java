package com.techelevator;

// an import statement brings code required for any classes you use into the program.

import java.util.ArrayList; // Give me access to the code that supports the Arraylist class
import java.util.Collections; // Gives me access to the code that supports the collections class
import java.util.List; // gives me access to the code that supports the list class

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		// ArrayList is a type of List that is similar to an array
		// an ArrayList has elements that are stored next to each other and may be accessed with an index.(0 is the first index like array)l
		// unlike an array, we can add, remove, and search an arraylist easily.

		// several ways to say up array
		ArrayList<String> names = new ArrayList<>(); // new empty array list

		// add some elements to the end array list

		names.add("Me");
		names.add("Ade");
		names.add("Kamran");
		names.add("Laura");
		names.add("Keith");


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		// display all the elemnts in the arraylist using their index
		// .get(index) will retrieve element at index given - similar to array[index].
		// arrayList is .size vs .length in a array. this produces the number of elements
		for (int i = 0; i < names.size(); i++)
		{
			System.out.println("Element #" + i + "is: " + names.get(i));

		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates"); // not all collection classes do
		System.out.println("####################");

		names.add("Laura"); // add value to arraylist that is already in the list

		for(String theName : names) {
			System.out.println("element is: " + theName);
		}
		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		// add elements in the middle
		names.add(1, "Matthew");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		names.remove(3);


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		Boolean hasName = names.contains("Matthew") ;
		if (hasName) {
			System.out.println("has name");
		} else {
			System.out.println("not in list");
		}


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		names.indexOf("Keith");

		// can remove with index

		names.remove(names.indexOf("Keith"));

		// add frank after keith

		names.add(names.indexOf("Keith") + 1,"Frank");


		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		// if something you're using requires an array vs an arraylist
		String[]newNames = names.toArray(new String[0]);

		for(String aName : newNames) {
			System.out.println("new name arraylist element: " + aName);
		}

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		// sorts arraylist back into itself
		// strings are sorted alphabetically

		Collections.sort(names); // sorts names back into its self
		for(String theName : names) {
			System.out.println("New name array element: " + theName);
		}


		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		// Collections.reverse(Array list name) // reverse the order of element in the array list

		Collections.reverse(names);
		for(String theName : names) {
			System.out.println("New name array element:" +
					" " + theName);
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();
// for-each is short handed for loop
		// for each always goes through from start to end
		//cannot stop processing in the middle of array/arraylist
		// cannot start at anywhere except first element
		// cannot skip elements during process

		// always goes one element at a time
		// you do not know which element is being processed at any point in time

		// format of for each loop: for(data-type-of-element name-for-element: array/arraylist-name

		int currentElementNumber = 0; // represent the index of current element processing in for-each

		for(String aName : names) {
			System.out.println("A name from the ArrayList is at index + current element number: " + currentElementNumber + ": " + aName); // display the current name from array list
			currentElementNumber++; // increment the current element number
		}
 // for loop is below and for-each is above

		for(int i = 0; i < names.size(); i++) {
			System.out.println("Element #" + i + "is: " + names.get(i));

		}

	}
}
