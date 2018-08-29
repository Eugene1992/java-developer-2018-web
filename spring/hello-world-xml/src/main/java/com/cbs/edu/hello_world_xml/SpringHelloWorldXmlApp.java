package com.cbs.edu.hello_world_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloWorldXmlApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        MessageRenderer messageRenderer = (MessageRenderer) applicationContext.getBean("renderer");
        messageRenderer.render();
    }
}
