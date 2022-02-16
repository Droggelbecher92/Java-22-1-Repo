package de.kittlaus.friday2spring.shop;

import java.util.UUID;

public class Product {

    private String name;
    private String id;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
