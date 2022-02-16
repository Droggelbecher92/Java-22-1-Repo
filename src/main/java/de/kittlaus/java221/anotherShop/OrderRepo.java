package de.kittlaus.java221.anotherShop;


import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepo {

    private HashMap<String, OrderModel> allOrders = new HashMap<>();


    public List<OrderModel> list() {
        return allOrders.values().stream().toList();
    }

    public Optional<OrderModel> findById(String id) {
        return Optional.ofNullable(allOrders.get(id));
    }

    public OrderModel save(OrderModel ordertoAdd) {
        allOrders.put(ordertoAdd.getId(),ordertoAdd);
        return ordertoAdd;
    }
}
