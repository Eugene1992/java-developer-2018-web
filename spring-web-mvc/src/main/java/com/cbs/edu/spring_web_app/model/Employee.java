package com.cbs.edu.spring_web_app.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Employee extends AbstractEntity {
    private String firstName;
    private String lastName;
    private int age;
    private int salary;

    public Employee(Integer id, String firstName, String lastName, int age, int salary) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
}