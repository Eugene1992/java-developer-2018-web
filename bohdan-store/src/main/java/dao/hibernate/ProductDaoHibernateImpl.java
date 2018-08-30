package dao.hibernate;

import dao.model.Product;
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
public class ProductDaoHibernateImpl implements ProductDao {

    private SessionFactory sessionFactory;

    @Override
    public void create(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(product);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(product);
        tx.commit();
        session.close();
    }

    @Override
    public Product get(Integer id) {
        return sessionFactory.openSession().get(Product.class, id);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) sessionFactory.openSession().createQuery("FROM Product").list();
    }

    @Override
    public List<Product> getByName(String name) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);

        query.select(root).where(criteriaBuilder.equal(root.get("name"), name));

        List<Product> products = session.createQuery(query).getResultList();

        return products;
    }

    @Override
    public List<Product> getProductsByOrderId(Integer id) {
        return (List<Product>) sessionFactory.openSession().createQuery("FROM Product p INNER JOIN p.orders WHERE order = " + id).list();
    }
}
