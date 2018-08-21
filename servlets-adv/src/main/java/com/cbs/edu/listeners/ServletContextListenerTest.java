package com.cbs.edu.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListenerTest work!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}