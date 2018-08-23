package com.cbs.edu.decoupled_reflection;

import java.io.FileInputStream;
import java.util.Properties;

public class DecoupledMessageFactory {
    private static DecoupledMessageFactory decoupledMessageFactory;
    private Properties properties;
    private MessageRenderer messageRenderer;
    private MessageProvider messageProvider;

    static {
        decoupledMessageFactory = new DecoupledMessageFactory();
    }

    private DecoupledMessageFactory() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("D:\\Users\\yede0517\\BECHTLE\\java-prof-1\\spring\\decoupled\\src\\main\\resources\\message.properties"));
            final String messageProviderClass = properties.getProperty("message.provider.class");
            final String messageRendererClass = properties.getProperty("message.renderer.class");
            messageRenderer = (MessageRenderer) Class.forName(messageRendererClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(messageProviderClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DecoupledMessageFactory getInstance() {
        return decoupledMessageFactory;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
