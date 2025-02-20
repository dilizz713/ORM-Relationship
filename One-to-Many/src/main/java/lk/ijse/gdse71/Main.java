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

        Customer customer = new Customer();
        /*customer.setId(1);*/
        customer.setName("Dilini");

        List<Order> orders = new ArrayList<>();

        Order order1 = new Order();
       /* order1.setId(1);*/
        order1.setDate("2025-02-20");
        order1.setCustomer(customer);               //set customer to order1

        Order order2 = new Order();
       /* order2.setId(2);*/
        order2.setDate("2025-02-20");
        order2.setCustomer(customer);           //set customer to order2

        orders.add(order1);                     //adding order1
        orders.add(order2);                     //adding order2

        customer.setOrders(orders);             //adding orders to customer

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();

        session.close();
    }
}