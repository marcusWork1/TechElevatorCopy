package com.techelevator.projects.model;

//// this is a POJO for rows in the Department table in the employeeproject database

// POJO is a java class that has at least:

// 1. a default constructor(not necessary, but a great idea!)
// 2. standard named getters and setters
// 3. recommended toString() and equals();
public class Department {

	// columns in the table are represented by sintance variables in the class
	// variable names dont have to match the column names, makes it easier if they do

	private int id;
	private String name;

	public Department() {}

	// default constructor
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
