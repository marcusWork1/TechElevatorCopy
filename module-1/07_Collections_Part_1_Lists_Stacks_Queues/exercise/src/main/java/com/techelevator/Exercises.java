package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {
		// Define the data to be returned

		List<String> returnValue = new ArrayList<>();

		// go through the array given and add element to the arraylist we are return
		for(int i = 0; i < stringArray.length; i++) {
			// using for loop to assign value to arrayList
			returnValue.add(stringArray[i]);


			// for each is also possible
			// here is the for each                    for(String anElement : stringArray) {
				// here is the for each                      returnValue.add(anElement);
														// {
		}

		// return the return value
		return returnValue;
	}

	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {

	// declare new String Array called "arrayNew" and "multiply" the datatype "string array" (String[]) by the previous list named ("stringList".toArray)
		// this makes the new array have the same content as the old one.
		//												make sure you cast to string by declaring "new String[data]"
		String[] arrayNew = (String[])stringList.toArray(new String[0]);

		return arrayNew;
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {

		// convert array into array list
		List<String> arrayListNew = new ArrayList<>();

		// loop to pull up each index of the original array
		for (int i = 0; i < stringArray.length; i++) {

			// new string to hold contents of loop for original array
			String newString = stringArray[i];

			// if the lengtgh of it is 4, do not put into the arrayList
			if (newString.length() < 4 || newString.length() > 4) {

				// since index does not = 4, add contents of array to arrayList
				arrayListNew.add(newString);
			}

		} return arrayListNew;

		}
	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {
		// we get an array
		// divide each index/element/number by 2
		// put these numbers into an array list of doubles

		// our arrayList holder
		List<Double> doubleTrouble = new ArrayList<Double>();

		// loop through the array and get indexes
		for (int i = 0; i < intArray.length; i++) {

			// divide the number at index[i] by 2 // define this number as add to array list.
			double addedToArrayList = (double)intArray[i] /2;


			// add the divided index [i]
			doubleTrouble.add(addedToArrayList);

		}
		// return arrayLIst
		return doubleTrouble;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 81238
	 */
	public Integer findLargest(List<Integer> integerList) {

		// given a List of Integers
		// search through list and find largest value

		// describe variable to to hold largest value
		int largestValue = 0;

		// create forloop to run through list
		for (int i = 0; i < integerList.size(); i++) {

			// get "i" from integerList if it is greater than largest value, so loop runs until "i" is the largest value. each i value is larger than the previous value. if one i value is not bigger than another, it will give you the biggest one that has gone through the loop so far.
			if(integerList.get(i) >= largestValue) {
				// "i" is the largest value, and we got "i" from the integerList. Now assign value of i to largestValue
				largestValue = integerList.get(i);

			}

		}


		return largestValue;
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {


		return null;
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 9, 44, 2, 88, 9], 9) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {



		return false;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
	and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
	** INTERVIEW QUESTION **

	fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
	fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
	fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

	HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		return null;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
     interleaveLists( [7, 1, 3], [2, 5, 7, 9] )  ->  [7, 2, 1, 5, 3, 7, 9]
     interleaveLists( [1, 2, 5, 8, 10], [4, 5, 6] )  ->  [1, 4, 2, 5, 5, 6, 8, 10]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
		return null;
	}

}
