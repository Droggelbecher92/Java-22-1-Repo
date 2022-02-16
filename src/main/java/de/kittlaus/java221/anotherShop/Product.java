package de.kittlaus.java221.anotherShop;

import java.util.UUID;

public class Product {

    private final String name;
    private final String id;

    public Product(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
