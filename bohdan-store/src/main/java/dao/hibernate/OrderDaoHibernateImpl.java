package dao.hibernate;

import dao.model.Order;
import dao.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDaoHibernateImpl implements OrderDao {
    @Override
    public void create(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Order order) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(order);
        tx.commit();
        session.close();
    }

    @Override
    public Order get(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Order.class, id);
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Order").list();
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer id) {
        return (List<Order>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Order o INNER JOIN o.customer WHERE customer = " + id).list();
    }
}
