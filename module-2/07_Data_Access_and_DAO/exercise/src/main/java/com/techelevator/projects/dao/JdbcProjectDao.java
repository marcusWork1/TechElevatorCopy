package com.techelevator.projects.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.PooledConnection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Get a project from the datastore that has the given id.
	 * If the id is not found, return null.
	 *
	 * @param projectId the id of the project to get from the datastore
	 * @return a filled out project object
	 */
	@Override
	public Project getProject(int projectId) {
		Project projectFromTable = null;


		String sql = "SELECT project_id, name, from_date, to_date "
				+ "FROM project "
				+ "WHERE project_id = ?;";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		if (results.next()) {
			projectFromTable = mapRowToProject(results);
		}


		return projectFromTable;
	}

	/**
	 * Get a list of all projects.
	 *
	 * @return all projects as Project objects in a List
	 */
	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();

		String sql = "SELECT * FROM project; ";


		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()) {
			projects.add(mapRowToProject(results));
		}
		return projects;
	}


	/**
	 * Inserts a new project into the datastore.
	 *
	 * @param newProject the project object to insert
	 * @return the project object with its new id filled in
	 */
	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date)" +
				"VALUES (?, ?, ?) RETURNING project_id;";
		Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		return getProject(newId);


	}

	/**
	 * Removes a project from the datastore, which requires deleting
	 * records from multiple tables.
	 *
	 * @param projectId the id of the project to remove
	 */
	@Override
	public void deleteProject(int projectId) {

		// delete dependant table first, then parents. must do two seperate deletes
		String sql = "DELETE FROM project_employee " +
				"WHERE project_id = ?;";
		jdbcTemplate.update(sql, projectId);

		// make second string to delete parent
		String sql2 = "DELETE FROM project " +
				 "WHERE project_id = ?;";
		jdbcTemplate.update(sql2, projectId);



	}
	private Project mapRowToProject(SqlRowSet  results) {
		Project project = new Project();

			project.setId(results.getInt("project_id"));
			project.setName(results.getString("name"));

		if (results.getDate("from_date") != null) {

			project.setFromDate(results.getDate("from_date").toLocalDate());
		}
		if (results.getDate("to_date") != null) {
			project.setToDate(results.getDate("to_date").toLocalDate());

		}
		return project;
	}


}
