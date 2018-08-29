package com.cbs.edu.decoupled_solid;

public class InternetMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Internet!";
    }
}
