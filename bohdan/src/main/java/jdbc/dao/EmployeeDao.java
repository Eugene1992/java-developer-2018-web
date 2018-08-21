package jdbc.dao;

import jdbc.Employee;

import java.util.List;

public interface EmployeeDao extends GenericDao<Integer, Employee> {

    List<Employee> getByName(String name);

    List<Employee> getByPosition(String position);

    List<Employee> getEmployeesPage(int page, String order);

}
