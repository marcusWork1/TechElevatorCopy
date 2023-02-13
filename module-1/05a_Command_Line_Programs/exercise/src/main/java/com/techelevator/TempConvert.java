package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		// develop system to collect user input
		Scanner input = new Scanner(System.in);

		// greet user and prompt them to enter a temperature
		System.out.println("Hi, what is the temperature? ");

		// get a string value from input
		String value = input.nextLine();

		// convert string to int
		int temp = Integer.parseInt(value);

		// determine if string is F or C
		System.out.println("is the temperature Celsius or Fahrenheit? Please enter as C or F");
				String type = input.nextLine();



		if (type.equals("C")){
			System.out.println("The temperature is " + temp + type + " if we convert it to Fahrenheit it is " + (temp * 1.8 + 32) + "F");
		} else if (type.equals("F")) {
			System.out.println("The temperature is " + temp + type + " if we convert it to Celsius it is " + ((temp - 32) / 1.8) + "C");
		}



	}

}
