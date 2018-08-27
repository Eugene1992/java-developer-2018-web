package dao.service;

import dao.hibernate.RoleDaoHibernateImpl;
import dao.model.Product;
import dao.model.Role;
import dao.model.User;

public class HibernateDaoTest {

    private static RoleDaoHibernateImpl roleDao;
    private static UserService userService;
    private static ProductService productService;

    static {
        roleDao = new RoleDaoHibernateImpl();
        userService = new UserService();
        productService = new ProductService();
    }

    private static void setRoles(Role... roles) {
        for (Role role : roles) {
            roleDao.create(role);
        }
    }

    private static void setUsers(User... users) {
        for (User user : users) {
            userService.createUser(user);
        }
    }

    private static void setProducts(Product... products) {
        for (Product product : products) {
            productService.createProduct(product);
        }
    }

    public static void main(String[] args) {
        Role admin = new Role("admin");
        Role user = new Role("user");
        setRoles(admin, user);

        User odmen = new User("ODMEN", "admin", "admin", admin);
        User qwerty = new User("QWERTY", "user", "user", user);
        setUsers(odmen, qwerty);

        Product bread = new Product("Bread", 10, "https://www.browneyedbaker.com/wp-content/uploads/2016/05/white-bread-51-600-600x400.jpg");
        Product eggs = new Product("Eggs", 18, "https://img.webmd.com/dtmcms/live/webmd/consumer_assets/site_images/articles/health_tools/eggs_slideshow/getty_photo_of_eggs_in_carton.jpg");
        Product milk = new Product("Milk", 25, "https://images.milkandmore.co.uk/image/upload/w_iw/f_auto/w_300,h_300,d_back_up_image.jpg/v1/products/2004541_1.jpg");
        setProducts(bread, eggs, milk);
    }
}
