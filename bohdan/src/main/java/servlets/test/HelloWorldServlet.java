package servlets.test;

import JDBC_pckg.Employee;
import JDBC_pckg.dao_pckg.EmployeeDaoJDBCImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Class.forName("JDBC_pckg.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        EmployeeDaoJDBCImpl crud = new EmployeeDaoJDBCImpl();
        List<Employee> employees = crud.getAll();
        PrintWriter writer = resp.getWriter();
//        writer.write("Hello world!");
        employees.
                forEach(employee -> writer.write(employee.toString() + "\n"));
    }

}
