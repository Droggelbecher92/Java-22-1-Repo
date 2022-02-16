package de.kittlaus.java221.anotherShop;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderModel {

    private final List<ProductModel> orderedProducts;
    private final String id;

    public OrderModel(List<ProductModel> orderedProducts) {
        id = UUID.randomUUID().toString();
        this.orderedProducts = orderedProducts;
    }

    public OrderModel(List<ProductModel> orderedProducts, String id) {
        this.orderedProducts = orderedProducts;
        this.id = id;
    }

    public List<ProductModel> getOrderedProducts() {
        return orderedProducts;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderModel that = (OrderModel) o;
        return Objects.equals(orderedProducts, that.orderedProducts) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderedProducts, id);
    }
}
