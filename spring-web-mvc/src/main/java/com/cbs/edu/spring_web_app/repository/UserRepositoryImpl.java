package com.cbs.edu.spring_web_app.repository;

import com.cbs.edu.spring_web_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User getUserByUserName(String username) {
        String sql = "SELECT * FROM app_user WHERE id = :username";

        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        User user = jdbcTemplate.queryForObject(sql, params, User.class);

        return user;
    }
}
