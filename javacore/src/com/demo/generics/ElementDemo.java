package com.demo.generics;

public class ElementDemo {
    public static void main(String[] args) {
        System.out.println("--- Generic <E> Demo ---");

        // 1. Using CustomList with String elements
        CustomList<String> stringList = new CustomList<>();
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Cherry");
        
        System.out.println("String List: " + stringList);
        System.out.println("Element at index 1: " + stringList.get(1));
        
        String removedString = stringList.remove(0);
        System.out.println("Removed: " + removedString);
        System.out.println("String List after removal: " + stringList);
        System.out.println("Size: " + stringList.size());

        System.out.println("\n------------------------");

        // 2. Using CustomList with Integer elements
        CustomList<Integer> numberList = new CustomList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);

        System.out.println("Number List: " + numberList);
        System.out.println("Element at index 2: " + numberList.get(2));
        
        Integer removedNumber = numberList.remove(3);
        System.out.println("Removed: " + removedNumber);
        System.out.println("Number List after removal: " + numberList);
        System.out.println("Size: " + numberList.size());
        
        System.out.println("\n------------------------");
        
        // 3. Demonstrating Type Safety
        // Because we used <E>, the compiler prevents adding wrong types.
        // numberList.add("String"); // Uncommenting this would cause a compilation error
        // stringList.add(100);      // Uncommenting this would cause a compilation error
        System.out.println("Type safety is enforced at compile time!");
    }
}
