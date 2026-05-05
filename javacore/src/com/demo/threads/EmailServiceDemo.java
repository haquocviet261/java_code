package com.demo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Real-world Use Case: Asynchronous Email Notification Service.
 * In a real app (like an E-commerce site), you don't want the customer to wait 
 * for an email to be sent before seeing their "Order Confirmed" page.
 */
public class EmailServiceDemo {
    
    // A fixed thread pool acting as a "Background Worker"
    private final ExecutorService emailWorkerPool = Executors.newFixedThreadPool(2);

    public void processOrder(String orderId, String customerEmail) {
        System.out.println("[Main Thread] Processing order: " + orderId);
        
        // 1. Save order to DB (Simulated)
        System.out.println("[Main Thread] Saving order " + orderId + " to database...");
        

        System.out.println("[Main Thread] Order " + orderId + " confirmed! (User doesn't wait for email)");
    }

    private void sendEmail(String orderId, String email) {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("  [" + threadName + "] Connecting to SMTP server...");
            Thread.sleep(3000); // Simulate network latency (3 seconds)
            System.out.println("  [" + threadName + "] Email sent to " + email + " for Order " + orderId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        emailWorkerPool.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        EmailServiceDemo service = new EmailServiceDemo();
        
        // Simulate multiple customers placing orders
        service.processOrder("ORD-101", "user1@example.com");
        service.processOrder("ORD-102", "user2@example.com");
        service.processOrder("ORD-103", "user3@example.com");

        System.out.println("\n[Main Thread] I am free to handle other requests while emails send in background.\n");
        
        // Wait a bit to see background logs then shutdown
        Thread.sleep(10000);
        service.shutdown();
    }
}
