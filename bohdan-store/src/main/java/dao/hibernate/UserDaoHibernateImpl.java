package dao.hibernate;

import dao.model.User;
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
public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Integer id) {
        //User userDlt = new User();
        //userDlt.setId(id);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(id);
        tx.commit();
        session.close();
    }

    @Override
    public User get(Integer id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public List<User> getAll() {
        //List<User> users = (List<User>) sessionFactory.openSession().createQuery("FROM User").list();
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        query.select(root);

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        query.select(root).where(criteriaBuilder.equal(root.get("login"), login), criteriaBuilder.equal(root.get("password"), password));

        User user = session.createQuery(query).getSingleResult();
        session.close();

        return user;
    }

    @Override
    public List<User> getByRole(String role) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);

        query.select(root).where(criteriaBuilder.equal(root.get("role"), role));

        List<User> users = session.createQuery(query).getResultList();
        session.close();

        return users;
    }

}
