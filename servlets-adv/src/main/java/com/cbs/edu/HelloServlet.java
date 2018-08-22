package com.cbs.edu;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();

        String initParameterOne = servletConfig.getInitParameter("param1");
        String initParameterTwo = servletConfig.getInitParameter("param2");
        String servletName = servletConfig.getServletName();

        req.setAttribute("initParameterOne", initParameterOne);
        req.setAttribute("initParameterTwo", initParameterTwo);
        req.setAttribute("servletName", servletName);

        ServletContext servletContext = getServletContext();
        String contextParam = servletContext.getInitParameter("contextParam");
        req.setAttribute("contextParam", contextParam);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
