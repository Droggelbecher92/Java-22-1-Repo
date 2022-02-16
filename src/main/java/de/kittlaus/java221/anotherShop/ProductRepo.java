package de.kittlaus.java221.anotherShop;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepo {

    private final HashMap<String, Product> allProducts = new HashMap<>();

    public List<Product> list() {
        return allProducts.values().stream().toList();
    }

    public Product findById(String id) {
        return allProducts.get(id);
    }

    public Product save(Product productToAdd) {
        allProducts.put(productToAdd.getId(),productToAdd);
        return productToAdd;
    }
}
