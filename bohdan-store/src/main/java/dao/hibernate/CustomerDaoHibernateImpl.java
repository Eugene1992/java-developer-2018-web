package dao.hibernate;

import dao.model.Customer;
import dao.model.Order;
import dao.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerDaoHibernateImpl implements CustomerDao {
    @Override
    public void create(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(customer);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(customer);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(customer);
        tx.commit();
        session.close();
    }

    @Override
    public Customer get(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Customer.class, id);
    }

    @Override
    public List<Customer> getAll() {
        return (List<Customer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("SELECT c FROM Customer c").getResultList();
    }

    @Override
    public Customer getByEmail(String email) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);

        query.select(root).where(criteriaBuilder.equal(root.get("email"), email));

        return session.createQuery(query).getResultList().get(0);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer id) {
        /*Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> query = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = query.from(Customer.class);


        query.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        Customer customer = session.createQuery(query).getResultList().get(0);

        return orders;*/
        return null;
    }
}
