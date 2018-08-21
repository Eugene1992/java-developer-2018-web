package com.cbs.edu.servlet_context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletContextTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        final String firstInitParameter = servletConfig.getInitParameter("servlet-config-param-1");
        final String secondInitParameter = servletConfig.getInitParameter("servlet-config-param-2");

        req.setAttribute("firstInitParameter", firstInitParameter);
        req.setAttribute("secondInitParameter", secondInitParameter);

        ServletContext servletContext = getServletContext();
        final String servletContextParam = servletContext.getInitParameter("servlet-context-param");

        req.setAttribute("servletContextParam", servletContextParam);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
