package de.kittlaus.java221.anotherShop;

import java.util.List;
import java.util.UUID;

public class Order {

    private final List<Product> orderedProducts;
    private final String id;

    public Order(List<Product> orderedProducts) {
        id = UUID.randomUUID().toString();
        this.orderedProducts = orderedProducts;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public String getId() {
        return id;
    }
}
