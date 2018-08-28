package com.cbs.edu.decoupled_reflection;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
