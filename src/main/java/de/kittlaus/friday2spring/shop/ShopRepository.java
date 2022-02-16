package de.kittlaus.friday2spring.shop;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShopRepository {

    private List<Product> allMyProducts = new ArrayList<>();


    public List<Product> getAllProducts() {
        return allMyProducts;
    }

    public void saveThisProduct(Product productToAdd) {
        allMyProducts.add(productToAdd);
    }
}
