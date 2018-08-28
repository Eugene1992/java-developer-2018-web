package com.cbs.edu.decoupled_reflection;

public class InternetMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Internet!";
    }
}
