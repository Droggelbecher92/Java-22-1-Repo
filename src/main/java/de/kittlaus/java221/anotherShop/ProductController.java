package de.kittlaus.java221.anotherShop;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final SecondShopService shopService;

    public ProductController(SecondShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<ProductModel> getAllProducts(){
        return shopService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable String id){
        return shopService.getProductById(id).orElseThrow(() -> new IllegalArgumentException("No Product with ID:"+id));
    }

    @PostMapping
    public ProductModel postNewProduct(@RequestBody ProductModel productToAdd){
        return shopService.addNewProduct(productToAdd);
    }

}
