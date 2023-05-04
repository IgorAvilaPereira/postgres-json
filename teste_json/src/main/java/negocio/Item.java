package negocio;

import com.google.gson.annotations.Expose;

public class Item {
    @Expose 
    private String product;
    @Expose 
    private int qty;

    public Item() {
    }

    public Item(String product, int qty) {
        this.product = product;
        this.qty = qty;
    }
    
    
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" + "product=" + product + ", qty=" + qty + '}';
    }
    
    
    
}
