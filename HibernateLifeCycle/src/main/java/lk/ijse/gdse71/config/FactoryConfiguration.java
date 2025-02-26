package lk.ijse.gdse71.config;

import lk.ijse.gdse71.entity.Customer;
import lk.ijse.gdse71.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure();

        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Order.class);

        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
