package com.cbs.edu.servlets.controller;

import com.cbs.edu.servlets.MockUserDao;
import com.cbs.edu.servlets.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private MockUserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new MockUserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userDao.getByLoginAndPassword(login, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(30);
            session.setAttribute("user", user);
            resp.sendRedirect("/index.jsp");
        } else {
            req.setAttribute("errMsg", "Wrong login or password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
