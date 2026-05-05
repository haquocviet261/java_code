package com.demo.threads;

import java.util.concurrent.Future;

/**
 * Programmatically demonstrates the different states of a Thread (Thread Lifecycle).
 * States: NEW, RUNNABLE, TIMED_WAITING, WAITING, BLOCKED, TERMINATED.
 */
public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                // State: RUNNABLE (when running)
                Thread.sleep(500); // Transitions to TIMED_WAITING

//                synchronized (lock) {
//                  //  lock.wait();
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("1. State after creation: " + t1.getState()); // NEW

        t1.start();
        System.out.println("2. State after start(): " + t1.getState()); // RUNNABLE

        Thread.sleep(100);
        System.out.println("3. State during sleep(): " + t1.getState()); // TIMED_WAITING

        Thread.sleep(600);
//        synchronized (lock) {
//            System.out.println("4. State during wait(): " + t1.getState()); // WAITING
//            lock.notify(); // Wake it up
//        }
        //
        // Future, CompleteableFuture, ExecutorService, threadpool

        t1.join();
        System.out.println("5. State after completion: " + t1.getState()); // TERMINATED
    }
}
