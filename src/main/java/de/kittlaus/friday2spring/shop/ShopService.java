package de.kittlaus.friday2spring.shop;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShopService {

    private final ShopRepository shopRepository;


    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Product> needAllProducts() {
        return shopRepository.getAllProducts();
    }

    public Product addThisNewProduct(Product productToAdd) {
        if (productToAdd.getId()==null){
            productToAdd.setId(UUID.randomUUID().toString());
        }
        shopRepository.saveThisProduct(productToAdd);
        return productToAdd;
    }

    public void makeAProduct() {
        Product randomProduct = new Product("irgendwas");
        shopRepository.saveThisProduct(randomProduct);
    }
}
