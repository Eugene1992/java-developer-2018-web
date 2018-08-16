package com.cbs.edu.servlets_crud.controller;

import com.cbs.edu.servlets_crud.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.nonNull;


public class EmployeeController extends HttpServlet {

    private List<Employee> employees;

    @Override
    public void init() throws ServletException {
        employees = new ArrayList<>(Arrays.asList(
            new Employee(0, "Yevhenii", 25, 1_000_000),
            new Employee(1, "Tom", 18, 2_000_000),
            new Employee(2, "Anna", 32, 5_000_000),
            new Employee(3, "John", 54, 3_000_000),
            new Employee(4, "Jack", 43, 4_000_000)
        ));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (nonNull(req.getParameter("action")) && nonNull(req.getParameter("id"))) {
            final String action = req.getParameter("action");
            final int id = Integer.valueOf(req.getParameter("id"));
            switch (action) {
                case "update":
                    final Employee updatedEmployee = new Employee(
                            employees.size(),
                            req.getParameter("name"),
                            Integer.valueOf(req.getParameter("age")),
                            Integer.valueOf(req.getParameter("salary"))
                    );
                    employees.set(id, updatedEmployee);
                    break;

                case "delete":
                    employees.remove(id);
                    break;
            }
        }

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        employees.add(
            new Employee(
                employees.size(),
                req.getParameter("name"),
                Integer.valueOf(req.getParameter("age")),
                Integer.valueOf(req.getParameter("salary"))
            )
        );
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}