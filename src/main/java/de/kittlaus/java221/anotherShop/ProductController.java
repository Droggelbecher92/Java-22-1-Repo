package de.kittlaus.java221.anotherShop;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final SecondShopService shopService;

    public ProductController(SecondShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return shopService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return shopService.getProductById(id).orElseThrow(() -> new NoSuchElementException("No Product with ID:"+id));
    }

    @PostMapping
    public Product postNewProduct(@RequestBody Product productToAdd){
        return shopService.addNewProduct(productToAdd);
    }

}
