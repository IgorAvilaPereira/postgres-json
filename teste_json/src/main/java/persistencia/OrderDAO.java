/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Customer;
import negocio.Item;
import negocio.Order;

/**
 *
 * @author iapereira
 */
public class OrderDAO {

    private Connection connection;
    private Gson gson;

    public OrderDAO() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    public void update(Order order) throws SQLException {

        this.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                """
                UPDATE orders SET info = ?::JSON WHERE id = ?;                
                """);
        preparedStatement.setObject(1, this.gson.toJson(order));
        preparedStatement.setInt(2, order.getId());

        preparedStatement.execute();
        this.closeConnection();

    }

    public void delete(int id) throws SQLException {
        this.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                """
               delete from orders where id = ?;                
                """);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        this.closeConnection();
    }
    
        public ArrayList<Order> listByCustomerName(String name) throws SQLException {

        this.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                """
               select * from orders where info->'customer'->> 'name' = ?;                
                """);
        preparedStatement.setString(1, name);
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<Order> orders = new ArrayList<Order>();
        Order order;
        while (rs.next()) {
            order = this.gson.fromJson(rs.getString("info"), Order.class);
            order.setId(rs.getInt("id"));
            orders.add(order);
        }
        this.closeConnection();
        return orders;

    }
    
      public ArrayList<Order> list() throws SQLException {

        this.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                """
               select * from orders;                
                """);
        ResultSet rs = preparedStatement.executeQuery();
        ArrayList<Order> orders = new ArrayList();
        Order order;
        while (rs.next()) {
            order = this.gson.fromJson(rs.getString("info"), Order.class);
            order.setId(rs.getInt("id"));
            orders.add(order);
        }
        this.closeConnection();
        return orders;

    }

    public Order load(int id) throws SQLException {

        this.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                """
               select * from orders where id = ?;                
                """);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        Order order = new Order();
        if (rs.next()) {
            order = this.gson.fromJson(rs.getString("info"), Order.class);
            order.setId(rs.getInt("id"));
        }
        this.closeConnection();
        return order;

    }

    public void insert(Order order) throws SQLException {
        this.openConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                """
                INSERT INTO orders (info) VALUES(?::JSON);                
                """);
        preparedStatement.setObject(1, this.gson.toJson(order));
        preparedStatement.execute();
        this.closeConnection();
    }

    private Connection openConnection() {
        String dbname = "teste_json";
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, "postgres", "postgres");
            System.out.println("CONECTADO COM SUCESSO!");
        } catch (SQLException e) {
            System.out.println("ERRO DE CONEXAO!");
        }
        return null;
    }

    private void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel fechar a conexão");
        }
    }

}
