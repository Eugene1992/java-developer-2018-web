package com.cbs.edu.coockies;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CoockiesServletTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String coockieName = req.getParameter("coockie_name");
        final String coockieValue = req.getParameter("coockie_value");
        final int coockieAge = Integer.parseInt(req.getParameter("coockie_age"));

        Cookie cookie = new Cookie(coockieName, coockieValue);
        cookie.setMaxAge(coockieAge);
        resp.addCookie(cookie);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
