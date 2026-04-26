package com.demo.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates Race Conditions and how to solve them using:
 * 1. synchronized keyword
 * 2. Atomic variables
 */
public class ThreadSynchronizationDemo {
    private int counter = 0;
    private final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ThreadSynchronizationDemo demo = new ThreadSynchronizationDemo();
        demo.runDemo();
    }

    public void runDemo() throws InterruptedException {
        // Shared task: Increment counter 10,000 times
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                incrementUnsafe();     // Problematic
                incrementSynchronized(); // Safe (Locking)
                atomicCounter.incrementAndGet(); // Safe (Lock-free)
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Expected count: 20000");
        System.out.println("Unsafe count:   " + counter);
        System.out.println("Sync count:     " + syncCounter);
        System.out.println("Atomic count:   " + atomicCounter.get());
    }

    // This will likely result in a value less than 20,000 due to race conditions
    public void incrementUnsafe() {
        counter++;
    }

    private int syncCounter = 0;
    // synchronized ensures only one thread can execute this at a time
    public synchronized void incrementSynchronized() {
        syncCounter++;
    }
}
