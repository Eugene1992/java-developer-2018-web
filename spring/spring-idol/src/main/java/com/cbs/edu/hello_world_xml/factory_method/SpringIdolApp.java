package com.cbs.edu.hello_world_xml.factory_method;

import com.cbs.edu.hello_world_xml.bean_life_cycle.Auditorium;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("factory_method.xml");
        Stage stage = context.getBean("stage", Stage.class);

        System.out.println(stage);
    }
}
