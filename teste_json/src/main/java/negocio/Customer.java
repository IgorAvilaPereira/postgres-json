package negocio;

import com.google.gson.annotations.Expose;

public class Customer {
    @Expose 
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + '}';
    }
    
    
    

}
