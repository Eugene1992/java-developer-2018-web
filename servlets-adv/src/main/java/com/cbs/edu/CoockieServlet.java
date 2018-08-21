package com.cbs.edu;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class CoockieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        System.out.println(Arrays.toString(cookies));

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coockieName = req.getParameter("coockie_name");
        String coockieValue = req.getParameter("coockie_value");
        int coockieAge = Integer.parseInt(req.getParameter("coockie_age"));

        Cookie cookie = new Cookie(coockieName, coockieValue);
        cookie.setMaxAge(coockieAge);

        resp.addCookie(cookie);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
