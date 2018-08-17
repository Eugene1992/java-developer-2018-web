package com.cbs.edu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private MockUserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new MockUserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        final User user = userDAO.getByLoginAndPassword(login, password);

        if (user != null) {
            final HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60);
            response.sendRedirect("/index.jsp");
        } else {
            request.setAttribute("errMsg", "Wrong login or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}