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

// Hold the 'Database" of users. would most likely be a table in the real world

@Component
public class MemoryUserDao implements UserDao {

    // file with user info loaded into users arraylist at start
    private final String USERS_DATA_FILE = "users.txt";

    // user info held in array list
    private static List<User> users = new ArrayList<>();

    public MemoryUserDao() {
        if (users.isEmpty()) {
            setUsers();
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    private void setUsers() {
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
