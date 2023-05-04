package negocio;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Order {
    private int id;
    @Expose 
    private Customer customer;
    @Expose 
    private ArrayList<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer + ", items=" + items + '}';
    }
    
    
    

    
}