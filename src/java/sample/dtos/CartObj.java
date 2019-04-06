/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Mai Linh
 */
public class CartObj implements Serializable {

    private String customerName;
    private HashMap<String, ProductDTO> cart;

    public CartObj(String customerName) {
        this.customerName = customerName;
         this.cart = new HashMap<>();
    }

    public CartObj() {
        this.customerName = "Guest";
        this.cart = new HashMap<>();
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the cart
     */
    public HashMap<String, ProductDTO> getCart() {
        return cart;
    }

    public void addToCart(ProductDTO dto) throws Exception {
        if (this.cart.containsKey(dto.getProductID())) {
            int quantity = this.cart.get(dto.getProductID()).getQuantity();
            dto.setQuantity(quantity);
        }
        this.cart.put(dto.getProductID(), dto);
    }

    public void removeCart(String id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public float getTotal() throws Exception {
        float result = 0;
        for (ProductDTO dto : this.cart.values()) {
            result += dto.getQuantity() * dto.getPrice();
        }
        return result;
    }
}
