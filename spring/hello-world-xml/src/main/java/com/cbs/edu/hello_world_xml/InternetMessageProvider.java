package com.cbs.edu.hello_world_xml;

public class InternetMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Internet!";
    }
}
