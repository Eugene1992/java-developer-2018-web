package dao.hibernate;

import dao.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class OrderDaoHibernateImpl implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void create(Order order) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(order);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Order order) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(order);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Order order) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(order);
        tx.commit();
        session.close();
    }

    @Override
    public Order get(Integer id) {
        return sessionFactory.openSession().get(Order.class, id);
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) sessionFactory.openSession().createQuery("FROM Order").list();
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer id) {
        return (List<Order>) sessionFactory.openSession().createQuery("FROM Order o INNER JOIN o.customer WHERE customer = " + id).list();
    }
}
