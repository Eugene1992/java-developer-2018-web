package com.cbs.edu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationsApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanAppConfig.class);

        Performer performer = (Performer) context.getBean("kenny");

        performer.perform();
    }
}
