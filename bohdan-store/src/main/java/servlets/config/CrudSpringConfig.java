package servlets.config;

import dao.hibernate.*;
import dao.utils.HibernateSessionFactoryUtil;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrudSpringConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Bean
    public RoleDaoHibernateImpl roleDao() {
        return new RoleDaoHibernateImpl(sessionFactory());
    }

    @Bean
    public UserDao userDao() {
        return new UserDaoHibernateImpl(sessionFactory());
    }

    @Bean
    public CustomerDao customerDao() {
        return new CustomerDaoHibernateImpl(sessionFactory());
    }

    @Bean
    public OrderDao orderDao() {
        return new OrderDaoHibernateImpl(sessionFactory());
    }

    @Bean
    public ProductDao productDao() {
        return new ProductDaoHibernateImpl(sessionFactory());
    }

}
