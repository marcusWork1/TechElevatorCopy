package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
// concrete class for the DepartmentDao
// typically named JdbcTableNameDao - not required you follow the naming conventions

public class JdbcDepartmentDao implements DepartmentDao {

	// instance object for accessing the JDBCTemplate framework
	private final JdbcTemplate jdbcTemplate;



	// class constructor - receives the datasource and will connect to it
	//                      class       object
	public JdbcDepartmentDao(DataSource theDataSource) {
		this.jdbcTemplate = new JdbcTemplate(theDataSource);
	}

	@Override
	public Department getDepartment(int departmentId) {// get a row from the department table for the city id specified
		Department departmentFromTable = null; // initialize to default not found value

		String sql = "SELECT department_id, name " +
				"FROM department " +
				"WHERE department_id = ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,departmentId);

		if (results.next()){
			departmentFromTable = mapRowToDepartment(results);
		}


		return departmentFromTable;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = "SELECT * FROM department ";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			departments.add(mapRowToDepartment(results));

		}
		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department " +
				"SET name = ? " +
				"WHERE department_id = ?;";
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());


	}

	// create department object from mapRow method
	// has to be outside of the main code as its a new method
	private Department mapRowToDepartment(SqlRowSet rowSet){
		Department department = new Department();

		department.setId(rowSet.getInt("department_id"));
		department.setName(rowSet.getString("name"));

		return department;
	}
}
