package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.User;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import java.util.Optional;

// Hold the "database" users and user information
// (Usually this would be a persistent data source like a table)


@Component
public class MemoryUserDao implements UserDao {

    // File with user information - loaded into the users ArrayList at start-up/constructor
    // Each line in the file contains:
    // user#, username, hashed-password                                            , ROLE_role, remembered?
    //   1  , user    ,$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC,ROLE_USER , true
    private final String USERS_DATA_FILE = "users.txt";

    // User info is being held in an ArrayList
    private static List<User> users = new ArrayList<>();

    public MemoryUserDao() {
        if (users.isEmpty()) {// If we have no users...
            setUsers();       //    Load user info from file
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    private void setUsers() {
        // Resource class defines an object in the resources folder of the project
        // (so we don't specify "./resources/users.txt" for the path to the file)
        Resource resource = loadUsers();
        if (resource.exists()) {
            try {
                Stream<String> lines = Files.lines(resource.getFile().toPath());
                lines.forEach(line -> {
                    String[] userDetails = line.split(",");
                    users.add(new User((Long.parseLong(userDetails[0])), userDetails[1], userDetails[2], userDetails[3], Boolean.parseBoolean(userDetails[4])));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // setup 2 default users if the file does not exist
            users.add(new User(1L, "user", "$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC", "user", true));
            users.add(new User(2L, "admin", "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "admin", true));
        }
    }

    private Resource loadUsers() {
        return new ClassPathResource(USERS_DATA_FILE);
    }

}
