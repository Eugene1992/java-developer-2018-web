package com.cbs.edu.hello_world_xml.bean_life_cycle;

import com.cbs.edu.hello_world_xml.bean_scope.Ticket;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolApp {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-life-cycle.xml");
        Auditorium auditorium = context.getBean("auditorium", Auditorium.class);

        context.close();
    }
}
