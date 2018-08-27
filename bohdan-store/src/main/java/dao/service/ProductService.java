package dao.service;

import dao.hibernate.ProductDao;
import dao.hibernate.ProductDaoHibernateImpl;
import dao.model.Product;

import java.util.List;

public class ProductService {

    private ProductDao productDao;

    public ProductService() {
        this.productDao = new ProductDaoHibernateImpl();
    }

    public Product getProduct(int id) {
        return productDao.get(id);
    }

    public void createProduct(Product product) {
        productDao.create(product);
    }

    public void updateProduct(Product product) {
        productDao.update(product);
    }

    public void deleteProduct(Integer id) {
        Product product = new Product();
        product.setId(id);
        productDao.delete(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public List<Product> getProductsByName(String name) {
        return productDao.getByName(name);
    }

    public List<Product> getProductsByOrderId(Integer id) {
        return productDao.getProductsByOrderId(id);
    }

}
