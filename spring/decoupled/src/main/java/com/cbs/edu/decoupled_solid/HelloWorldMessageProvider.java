package com.cbs.edu.decoupled_solid;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello world!";
    }
}
