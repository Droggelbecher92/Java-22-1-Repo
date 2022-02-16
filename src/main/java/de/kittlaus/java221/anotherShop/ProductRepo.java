package de.kittlaus.java221.anotherShop;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepo {

    private final HashMap<String, ProductModel> allProducts = new HashMap<>();

    public List<ProductModel> list() {
        return allProducts.values().stream().toList();
    }

    public ProductModel findById(String id) {
        return allProducts.get(id);
    }

    public ProductModel save(ProductModel productToAdd) {
        allProducts.put(productToAdd.getId(),productToAdd);
        return productToAdd;
    }
}
