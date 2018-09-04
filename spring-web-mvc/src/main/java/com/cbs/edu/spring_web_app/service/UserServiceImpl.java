package com.cbs.edu.spring_web_app.service;

import com.cbs.edu.spring_web_app.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String login) {
        User user = new User();
        user.setLogin(login);
        user.setPassword("user");

        return user;
    }
}
