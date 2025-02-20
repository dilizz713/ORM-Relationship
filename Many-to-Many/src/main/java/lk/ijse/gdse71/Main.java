package lk.ijse.gdse71;

import config.FactoryConfiguration;
import org.hibernate.Session;

public class Main {
    private static FactoryConfiguration factoryConfiguration;
    public static void main(String[] args) {
        factoryConfiguration = FactoryConfiguration.getInstance();
        Session session = factoryConfiguration.getSession();
        session.close();


    }
}