package com.demo.abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. ABSTRACTION WITH CLASSES ===");
        Animal dog = new Dog("Buddy");
        dog.makeSound();
        dog.sleep();

        System.out.println("\n=== 2. ABSTRACTION WITH INTERFACES (Services) ===");
        User admin = new User(1, "admin", "admin@demo.com");
        User customer = new User(101, "john_doe", "john@gmail.com");

        // Sử dụng UserService thông qua đa hình
        UserService customerService = new CustomerService();
        UserService employeeService = new EmployeeService();

        System.out.println("--- Customer logic ---");
        customerService.create(customer);
        customerService.sendEmail(admin, customer);

        System.out.println("\n--- Employee logic (delegated to API) ---");
        employeeService.create(admin);
        employeeService.delete(admin);

        System.out.println("\n=== 3. MULTIPLE IMPLEMENTATION DEMO ===");
        // Dog vừa kế thừa Animal vừa triển khai Pet
        Pet petDog = new Dog("Lulu");
        petDog.play();
    }
}
