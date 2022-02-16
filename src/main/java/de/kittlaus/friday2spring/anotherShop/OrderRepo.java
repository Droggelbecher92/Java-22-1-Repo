package de.kittlaus.friday2spring.anotherShop;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepo {

    private HashMap<String, Order> allOrders = new HashMap<>();


    public List<Order> list() {
        return allOrders.values().stream().toList();
    }

    public Order findById(String id) {
        return allOrders.get(id);
    }

    public Order save(Order ordertoAdd) {
        allOrders.put(ordertoAdd.getId(),ordertoAdd);
        return ordertoAdd;
    }
}
