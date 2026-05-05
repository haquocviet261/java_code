package com.demo.enums;

public enum OrderStatus {

    PENDING("Order has been placed but not yet processed"),
    PROCESSING("Order is being prepared"),
    SHIPPED("Order has been handed over to the carrier"),
    DELIVERED("Order has been received by the customer"),
    CANCELLED("Order was cancelled");

    private final String description;

    // Enum constructor is private by default
    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
