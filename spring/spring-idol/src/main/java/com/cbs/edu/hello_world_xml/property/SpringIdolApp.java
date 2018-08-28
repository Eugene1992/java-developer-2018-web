package com.cbs.edu.hello_world_xml.property;

import com.cbs.edu.hello_world_xml.Performer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("wire-by-property.xml");
        Performer duke = context.getBean("kenny", Performer.class);

        duke.perform();
    }
}
