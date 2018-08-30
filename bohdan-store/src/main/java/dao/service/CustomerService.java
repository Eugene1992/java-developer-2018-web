package dao.service;

import dao.hibernate.CustomerDao;
import dao.hibernate.CustomerDaoHibernateImpl;
import dao.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class CustomerService {

    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer getCustomer(int id) {
        return customerDao.get(id);
    }

    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAll();
    }

    public Customer getCustomerByEmail(String email) {
        return customerDao.getByEmail(email);
    }

}
