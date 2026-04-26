package com.demo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrates the use of ExecutorService for managing a pool of threads.
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        // Create a fixed pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Submitting 10 tasks to the executor...");

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " is being executed by " + threadName);
                try {
                    // Simulate some work
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " finished by " + threadName);
            });
        }

        // Shut down the executor gracefully
        executor.shutdown();
        
        try {
            // Wait for all tasks to complete or timeout
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println("All tasks completed. Executor shut down.");
    }
}
