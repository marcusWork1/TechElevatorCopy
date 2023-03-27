package com.techelevator.controller;

import com.techelevator.model.Department;
import com.techelevator.model.JDBCDepartmentDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * Controller to return data from the project database using JDBC DAOS
 */
@RestController // restcontroller tells the server there is controller in the class
public class DepartmentController {
    // Define a datasource and a DAO object to retrieve the data
    // copied from client server
    // imported pom xml dependencies for JDBC

    // define an instance variable
    private JDBCDepartmentDAO theDeptDatabase;


    // define a constructor to hold datasource
    public DepartmentController() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/apireview");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");


        theDeptDatabase = new JDBCDepartmentDAO(dataSource);
    }

    // Return all departments
    // HTTP Request GET
    // path /department
    // DAO to get data: public List<Department> getAllDepartments()
    // return list of departments

    @RequestMapping(path = "/department", method = RequestMethod.GET)
    public List<Department> getMeAllDepts() {

        logAPICall("GET with path /department");

        return theDeptDatabase.getAllDepartments();


    }



    public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }

}


