package dao.hibernate;

import java.util.List;

public interface GenericDao<ID, E> {

    void create(E e);

    void update(E e);

    void delete(ID id);

    E get(ID id);

    List<E> getAll();

}