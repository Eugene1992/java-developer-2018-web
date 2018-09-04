package com.cbs.edu.spring_web_app.service;


import com.cbs.edu.spring_web_app.model.User;

public interface UserService {
    User getUser(String login);
}
