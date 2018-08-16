package jdbc;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "employee_filled")
public class Employee {

    @Id
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private int age;
    @Column
    private int salary;
    @Column(name = "is_married")
    private boolean isMarried;
    //@Column
    //private Date birthdate;
    @Column
    private String position;

    public Employee() {

    }

    public Employee(String firstName, String lastName, int age, int salary, boolean isMarried, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;
        this.position = position;
    }

    public Employee(int id, String firstName, String lastName, int age, int salary, boolean isMarried, String position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.isMarried = isMarried;
        //this.birthdate = birthdate;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMarried(boolean married) {
        this.isMarried = married;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean is_married() {
        return isMarried;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        String isMarried = null;
        if (this.isMarried) {
            isMarried = ", married";
        } else {
            isMarried = ", not married";
        }
        return "Employee #"
                + id
                + ": first_name = "
                + firstName
                + ", last_name = "
                + lastName
                + ", age = "
                + age
                + ", salary = "
                + salary
                + isMarried
                + ", position = " + position;
        //"birthdate =" + birthdate
    }
}
