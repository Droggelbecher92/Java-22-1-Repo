package de.kittlaus.java221.anotherShop;

import java.util.Objects;
import java.util.UUID;

public class ProductModel {

    private final String name;
    private final String id;

    public ProductModel(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }

    public ProductModel(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel product = (ProductModel) o;
        return Objects.equals(name, product.name) && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

}
