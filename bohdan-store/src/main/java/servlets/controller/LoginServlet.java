package servlets.controller;


import dao.hibernate.UserDao;
import dao.hibernate.UserDaoHibernateImpl;
import dao.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final String LOGIN_JSP = "/login.jsp";
    private static final String STORE_JSP = "/store.jsp";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";
    private static final String ERR_MSG = "errMsg";
    private UserDao crud;
    private User user;

    @Override
    public void init() throws ServletException {
        crud = new UserDaoHibernateImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);

        user = crud.getByLoginAndPassword(login, password);

        if (user != null) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(120);
            session.setAttribute(USER, user);
            req.getRequestDispatcher(STORE_JSP).include(req, resp);
        } else {
            req.setAttribute(ERR_MSG, "You've entered wrong login or/and password");
            req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
