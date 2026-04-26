package com.demo.memory_layout;

/**
 * Main class to demonstrate JVM Memory Layout.
 * 
 * Memory Areas Covered:
 * 1. METHOD AREA: Stores class structures (Person, Car), constants, static fields.
 * 2. STACK: Stores local variables and partial results. Each thread has its own stack.
 * 3. HEAP: Stores all objects (Person instances, Car instances, etc.).
 * 4. STRING POOL: A special area in the Heap for caching String literals.
 */
public class MemoryLayoutExample {

    public static void main(String[] args) {
        // --- STACK Frame: main() begins ---

        // 1. Primitive Variable: 'x'
        // 'x' is a primitive local variable. It is stored directly in the main() stack frame.
        int x = 10; 

        String firstName = "John";
        String lastName = "Doe";

        String unused = "Peter";

        Car myCar = new Car("Chevy");

        Person p = new Person(firstName, lastName, 25, myCar);

        p.drive();

        String a = "John";
        String b = "John";
        System.out.println("a == b: " + (a == b));

        String c = new String("John");
        System.out.println("a == c: " + (a == c));

        Person p2 = p;
        p2.age = 30;

        System.out.println("Person p age: " + p.age);

    }
}
