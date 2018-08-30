package com.cbs.edu.spring_web_app.controller;

import com.cbs.edu.spring_web_app.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    public static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(0, "Anna", 22));
        employees.add(new Employee(1, "Tom", 43));
        employees.add(new Employee(2, "Jack", 65));
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView, Model model, View view) {
        modelAndView.setViewName("index");
        modelAndView.addObject("num", 777);

        return modelAndView;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView employees(ModelAndView modelAndView,
                                  @RequestParam(value = "action", required = false) String action) {

        modelAndView.setViewName("employees");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("action", action);

        return modelAndView;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute Employee employee, ModelAndView modelAndView) {
        employee.setId(employees.size());
        employees.add(employee);

        modelAndView.setViewName("employees");
        modelAndView.addObject("employees", employees);

        return modelAndView;
    }
}
