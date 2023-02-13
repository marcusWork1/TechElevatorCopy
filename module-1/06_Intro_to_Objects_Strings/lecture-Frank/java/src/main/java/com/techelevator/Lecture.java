package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		// since String is a class, defining String is defining a String object
		// an object is an instance of a class

		// an int variable is an instance of int datatype

		// defining an object ofa  class is called instantiation

		// creating an object is called instantiation
		// creating a variable is called defining a variable
		//

		// the New operator is used when creating an object

		// new classsname() - create an object of the class




		/* create an new instance of String using a literal */

		// two ways to define a string
		// string name = (new String(); // create empty string
		// string name = "some value"; // create a string with the value inside ""

		String chiefs = "Chiefs";

		// after review
		chiefs = "Philly"; // assign new value to string if needed

		// we can combine two strings using plus sign
		// + used with Strings with concatenation (put them together)
		// + used with numerics means addition

		chiefs = "Philly " + "Chiefs";

		System.out.println("winner is " + chiefs);



//--------------------------------------------------------------------------------------------------------		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		// String is a class provided by Java - class names start with capital letter
		// a class is a description of what an object of the class should look like

		// a class defined the data and behavior for objects of the behavior
		// methods in the classs define behavior of the class -more about this tomorrow and next week

		// an object is an instance of a class

		// a cake recipe is a description of what is needed to make a cake:

		//	ingredients (data)
		// what to do with the ingredients to make a cake (behavior)

		// the cake you make is an instance of the recipe

		// a class contains methods to allow you to interact and manipulate objects of the class

		// a method is a function that is a part of the class

		// to use a method: anObjectOfTheClass.method(any parameters)



			/// the string class provides a set of methods to interact and manipulate strings
		//
		/* Commonly used methods:  stringname.methodname(parameters)
		 *
		 * .length() - return the number of characters in a String
		 * .charAt(index) - returns the character at the index - 0 is first character
		 * .endsWith(search-string) - return true if the String ends with the search-string 
		 * .startsWith(search-string) - return true if the String starts with the search-string
		 * .indexOf(search-string) - return the index of the start of the 1st occurrence of search-string in the String
		 * .lastIndexOf(search-string) - return the index of the start of the last occurrence of search-string in the Stri
		 * .substring(start-index) - return from the start-index to rest of String
		 * .substring(start-index,end-index) - return from the start-index to the end-index (but not the char at end-index)
		 * .toLowerCase() - return the String in all lowercase
		 * .toUpperCase() - retrn the String in all uppercase
		 * .trim() - return the String with spaces removed from beginning and end of the String
		 * .split(delimiter) - returns and array of strings containing the characters between the delimiter specified
		 */

		String aName = "A long name is in here";

		System.out.println("The variable name contains: "  + aName);
		System.out.println("name contains: "  + aName.length() + " " + "Characters");


		System.out.println("The first character in  "  + aName + "is " + aName.charAt(0));


		System.out.println("The name in all uppercase is "  + aName.toUpperCase());
		System.out.println("The name in all lowercase is "  + aName.toLowerCase());

		System.out.println("Does the name "  + aName + "start with will " + aName.startsWith("will"));
		System.out.println("Does the name "  + aName + "end with ere " + aName.endsWith("ere"));

		System.out.println("The name starting at position 10 is "  + aName.substring(9)); // position 10 is index 9

		// substring(start-index, end-index) - returns from start-index up to but not including ending index
		System.out.println("The name starting at position 9 through 15 is "  + aName.substring(8,15));


		// split the String into words based on a space
		// .split returns an array of strings that have been split by the character/string you've given

		String[] words = aName.split(" "); // split aName at a space and store the words in the array

		// Display the words in the array
		for(int i=0; i < words.length; i++) {
			System.out.println(words[i]);
		}

//--------------------------------------------------------------------------------------------------------	
		
		/*   A String may also be created easily from an array of characters (char) */

		char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' }; // Array of characters (String)
		
		String hello1 = new String(helloArray);  // Create a String using the array of characters
		String hello2 = new String(helloArray);  // Create a String using the array of characters
		
//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */

		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

//--------------------------------------------------------------------------------------------------------			
		System.out.println();
		System.out.println("**************************");
		System.out.println("****** USING .split ******");
		System.out.println("**************************");
		System.out.println();


	}
}
