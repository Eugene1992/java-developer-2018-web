package jdbc.dao;

import java.util.List;

//E extends AbstractEntity
public interface GenericDao<ID, E> {

    E create(E employee);

    E update(E employee);

    boolean delete(ID id);

    E get(ID id);

    List<E> getAll();

    void close();
}