package dao.hibernate;

import dao.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Integer, Product> {

    List<Product> getByName(String name);

    List<Product> getByOrderId(Integer id);

}
