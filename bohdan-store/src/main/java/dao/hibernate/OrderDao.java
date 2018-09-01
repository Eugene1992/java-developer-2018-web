package dao.hibernate;

import dao.model.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Integer, Order> {

    List<Order> getByCustomerId(Integer id);

}
