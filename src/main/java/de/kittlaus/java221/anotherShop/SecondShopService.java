package de.kittlaus.java221.anotherShop;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecondShopService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;


    public SecondShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public List<Order> getAllOrders() {
        return orderRepo.list();
    }

    public Optional<Order> findOrderById(String id) {
        return Optional.ofNullable(orderRepo.findById(id));
    }

    public Order saveNewOrder(Order ordertoAdd) {
        return orderRepo.save(ordertoAdd);
    }

    public List<Product> getAllProducts() {
        return productRepo.list();
    }

    public Optional<Product> getProductById(String id) {
        return Optional.ofNullable(productRepo.findById(id));
    }

    public Product addNewProduct(Product productToAdd) {
        return productRepo.save(productToAdd);
    }
}
