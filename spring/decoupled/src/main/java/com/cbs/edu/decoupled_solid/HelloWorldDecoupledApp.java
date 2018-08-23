package com.cbs.edu.decoupled_solid;

public class HelloWorldDecoupledApp {
    public static void main(String[] args) {
//        MessageProvider messageProvider = new HelloWorldMessageProvider();
        MessageProvider messageProvider = new InternetMessageProvider();
        MessageRenderer messageRenderer = new ConsoleMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        System.out.println(messageProvider.getMessage());
    }
}
