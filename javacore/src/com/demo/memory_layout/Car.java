package com.demo.memory_layout;

/**
 * Car class - instances are created on the HEAP.
 */
public class Car {
    // Field 'make' is a reference variable stored within the Car object on the HEAP.
    // It points to a String literal in the STRING POOL.
    public String make;

    public Car(String make) {
        this.make = make;
    }
}
