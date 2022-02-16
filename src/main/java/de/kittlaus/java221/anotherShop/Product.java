package de.kittlaus.java221.anotherShop;

import java.util.Objects;
import java.util.UUID;

public class Product {

    private final String name;
    private final String id;

    public Product(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Product(String name, String id) {
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
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

}
