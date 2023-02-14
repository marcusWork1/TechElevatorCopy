package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		// develop system to collect user input
		Scanner input = new Scanner(System.in);


		// greet user and prompt them to enter a length
		System.out.println("Hi, what is the length of that object? ");

		// get a string value from input
		String value = input.nextLine();

		// convert string to int
		int length = Integer.parseInt(value);

		// convert double into int
		double meterLength = length * .3048;
		int meterLengthWhole = (int) meterLength;

		double feetLength = length * 3.2808399;
		int feetLengthWhole = (int) feetLength;


		// determine if string is f or m and collect input in string form
		System.out.println("is the length in feet or meters? Please respond with f or m");
		String type = input.nextLine();

		// based on input, create if else for conversion of f to m and visa versa
		if (type.equals("f")) {
			System.out.println("The length is " + length + type + " if we convert it to meters it is " + meterLengthWhole + "m");
		} else if (type.equals("m")) {
			System.out.println("The length is " + length + type + " if we convert it to feet it is " +  feetLengthWhole + "f");


		}

	}
}
