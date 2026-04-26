package com.demo.enums;

public class EnumDemo {
    public static void main(String[] args) {
        OrderStatus currentStatus = OrderStatus.PROCESSING;

        System.out.println("Current Order Status: " + currentStatus);
        System.out.println("Description: " + currentStatus.getDescription());

        // Using Enum in a switch statement
        checkStatus(currentStatus);

        // Iterating over all enum values
        System.out.println("\nAll available statuses:");
        for (OrderStatus status : OrderStatus.values()) {
            System.out.println("- " + status + ": " + status.getDescription());
        }

        // Comparing enums
        OrderStatus shipped = OrderStatus.SHIPPED;
        if (currentStatus != shipped) {
            System.out.println("\nOrder has not been shipped yet.");
        }
    }

    public static void checkStatus(OrderStatus status) {
        switch (status) {
            case PENDING:
                System.out.println("Wait for processing.");
                break;
            case PROCESSING:
                System.out.println("The kitchen is busy!");
                break;
            case SHIPPED:
                System.out.println("It's on the way.");
                break;
            case DELIVERED:
                System.out.println("Enjoy your meal!");
                break;
            case CANCELLED:
                System.out.println("Order was voided.");
                break;
        }
    }
}
