package de.kittlaus.friday2spring.anotherShop;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ShopService shopService;

    public ProductController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return shopService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return shopService.getProductById(id);
    }

    @PostMapping
    public Product postNewProduct(@RequestBody Product productToAdd){
        return shopService.addNewProduct(productToAdd);
    }

}
