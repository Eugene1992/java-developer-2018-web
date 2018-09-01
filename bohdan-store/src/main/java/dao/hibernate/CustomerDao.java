package dao.hibernate;

import dao.model.Customer;


public interface CustomerDao extends GenericDao<Integer, Customer> {

    Customer getByEmail(String email);

}
