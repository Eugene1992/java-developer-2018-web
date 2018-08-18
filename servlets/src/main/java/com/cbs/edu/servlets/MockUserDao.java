package com.cbs.edu.servlets;

import com.cbs.edu.servlets.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cbs.edu.servlets.model.User.Role.ADMIN;
import static com.cbs.edu.servlets.model.User.Role.USER;

public class MockUserDao {

    private List<User> users = Arrays.asList(
            new User("Admin", "admin", "admin", ADMIN),
            new User("User", "user", "user", USER)
    );

    public User getByLoginAndPassword(String login, String password) {
        return users.stream()
                .filter(user -> user.getPassword().equals(password) && user.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }
}