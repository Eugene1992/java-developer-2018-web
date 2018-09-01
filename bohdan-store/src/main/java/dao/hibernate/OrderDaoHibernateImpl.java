package dao.hibernate;

import dao.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(id);
        tx.commit();
        session.close();
    }

    @Override
    public Order get(Integer id) {
        Session session = sessionFactory.openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    @Override
    public List<Order> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Order> query = criteriaBuilder.createQuery(Order.class);
        Root<Order> root = query.from(Order.class);

        query.select(root);

        List<Order> orders = session.createQuery(query).getResultList();
        session.close();

        return orders;
    }

    @Override
    public List<Order> getByCustomerId(Integer id) {
        //CriteriaQuery with join
        return (List<Order>) sessionFactory.openSession().createQuery("FROM Order o INNER JOIN o.customer WHERE customer = " + id).list();
    }
}
