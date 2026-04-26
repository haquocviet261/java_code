package com.demo.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Visualizes how Locks work in Java.
 * This demo simulates multiple employees trying to use a single shared Printer.
 * We use a ReentrantLock to ensure only one person can print at a time.
 */
public class LockVisualizationDemo {

    // The shared resource (Printer)
    static class Printer {
        // A ReentrantLock is an advanced lock that gives us more control than 'synchronized'
        private final Lock printLock = new ReentrantLock();

        public void printDocument(String documentName) {
            String threadName = Thread.currentThread().getName();
            
            System.out.println("[WAIT] [" + threadName + "] is requesting the printer lock...");

            // Thread will pause here if another thread already holds the lock
            printLock.lock(); 
            
            try {
                // --- CRITICAL SECTION START ---
                // Only ONE thread can be inside this block at a time
                System.out.println("[GO]   [" + threadName + "] ACQUIRED the lock. Starting to print: " + documentName);
                
                // Simulate printing time
                for (int i = 1; i <= 3; i++) {
                    System.out.println("       > [" + threadName + "] printing page " + i + "...");
                    Thread.sleep(500); // 0.5 seconds per page
                }
                
                System.out.println("[DONE] [" + threadName + "] finished printing.");
                // --- CRITICAL SECTION END ---

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // ALWAYS release the lock in a finally block to prevent deadlocks
                // if an exception occurs during printing.
                System.out.println("[FREE] [" + threadName + "] RELEASED the printer lock.\n");
                printLock.unlock(); 
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Printer Lock Visualization Demo ===\n");
        
        Printer sharedPrinter = new Printer();

        // Create 3 threads (Employees) trying to use the same printer
        Thread emp1 = new Thread(() -> sharedPrinter.printDocument("Annual_Report.pdf"), "Employee-1");
        Thread emp2 = new Thread(() -> sharedPrinter.printDocument("Budget_V2.xlsx"), "Employee-2");
        Thread emp3 = new Thread(() -> sharedPrinter.printDocument("Resignation_Letter.docx"), "Employee-3");

        // Start them almost simultaneously
        emp1.start();
        emp2.start();
        emp3.start();
    }
}
