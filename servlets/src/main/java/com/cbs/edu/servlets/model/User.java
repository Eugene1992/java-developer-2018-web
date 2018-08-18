package com.cbs.edu.servlets.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String login;
    private String password;
    private Role role;

    public enum Role {
        USER, ADMIN
    }
}
