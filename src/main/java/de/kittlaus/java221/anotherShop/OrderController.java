package de.kittlaus.java221.anotherShop;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final SecondShopService shopService;


    public OrderController(SecondShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public List<OrderModel> getAllOrders(){
        return shopService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderModel getOrderById(@PathVariable String id){
        return shopService.findOrderById(id).orElseThrow(() -> new IllegalArgumentException("No Order with ID:"+id));
    }

    @PostMapping
    public OrderModel postNewOrder(@RequestBody OrderModel ordertoAdd){
        return shopService.saveNewOrder(ordertoAdd);
    }
}
