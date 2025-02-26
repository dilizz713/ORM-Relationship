package lk.ijse.gdse71;

import config.FactoryConfiguration;
import entity.Customer;
import entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static FactoryConfiguration factoryConfiguration;

    public static void main(String[] args) {
        factoryConfiguration = FactoryConfiguration.getInstance();
        Session session = factoryConfiguration.getSession();
        session.close();

        Customer customer1 = new Customer();
        customer1.setName("Dilini");

        saveCustomer(customer1);

        List<Order> orders = customer1.getOrders();

        Order order1 = new Order();
        order1.setDate("2025-02-20");
        order1.setCustomer(customer1);

        saveOrder(order1);

        Order order2 = new Order();
        order2.setDate("2025-02-22");
        order2.setCustomer(customer1);

        saveOrder(order2);

        if(customer1 != null){
            getAllCustomers(customer1.getId());
        }


       /* orders.add(order1);
        orders.add(order2);

        customer1.setOrders(orders);*/


       /* Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Dilini");

        List<Order> orders = new ArrayList<>();

        Order order1 = new Order();
        order1.setId(1);
        order1.setDate("2025-02-20");
        order1.setCustomer(customer);               //set customer to order1

        Order order2 = new Order();
        order2.setId(2);
        order2.setDate("2025-02-20");
        order2.setCustomer(customer);           //set customer to order2

        orders.add(order1);                     //adding order1
        orders.add(order2);                     //adding order2

        customer.setOrders(orders);             //adding orders to customer

        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            session.close();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to save");
        }
        session.close();

*/

    }


    private static void getAllCustomers(int id) {
        Session session = factoryConfiguration.getSession();
        try{
            Customer customer1 = session.get(Customer.class, id);
            System.out.println(customer1);

          /*  if(customer1.getOrders() != null) {                   //data retrive  kragnna tostring danawa nm mehe danna be.
                for (Order order : customer1.getOrders()) {
                    System.out.println(order);
                }
            }*/
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get customer");
        }
    }

    private static boolean saveOrder(Order order1) {
        Session session = factoryConfiguration.getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(order1);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            if(session != null){
                session.close();
            }
        }
    }

    private static boolean saveCustomer(Customer customer1) {
        Session session = factoryConfiguration.getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(customer1);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            if(session != null){
                session.close();
            }
        }
    }
}