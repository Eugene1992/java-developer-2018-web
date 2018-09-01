package dao.service;

import dao.hibernate.OrderDao;
import dao.hibernate.OrderDaoHibernateImpl;
import dao.model.Order;

import java.util.List;

public class OrderService {

    private OrderDao orderDao;

    public OrderService() {
        this.orderDao = new OrderDaoHibernateImpl();
    }

    public Order getOrder(int id) {
        return orderDao.get(id);
    }

    public void createOrder(Order order) {
        orderDao.create(order);
    }

    public void updateOrder(Order order) {
        orderDao.update(order);
    }

    public void deleteOrder(Integer id) {
        orderDao.delete(id);
    }

    public List<Order> getAllOrders() {
        return orderDao.getAll();
    }

    public List<Order> getOrdersByCustomerId(Integer id) {
        return orderDao.getByCustomerId(id);
    }

}
