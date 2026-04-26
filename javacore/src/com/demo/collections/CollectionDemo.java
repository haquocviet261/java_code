package com.demo.collections;

import java.util.*;

/**
 * Main class to demonstrate the Java Collection Framework.
 */
public class CollectionDemo {

    public static void main(String[] args) {
        System.out.println("--- 1. LIST DEMO (ArrayList) ---");
        demonstrateList();

        System.out.println("\n--- 2. SET DEMO (HashSet) ---");
        demonstrateSet();

        System.out.println("\n--- 3. MAP DEMO (HashMap) ---");
        demonstrateMap();

        System.out.println("\n--- 4. QUEUE DEMO (PriorityQueue) ---");
        demonstrateQueue();
    }

    /**
     * List: Ordered collection, allows duplicates.
     * Use case: When you need to maintain insertion order.
     */
    private static void demonstrateList() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Laptop", 1200.0));
        products.add(new Product(1, "Smartphone", 800.0));
        products.add(new Product(2, "Tablet", 400.0));
        products.add(new Product(1, "Smartphone", 800.0)); // Duplicate allowed

        System.out.println("Initial List (Maintains Order):");
        for (Product p : products) System.out.println(p);

        // Sorting using Comparable (by ID)
        Collections.sort(products);
        System.out.println("\nSorted by ID (Comparable):");
        products.forEach(System.out::println);

        // Sorting using Comparator (by Name)
        products.sort(Comparator.comparing(Product::getName));
        System.out.println("\nSorted by Name (Comparator):");
        products.forEach(System.out::println);
    }

    /**
     * Set: Unordered collection, NO duplicates allowed.
     * Use case: When you need unique elements.
     */
    private static void demonstrateSet() {
        Set<Product> productSet = new HashSet<>();
        productSet.add(new Product(1, "Laptop", 1200.0));
        productSet.add(new Product(1, "Laptop", 1200.0)); // Duplicate ignored (uses equals/hashCode)
        productSet.add(new Product(2, "Monitor", 300.0));

        System.out.println("Set Size (Should be 2): " + productSet.size());
        for (Product p : productSet) System.out.println(p);

        // Check for existence
        System.out.println("Contains Laptop? " + productSet.contains(new Product(1, "Laptop", 1200.0)));
    }

    /**
     * Map: Key-Value pairs. Keys must be unique.
     * Use case: Fast lookup by a specific key.
     */
    private static void demonstrateMap() {
        Map<String, Product> inventory = new HashMap<>();
        inventory.put("101", new Product(101, "Server", 5000.0));
        inventory.put("102", new Product(102, "Switch", 1500.0));
        inventory.put("101", new Product(101, "Super Server", 8000.0)); // Key 101 replaced

        System.out.println("Map Values:");
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " -> " + entry.getValue());
        }

        // Fast Lookup
        Product found = inventory.get(102);
        System.out.println("Found ID 102: " + (found != null ? found.getName() : "Not Found"));
    }

    /**
     * Queue: FIFO (First In First Out) or Priority-based.
     */
    private static void demonstrateQueue() {
        // PriorityQueue orders elements according to natural ordering (ID in Product)
        Queue<Product> shippingQueue = new PriorityQueue<>();
        shippingQueue.add(new Product(3, "Late Order", 50.0));
        shippingQueue.add(new Product(1, "Priority Order", 500.0));
        shippingQueue.add(new Product(2, "Normal Order", 150.0));

        System.out.println("Polling from PriorityQueue (Orders by ID):");
        while (!shippingQueue.isEmpty()) {
            System.out.println("Shipping: " + shippingQueue.poll());
        }
    }
}
