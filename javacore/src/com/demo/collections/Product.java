package com.demo.collections;

import java.util.Objects;

/**
 * Product class used to demonstrate Collections.
 * We override equals() and hashCode() so that Set and Map can correctly handle duplicate products.
 */
public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Set and Map use hashCode and equals to identify "same" objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }

    // Comparable interface allows List to be sorted naturally
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.id, other.id);
    }
}
