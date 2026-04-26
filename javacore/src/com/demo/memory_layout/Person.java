package com.demo.memory_layout;

/**
 * Person class - instances are created on the HEAP.
 */
public class Person {
    // These instance fields are stored on the HEAP within the Person object.
    public String fname; // reference to String Pool
    public String lname; // reference to String Pool
    public int age;      // primitive value directly in Heap object
    public Car car;      // reference to Car object on the Heap

    // Static fields are stored in the METHOD AREA (or Metaspace).
    // All instances of Person share this single memory location.
    public static String species = "Homo Sapiens";

    public Person(String fname, String lname, int age, Car car) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.car = car;
    }

    /**
     * Demonstrates Stack Frame behavior.
     */
    public void drive() {
        // --- STACK: A new frame is created for this method call ---
        
        // message is a local variable stored in this method's Stack frame.
        // It points to a String literal in the String Pool.
        String message = "is driving a car at a speed of"; 

        // speed is a primitive local variable stored directly in the Stack frame.
        int speed = 60; 

        System.out.println(fname + " " + lname + " " + message + " " + speed + " km/h with " + car.make);
        
        // --- STACK: When drive() finishes, this frame is popped and message/speed variables are removed.
    }
}
