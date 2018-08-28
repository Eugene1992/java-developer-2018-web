package com.cbs.edu.hello_world_xml.bean_scope;

import com.cbs.edu.hello_world_xml.Performer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIdolApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Ticket ticket1 = context.getBean("ticket", Ticket.class);
        Ticket ticket2 = context.getBean("ticket", Ticket.class);

        System.out.println(ticket1 == ticket2);
    }
}
