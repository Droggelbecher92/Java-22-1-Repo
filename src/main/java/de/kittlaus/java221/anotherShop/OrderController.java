package de.kittlaus.java221.anotherShop;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final SecondShopService shopService;


    public OrderController(SecondShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return shopService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id){
        return shopService.findOrderById(id).orElseThrow(() -> new IllegalArgumentException("No Order with ID:"+id));
    }

    @PostMapping
    public Order postNewOrder(@RequestBody Order ordertoAdd){
        return shopService.saveNewOrder(ordertoAdd);
    }
}
