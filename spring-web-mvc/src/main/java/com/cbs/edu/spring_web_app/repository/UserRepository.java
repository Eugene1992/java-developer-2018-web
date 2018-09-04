package com.cbs.edu.spring_web_app.repository;

import com.cbs.edu.spring_web_app.model.User;

public interface UserRepository {
    User getUserByUserName(String username);
}
