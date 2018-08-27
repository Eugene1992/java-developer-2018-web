package dao.hibernate;

import java.util.List;

public interface GenericDao<ID, E> {

    void create(E employee);

    void update(E employee);

    void delete(E employee);

    E get(ID id);

    List<E> getAll();

}