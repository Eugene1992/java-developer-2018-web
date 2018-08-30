package com.cbs.edu.spring_web_app.controller;

import com.cbs.edu.spring_web_app.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/employees")
public class EmployeeRestController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Employee>> employees() {
        return new ResponseEntity<>(HomeController.employees, HttpStatus.OK) ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        HomeController.employees.remove(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void create(@RequestBody Employee employee) {
        HomeController.employees.add(employee);
    }
}
