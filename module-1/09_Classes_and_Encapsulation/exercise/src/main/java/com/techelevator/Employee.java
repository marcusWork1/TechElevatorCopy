package com.techelevator;

public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String fullName=firstName+" "+lastName ;
    private String	department;
    private double annualSalary;

    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary= annualSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }


    public String getFirstName() {
        return firstName;
    }



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

  public void raiseSalary(double percent) {
      annualSalary += annualSalary * percent / 100;

  }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department='" + department + '\'' +
                ", annualSalary=" + annualSalary +
                '}';
    }
}