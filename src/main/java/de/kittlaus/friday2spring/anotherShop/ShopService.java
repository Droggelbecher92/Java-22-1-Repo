package de.kittlaus.friday2spring.anotherShop;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;


    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    public List<Order> getAllOrders() {
        return orderRepo.list();
    }

    public Order findOrderById(String id) {
        return orderRepo.findById(id);
    }

    public Order saveNewOrder(Order ordertoAdd) {
        return orderRepo.save(ordertoAdd);
    }

    public List<Product> getAllProducts() {
        return productRepo.list();
    }

    public Product getProductById(String id) {
        return productRepo.findById(id);
    }

    public Product addNewProduct(Product productToAdd) {
        return productRepo.save(productToAdd);
    }
}
