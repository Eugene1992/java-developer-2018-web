package dao.service;

import dao.hibernate.CustomerDao;
import dao.model.Customer;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

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

    public void deleteCustomer(Integer id) {
        customerDao.delete(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAll();
    }

    public Customer getCustomerByEmail(String email) {
        return customerDao.getByEmail(email);
    }

}
