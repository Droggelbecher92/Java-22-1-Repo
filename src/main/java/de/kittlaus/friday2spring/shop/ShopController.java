package de.kittlaus.friday2spring.shop;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return shopService.needAllProducts();
    }

    @PostMapping
    public Product postNewProduct(@RequestBody Product productToAdd){
        return shopService.addThisNewProduct(productToAdd);
    }

    @PostMapping("/random")
    public void createRandomProduct(){
        shopService.makeAProduct();
    }

    @DeleteMapping
    public void deleteOneProduct(@RequestBody Product productToDelete){
        shopService.deleteThisProduct(productToDelete);
    }

}
