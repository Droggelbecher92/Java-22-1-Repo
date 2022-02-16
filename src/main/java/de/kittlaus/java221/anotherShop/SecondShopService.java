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

    public List<OrderModel> getAllOrders() {
        return orderRepo.list();
    }

    public Optional<OrderModel> findOrderById(String id) {
        return Optional.ofNullable(orderRepo.findById(id));
    }

    public OrderModel saveNewOrder(OrderModel ordertoAdd) {
        return orderRepo.save(ordertoAdd);
    }

    public List<ProductModel> getAllProducts() {
        return productRepo.list();
    }

    public Optional<ProductModel> getProductById(String id) {
        return Optional.ofNullable(productRepo.findById(id));
    }

    public ProductModel addNewProduct(ProductModel productToAdd) {
        return productRepo.save(productToAdd);
    }
}
