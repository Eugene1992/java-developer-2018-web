package servlets.test;

import JDBC_pckg.Employee;
import JDBC_pckg.dao_pckg.EmployeeDaoJDBCImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

public class HelloWorldServlet extends HttpServlet {

    @Override
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

    }

}
