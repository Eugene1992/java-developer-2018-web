package dao.hibernate;

import dao.model.Customer;
import dao.model.Order;

import java.util.List;

public interface CustomerDao extends GenericDao<Integer, Customer> {

    Customer getByEmail(String email);

    List<Order> getOrdersByCustomerId(Integer id);

}
