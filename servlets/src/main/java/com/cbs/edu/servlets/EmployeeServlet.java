package com.cbs.edu.servlets;

import com.cbs.edu.servlets.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeServlet extends HttpServlet {

    private List<Employee> employees;

    @Override
    public void init() throws ServletException {
        employees = new ArrayList<>(Arrays.asList(
            new Employee(0, "Yevhenii", 25, 1000000),
            new Employee(1, "Anna", 32, 2000000),
            new Employee(2, "Tom", 42, 10000000),
            new Employee(3, "Jack", 18, 4000000),
            new Employee(4, "John", 37, 7000000)
        ));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            switch (action) {
                case "delete":
                    employees.remove(id);
                    break;
                case "update":
                    Employee updatedEmployee = employees.get(id);
                    req.setAttribute("updatedEmployee", updatedEmployee);
                    break;
            }
        }

        req.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        Integer salary = Integer.valueOf(req.getParameter("salary"));

        Employee employee = new Employee(
                name, age, salary
        );

        String idValue = req.getParameter("id");
        if (!idValue.isEmpty()) {
            Integer id = Integer.valueOf(idValue);
            employee.setId(id);
            employees.set(id, employee);
        } else {
            employee.setId(employees.size());
            employees.add(employees.size(), employee);
        }

        req.setAttribute("employees", employees);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}