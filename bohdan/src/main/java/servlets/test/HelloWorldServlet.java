package servlets.test;

import jdbc.Employee;
import jdbc.dao.EmployeeDao;
import jdbc.dao.EmployeeDaoJDBCImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloWorldServlet extends HttpServlet {

/*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();

        EmployeeDaoJDBCImpl crud = new EmployeeDaoJDBCImpl();
        List<Employee> employees = crud.getAll();

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee firstEmp, Employee secondEmp) {
                return firstEmp.getId() - secondEmp.getId();
            }
        });

        employees
                .forEach(employee -> writer.write(employee.toString() + "\n"));

    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        EmployeeDao crud = new EmployeeDaoJDBCImpl();
        Employee result = crud.get(id);
        req.setAttribute("employee", result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }


}
