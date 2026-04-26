package com.demo.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Main class to demonstrate the Java Stream API.
 * The Stream API is used to process collections of objects in a functional, declarative way.
 */
public class StreamDemo {

    public static void main(String[] args) {
        // Initialize Sample Data
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 1200.0, "Electronics"),
                new Product(2, "Smartphone", 800.0, "Electronics"),
                new Product(3, "Monitor", 300.0, "Electronics"),
                new Product(4, "Coffee Maker", 100.0, "Appliances"),
                new Product(5, "Microwave", 150.0, "Appliances"),
                new Product(6, "Desk Chair", 250.0, "Furniture"),
                new Product(7, "Office Table", 450.0, "Furniture"),
                new Product(8, "Headphones", 150.0, "Electronics")
        );

        System.out.println("--- 1. FILTERING (Price > 300) ---");
        List<Product> expensiveProducts = products.stream()
                .filter(p -> p.getPrice() > 300)
                .collect(Collectors.toList());
        expensiveProducts.forEach(System.out::println);

        System.out.println("\n--- 2. MAPPING (Getting Product Names) ---");
        List<String> productNames = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        System.out.println("Names: " + productNames);

        System.out.println("\n--- 3. SORTING (By Price Descending) ---");
        products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println("\n--- 4. TERMINAL OPERATIONS: Match, Find, Count ---");
        boolean anyOver1000 = products.stream().anyMatch(p -> p.getPrice() > 1000);
        long applianceCount = products.stream().filter(p -> p.getCategory().equals("Appliances")).count();
        Optional<Product> cheapest = products.stream().min(Comparator.comparing(Product::getPrice));

        System.out.println("Any Product > 1000? " + anyOver1000);
        System.out.println("Appliance Count: " + applianceCount);
        cheapest.ifPresent(p -> System.out.println("Cheapest Product: " + p));

        System.out.println("\n--- 5. GROUPING BY CATEGORY ---");
        Map<String, List<Product>> byCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        
        byCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList.size() + " products");
        });

        System.out.println("\n--- 6. NUMERIC STREAM (Total Inventory Value) ---");
        double totalValue = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Total Value: $" + totalValue);

        System.out.println("\n--- 7. REDUCE (Combine Names into a String) ---");
        String allNames = products.stream()
                .map(Product::getName)
                .reduce("", (partialString, element) -> partialString + (partialString.isEmpty() ? "" : ", ") + element);
        System.out.println("All Products: " + allNames);
    }
}
