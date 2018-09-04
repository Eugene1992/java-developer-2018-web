package com.cbs.edu.spring_web_app.controller;

import com.cbs.edu.spring_web_app.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private List<Employee> employees = new ArrayList<>();

    {
        employees.add(new Employee(0, "Tom", "Cat", 25, 2000));
        employees.add(new Employee(1, "Sara", "Cat", 43, 45000));
        employees.add(new Employee(2, "Jessy", "Cat", 17, 23000));
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView main(ModelAndView modelAndView,
                             @RequestParam(value = "id", required = false) Integer id,
                             @RequestParam(value = "action", required = false) String action) {
        modelAndView.setViewName("main");
        if (action != null && !action.isEmpty()) {
            if (action.equals("update")) {
                modelAndView.addObject("updEmployee", employees.get(id));
                modelAndView.addObject("employees", employees);
                return modelAndView;
            }
            if (action.equals("delete")) {
                employees.remove((int) id);
                modelAndView.addObject("employees", employees);
            }
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public ModelAndView createEmployee(
            /*@RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") Integer age,
            @RequestParam("salary") Integer salary*/
            @ModelAttribute Employee employee,
            ModelAndView modelAndView
    ) {
        Integer id = employee.getId();
        if (id != null) {
            employees.set(id, employee);
        } else {
            employee.setId(employees.size());
            employees.add(employee);
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}