package lk.ijse.gdse71;

import lk.ijse.gdse71.config.FactoryConfiguration;
import lk.ijse.gdse71.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    private static FactoryConfiguration factoryConfiguration;

    public static void main(String[] args) {
        factoryConfiguration = FactoryConfiguration.getInstance();
        Session session = null;               //3
        Transaction transaction = null;       //4

        // ** Transient State **
        Customer customer = new Customer();   //1
        // No Id - bcz, Auto Generating
        customer.setName("John Doe");         //2

        //Get New Session                     //5
        session = FactoryConfiguration.getInstance().getSession();

        transaction = session.beginTransaction();    //7

        // ** Persistent State **
        //session.save(customer);  // deprecated. So use persist() instead of using save()
        session.persist(customer);            //6
        transaction.commit();

        // ** Detached State **
        session.close();          //8  // After closing session, we don't use it. bcz, can't use that session again..

        //If we don't want to edit that object & don't want to push it into persistent state --> it will eligible  automatically to garbage collector

        // Edit/Modify the Object again to eligible in persistent state
        customer.setName("Jane Doe");   //9

        //Get New Session                     //10  //Use session was closed. so, want to create again when reattaching the object to persistent state
        session = FactoryConfiguration.getInstance().getSession();

        // ** Persistent State                //11
        //Reattaching to persistent state
        //session.update(customer);  // deprecated. So use merge() instead of using update()
        session.merge(customer);

        // ** Removed State                //12
        //session.delete(customer);  // deprecated. So use remove() instead of using delete()
        session.remove(customer);

        //Eligible to Garbage Collector -> GC will delete this object automatically





    }
}