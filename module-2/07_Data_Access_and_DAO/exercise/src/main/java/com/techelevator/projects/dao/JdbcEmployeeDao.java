package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate theDatabase;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.theDatabase = new JdbcTemplate(dataSource);
	}

	/**
	 * Gets all employees from the datastore and returns them in a List
	 *
	 * @return all the employees as Employee objects in a List
	 */
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employee ; ";
		SqlRowSet results = theDatabase.queryForRowSet(sql);
		while (results.next()) {
			employees.add(mapRowToEmployee(results));

		}

		return employees;
	}
	/**
	 * Find all employees whose names contain the search strings. Returned employees should
	 * match both first and last name search strings. If a search string is blank,
	 * ignore it. If both strings are blank, return all employees.
	 * Be sure to use ILIKE for case-insensitive search matching!
	 *
	 * @param firstNameSearch the string to search for in the first_name, ignore if blank
	 * @param lastNameSearch the string to search for in the last_name, ignore if blank
	 * @return all employees whose name matches as Employee objects in a List
	 */
	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();

		String searchFirstWithWildcards = "%" + firstNameSearch + "%";
		String searchLastWithWildcards = "%" + lastNameSearch + "%";

		String sql = "SELECT * " +
				"FROM employee " +
				"WHERE (first_name ILIKE ? AND last_name ILIKE  ?) ;";

		SqlRowSet results = theDatabase.queryForRowSet(sql, searchFirstWithWildcards, searchLastWithWildcards);
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}
		if (firstNameSearch == null || lastNameSearch == null) {
			return getAllEmployees();
		}


		return employees;
	}

	/**
	 * Get all of the employees that are on the project with the given id.
	 *
	 * @param projectId the project id to get the employees from
	 * @return all the employees assigned to that project as Employee objects in a List
	 */
	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employeeByProject = new ArrayList<>();

		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee INNER JOIN project_employee ON project_employee.employee_id = employee.employee_id " +
				"WHERE project_id = ? ; ";

		SqlRowSet results = theDatabase.queryForRowSet(sql, projectId);

		while (results.next()) {
			employeeByProject.add(mapRowToEmployee(results));

		}


		return employeeByProject;
	}

	/**
	 * Assign an employee to a project
	 *
	 * @param projectId the project to put the employee on
	 * @param employeeId the employee to assign
	 */
	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {

		String sql = "INSERT INTO project_employee (employee_id, project_id) VALUES ( ?, ?) ";

		theDatabase.update(sql, employeeId, projectId);

	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {

		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id  = ? ;";

		theDatabase.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}
private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employee = new Employee();

		employee.setId(results.getInt("employee_id"));
		employee.setDepartmentId(results.getInt("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));

		if (results.getDate("hire_date") != null) {
			employee.setHireDate(results.getDate("hire_date").toLocalDate());
		}
		if (results.getDate("birth_date")!= null) {
			employee.setBirthDate(results.getDate("birth_date").toLocalDate());
		}

		return employee;
}

}
