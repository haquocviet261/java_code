package com.demo.generics;

import java.util.*;

/**
 * Main class to demonstrate Java Generics.
 */
public class GenericDemo {

    public static void main(String[] args) {
        System.out.println("--- 1. GENERIC CLASS DEMO ---");
        demonstrateGenericClass();

        System.out.println("\n--- 2. GENERIC METHOD DEMO ---");
        demonstrateGenericMethod();

        System.out.println("\n--- 3. BOUNDED TYPE PARAMETERS DEMO ---");
        demonstrateBoundedType();

        System.out.println("\n--- 4. WILDCARD DEMO (?, ? extends, ? super) ---");
        demonstrateWildcards();
    }

    /**
     * Demonstrates a simple generic class (Box<T>).
     */
    private static void demonstrateGenericClass() {
        Box<Integer> intBox = new Box<>(123);
        Box<String> stringBox = new Box<>("Hello Generics");

        System.out.println("Integer Box: " + intBox.get());
        System.out.println("String Box: " + stringBox.get());
    }

    /**
     * Demonstrates a generic method that can work with different types of arrays.
     */
    private static void demonstrateGenericMethod() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Java", "Python", "C++"};

        System.out.print("Printing Integer Array: ");
        printArray(intArray);

        System.out.print("Printing String Array: ");
        printArray(stringArray);
    }

    private static <E> void printArray(E[] inputArray) {
        for (E element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Demonstrates Bounded Type Parameters (T extends Number).
     */
    private static void demonstrateBoundedType() {
        // Double and Integer both extend Number
        displaySum(10, 20.5);
    }

    private static <T extends Number, U extends Number> void displaySum(T n1, U n2) {
        double sum = n1.doubleValue() + n2.doubleValue();
        System.out.println("Sum of " + n1 + " and " + n2 + " is: " + sum);
    }

    /**
     * Demonstrates wildcards: Unbounded (?), Upper Bounded (? extends), Lower Bounded (? super).
     */
    private static void demonstrateWildcards() {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<Number> numList = new ArrayList<>();

        System.out.print("Unbounded Wildcard (List<?>): ");
        printList(intList);
        printList(doubleList);

        System.out.println("Upper Bounded Wildcard (sum of numbers): " + sumOfList(intList));
        System.out.println("Upper Bounded Wildcard (sum of doubles): " + sumOfList(doubleList));

        System.out.println("Lower Bounded Wildcard (adding integers to Number list): ");
        addNumbers(numList);
        System.out.println("Number list after addNumbers: " + numList);
    }

    // Unbounded Wildcard: Can take a list of any type
    private static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    // Upper Bounded Wildcard: Can take List of Number or its subclasses (Integer, Double, etc.)
    private static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    // Lower Bounded Wildcard: Can take List of Integer or its superclasses (Number, Object)
    private static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
    }
}
