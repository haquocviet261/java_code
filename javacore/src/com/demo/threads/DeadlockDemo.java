package com.demo.threads;

/**
 * Visualizes a Deadlock scenario.
 * Deadlock occurs when two or more threads are blocked forever, 
 * each waiting for the other to release a resource.
 * 
 * Scenario: 
 * Thread 1 holds Resource A and waits for Resource B.
 * Thread 2 holds Resource B and waits for Resource A.
 */
public class DeadlockDemo {

    public static void main(String[] args) {
        // Two shared resources (can be any object)
        final Object resourceA = "Resource A (Scanner)";
        final Object resourceB = "Resource B (Printer)";

        System.out.println("=== Deadlock Visualization Demo ===");
        System.out.println("[INFO] Watch how the program freezes forever...\n");

        // Thread 1: Tries to lock A then B
        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("[T1] Locked " + resourceA);

                try { 
                    // Sleep to ensure Thread 2 locks Resource B in the meantime
                    Thread.sleep(100); 
                } catch (InterruptedException e) {}

                System.out.println("[T1] Waiting for " + resourceB + "...");
                synchronized (resourceB) {
                    System.out.println("[T1] This line will NEVER be reached!");
                }
            }
        }, "Thread-1");

        // Thread 2: Tries to lock B then A
        Thread t2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("[T2] Locked " + resourceB);

                try { 
                    // Sleep to ensure Thread 1 locks Resource A in the meantime
                    Thread.sleep(100); 
                } catch (InterruptedException e) {}

                System.out.println("[T2] Waiting for " + resourceA + "...");
                synchronized (resourceA) {
                    System.out.println("[T2] This line will NEVER be reached!");
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();

        // Adding a monitor to tell the user the deadlock is active
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("\n[MONITOR] 3 seconds have passed.");
                System.out.println("[MONITOR] Notice that the program is still 'running' but nothing is happening.");
                System.out.println("[MONITOR] Threads are now in a DEADLOCK state.");
                System.out.println("[MONITOR] You will need to press Ctrl+C to stop this program.");
            } catch (InterruptedException e) {}
        }).start();
    }
}
