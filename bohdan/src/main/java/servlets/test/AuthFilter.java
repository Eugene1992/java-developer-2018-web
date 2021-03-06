package servlets.test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static servlets.test.LoginServlet.USER;

public class AuthFilter implements Filter {

    private static final String LOGIN = "/login";

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false);

        String loginURL = request.getContextPath() + LOGIN;
        boolean isLoggedIn = session != null && session.getAttribute(USER) != null;
        boolean isLoginRequest = request.getRequestURI().equals(loginURL);

        if (isLoggedIn || isLoginRequest) {
            chain.doFilter(request, response);
        } else {
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(LOGIN);
        }
    }

    @Override
    public void destroy() {}
}
