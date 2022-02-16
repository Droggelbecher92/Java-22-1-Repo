package de.kittlaus.java221.anotherShop;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo {

    private final HashMap<String, ProductModel> allProducts = new HashMap<>();

    public List<ProductModel> list() {
        return allProducts.values().stream().toList();
    }

    public Optional<ProductModel> findById(String id) {
        return Optional.ofNullable(allProducts.get(id));
    }

    public ProductModel save(ProductModel productToAdd) {
        allProducts.put(productToAdd.getId(),productToAdd);
        return productToAdd;
    }
}
