package dao.hibernate;

import dao.model.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class RoleDaoHibernateImpl implements GenericDao<Integer, Role> {

    private SessionFactory sessionFactory;

    @Override
    public void create(Role role) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(role);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Role get(Integer id) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
