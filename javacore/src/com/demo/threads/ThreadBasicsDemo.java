package com.demo.threads;

/**
 * Demonstrates basic thread creation using Thread class and Runnable interface.
 */
public class ThreadBasicsDemo {
    public static void main(String[] args) {
        System.out.println("Main thread starting: " + Thread.currentThread().getName());

        // 1. Extending Thread class
        MyThread t1 = new MyThread();
        t1.setName("Thread-Extended");

        // 2. Implementing Runnable interface (Preferred)
        Thread t2 = new Thread(new MyRunnable(), "Runnable-Implemented");

        // 3. Using Lambda (Modern Java)
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " (Lambda) is running: " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }, "Lambda-Thread");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        try {
            // join() waits for threads to finish before main continues
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(getName() + " is running: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
