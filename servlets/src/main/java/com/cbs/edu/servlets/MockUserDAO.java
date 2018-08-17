package com.cbs.edu.servlets;

import java.util.ArrayList;
import java.util.List;

public class MockUserDAO {

    private static final List<User> userRepository;

    static {
        userRepository = new ArrayList<>();
        userRepository.add(new User("Admin", "admin", "admin"));
        userRepository.add(new User("User", "user", "user"));
    }

    public User getByLoginAndPassword(final String loginName, final String password) {
        for (User user : userRepository) {
            if (user.getLogin().equals(loginName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}