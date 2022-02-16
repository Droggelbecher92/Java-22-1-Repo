package de.kittlaus.friday2spring.anotherShop;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final ShopService shopService;


    public OrderController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return shopService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id){
        return shopService.findOrderById(id);
    }

    @PostMapping
    public Order postNewOrder(@RequestBody Order ordertoAdd){
        return shopService.saveNewOrder(ordertoAdd);
    }
}
