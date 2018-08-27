package dao.hibernate;

import dao.model.Role;
import dao.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoleDaoHibernateImpl implements GenericDao<Integer, Role> {

    @Override
    public void create(Role role) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(role);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Role employee) {

    }

    @Override
    public void delete(Role employee) {

    }

    @Override
    public Role get(Integer integer) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
