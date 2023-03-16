package com.techelevator.dao;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

// abstract is meant to be a super class
// providing subclasses with a rollback method()
// a super class  provides common processing and data for a subclass

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestingDatabaseConfig.class)
public abstract class BaseDaoTests {

    // @Autowired tells the Spring JDBC framework to automatically
    //   pass an object of this type to the class constructor
    // The datasouce is automatically defined from configuration file
    //    and passed to anything that @Autowired it
    @Autowired
    protected DataSource dataSource;

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

}
