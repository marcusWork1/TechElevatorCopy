package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes
		 *
		 * Since String is a class, defining String is defining a String object
		 * An object is an instance of a class (more on Thursday)
		 *
		 * An int variable is an instance of int datatype
		 *
		 * Defining an object of a class is called instantiation
		 *
		 * Creating an object is called instantiation
		 * Creating a variable is called defining a variable
		 *
		 * the new operator is used when creating an object
		 *
		 *     new classname() - create an object of the class (more on Thursday)
		 *
		 * to create an int:    int name;
		 * to create an object: new classname();
		 *
		 * */

		/* create an new instance of String using a literal
		*
		* Two ways to define a new String:
		*
		*    String name = new String();   // create an empty String
		*
		*    String name = "some value";   // create a String with the value inside ""
		*
		* A String literal is enclosed in "" - a series of characters
		* A char literal is enclosed in '' - a single character
		*
		* A String is not a char and a char is not a String
		*
		* */

		// Create a new String
		String superBowlWinner2023 = "Chiefs";

		// after review
		superBowlWinner2023 = "Eagles"; // Assign a new value to a String

		// we can combine two Strings using +
		// + used with Strings means concatenation (stick 'em together)
		// + used with numerics means addition
		superBowlWinner2023 = "Philadelphia " + superBowlWinner2023;

		System.out.println("Winner is: " + superBowlWinner2023);

//--------------------------------------------------------------------------------------------------------		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		/*
		 * String is a class provided by Java - Class names start a capital letter
		 *
		 * A class is description of what an object of the class should look like
		 *
		 *   A class defined the data and behavior for objects of the behavior
		 *   methods in the class define the behavior of the class - ALOT more about this tomorrow and next week
		 *
		 * An object is an instance of a class
		 *
		 * A cake recipe is description of what is needed to make a cake:
		 *
		 *     ingredients (data)
		 *     wht to do with the ingredients to make a cake (behavior)
		 *
		 * The cake you make is an instance of the recipe.
		 *
		 * A class contains methods to allow you to interact and manipulate objects of the class
		 *
		 * a method is a function that is part of a class
		 *
		 * to use a method:   anObjectOfTheClass.method(any-parameters)
		 *                               -or-
		 *                    Classname.method(any-parameters)
		 * */


		/*
         * The String class provides a set of methods to interact and manipulate Strings
         *
		 * Commonly used methods:  stringname.methodname(parameters)
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
		 * .toUpperCase() - return the String in all uppercase
		 * .trim() - return the String with spaces removed from beginning and end of the String
		 * .split(delimiter) - returns and array of strings containing the characters between the delimiter specified
		 */
         //     position 12345678911234567892123456789312  -  position starts at 1 (human)
		 //        index 01234567891123456789212345678931  -  index starts at 0 (java)
		 String aName = "William Shatner as Captain Kirk";

		 System.out.println("The variable name contains: " + aName);
		 System.out.println("name contains: " + aName.length() + " characters");

		 System.out.println("The first character in " + aName + " is: " + aName.charAt(0));
		 System.out.println("The second character in " + aName + " is: " + aName.charAt(1));
		 System.out.println("The ninth character in " + aName + " is: " + aName.charAt(8));

		System.out.println("the name in all uppercase is: " + aName.toUpperCase());
		System.out.println("the name in all lowercase is: " + aName.toLowerCase());

		System.out.println("Does the name " + aName + " start with Will? " + aName.startsWith("Will"));
		System.out.println("Does the name " + aName + " end with Will? " + aName.endsWith("K"));
		System.out.println("Does the name " + aName + " start with Bill ?" + aName.startsWith("Bill"));
		System.out.println("Does the name " + aName + " end with P? " + aName.endsWith("P"));
		System.out.println("Does the name " + aName + " start with will? " + aName.startsWith("will"));
		System.out.println("Does the name " + aName + " start with will? " + aName.toUpperCase().startsWith("will".toUpperCase()));

		System.out.println("the name starting at position 9 is: " + aName.substring(8));  // position 9 is index 8

		// substring(start-index, end-index) - return from start-index up to but not including ending index
		System.out.println("the name starting at position 9 thru 15 is: " + aName.substring(8, 15));  // position 9 is index 8

		// split the String into words based on a space
		// .split() returns and array of Strings split by the string you give it

		String[] words = aName.split(" "); // split aName at a space and store words in the array

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
