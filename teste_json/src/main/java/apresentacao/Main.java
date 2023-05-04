package apresentacao;

import java.sql.DriverManager;
import java.sql.SQLException;
import negocio.Customer;
import negocio.Item;
import negocio.Order;
import persistencia.OrderDAO;

/**
 *
 * @author iapereira
 */
public class Main {

//    DROP DATABASE IF EXISTS teste_json;
//    CREATE DATABASE teste_json;
//    
//    \c teste_json;
//    
//    CREATE TABLE orders (
//        id serial PRIMARY KEY,
//        info json NOT NULL
//);
//
    public static void main(String[] args) throws SQLException {
        Order order = new Order();
        order.setCustomer(new Customer("John Doe"));
        order.getItems().add(new Item("Beer", 6));
        new OrderDAO().insert(order);

//        Order o = new OrderDAO().load(6);
//        System.out.println(o);

//        o.getCustomer().setName("Igor Pereira");
//        new OrderDAO().update(o);

//        new OrderDAO().delete(5);

//         new OrderDAO().list().forEach(System.out::println);
//        new OrderDAO().list().forEach(x -> System.out.println(x));
//        new OrderDAO().listByCustomerName("Igor Pereira").forEach(x -> System.out.println(x));

    }
}
