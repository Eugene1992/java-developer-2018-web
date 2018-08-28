package com.cbs.edu.hello_world_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        Performer duke = (Performer) context.getBean("duke");
        Performer duke = context.getBean("poeticDuke", Performer.class);
//        Performer duke = context.getBean(Performer.class);

        duke.perform();
    }
}
