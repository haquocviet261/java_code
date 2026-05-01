package com.demo.enums;

public enum OrderStatus {

    PENDING("Order has been placed but not yet processed", "1"),
    PROCESSING("Order is being prepared", "2"),
    SHIPPED("Order has been handed over to the carrier", "3"),
    DELIVERED("Order has been received by the customer", "4"),
    CANCELLED("Order was cancelled", "5");

    private final String description;
    private final String key;

    // Enum constructor is private by default
    OrderStatus(String description) {
        this.description = description;
    }

    OrderStatus(String description, String key) {
        this.description = description;
        this.key = key;
    }

    public String getDescription() {
        return description;
    }
}
