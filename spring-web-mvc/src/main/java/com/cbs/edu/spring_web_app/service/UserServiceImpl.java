package com.cbs.edu.spring_web_app.service;

import com.cbs.edu.spring_web_app.model.User;
import com.cbs.edu.spring_web_app.model.UserRole;
import com.cbs.edu.spring_web_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUserName(username);
    }
}
