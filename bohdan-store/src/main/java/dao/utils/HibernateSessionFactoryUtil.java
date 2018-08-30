package dao.utils;

//import dao.model.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.springframework.context.annotation.Bean;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        /*if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(Product.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());



            } catch (Exception e) {
                System.out.println("Exception!:\n" + e);
            }
        }*/
        return sessionFactory;
    }
}