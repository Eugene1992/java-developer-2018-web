package com.cbs.edu;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerTest implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListenerTest works!");
        ServletContext servletContext = sce.getServletContext();
        String contextParam = servletContext.getInitParameter("contextParam");
        System.out.println(contextParam);
        System.out.println(sce.getSource());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
