package com.demo.student.main;

import com.demo.student.model.Student;
import com.demo.student.service.StudentService;
import com.demo.student.service.StudentServiceImpl;

import java.util.Scanner;

public class StudentManagementMain {
    private static final StudentService service = new StudentServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Pre-fill some data (Requirement 1.7)
        service.addStudent(new Student("S01", "Alice", 20, 3.8));
        service.addStudent(new Student("S02", "Bob", 21, 3.1));
        service.addStudent(new Student("S03", "Charlie", 19, 3.5));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Choose an option: ");

            switch (choice) {
                case 1: addStudent(); break;
                case 2: service.displayAll(); break;
                case 3: findById(); break;
                case 4: deleteById(); break;
                case 5: service.sortByGpa(); break;
                case 6: service.showStatistics(); break;
                case 0:
                    running = false;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Show All Students");
        System.out.println("3. Find Student by ID");
        System.out.println("4. Delete Student");
        System.out.println("5. Sort by GPA (Descending)");
        System.out.println("6. Show Statistics");
        System.out.println("0. Exit");
    }

    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        String id = getStringInput("Enter ID: ");
        String name = getStringInput("Enter Name: ");
        int age = getIntInput("Enter Age: ");
        double gpa = getDoubleInput("Enter GPA (0.0 - 4.0): ");

        service.addStudent(new Student(id, name, age, gpa));
    }

    private static void findById() {
        String id = getStringInput("Enter ID to search: ");
        Student s = service.findById(id);
        if (s != null) {
            System.out.println("Found: " + s);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteById() {
        String id = getStringInput("Enter ID to delete: ");
        service.deleteById(id);
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int val = Integer.parseInt(scanner.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double val = Double.parseDouble(scanner.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a decimal number.");
            }
        }
    }
}
