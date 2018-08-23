package com.cbs.edu.decoupled_reflection;

public class HelloWorldDecoupledApp {
    public static void main(String[] args) {
        DecoupledMessageFactory decoupledMessageFactory = DecoupledMessageFactory.getInstance();
        MessageProvider messageProvider = decoupledMessageFactory.getMessageProvider();
        MessageRenderer messageRenderer = decoupledMessageFactory.getMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        System.out.println(messageProvider.getMessage());
    }
}
