package dao.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import servlets.config.CrudSpringConfig;

public class AutowiredTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CrudSpringConfig.class);

        CustomerService customerService = context.getBean("customerService", CustomerService.class);
    }
}
