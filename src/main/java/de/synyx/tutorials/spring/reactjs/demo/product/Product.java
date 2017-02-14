package de.synyx.tutorials.spring.reactjs.demo.product;

public class Product {

    private final int id;
    private final String name;
    private final int value;

    public Product (int id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
