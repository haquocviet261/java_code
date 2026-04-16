package com.demo.exception;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionDemo {

    public static void main(String[] args) {
        System.out.println("--- DEMO UNCHECKED EXCEPTION ---");
        handleUncheckedException(10, 0);

        System.out.println("\n--- DEMO CHECKED EXCEPTION (File) ---");
        handleCheckedExceptionWithFile();

        System.out.println("\n--- DEMO CUSTOM CHECKED EXCEPTION ---");
        try {
            validateAge(15); // Tuổi nhỏ hơn 18 sẽ gây ra lỗi
        } catch (InvalidAgeException e) {
            System.err.println("Caught Custom Checked Exception: " + e.getMessage());
        }
    }

    /**
     * 1. UNCHECKED EXCEPTION (Runtime Exception)
     * Thường xảy ra do lỗi logic (chia cho 0, null pointer, index out of bounds).
     * Trình biên dịch KHÔNG bắt buộc bạn phải try-catch.
     */
    public static void handleUncheckedException(int a, int b) {
        try {
            int result = a / b; // Có thể gây ra ArithmeticException nếu b = 0
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Caught Unchecked Exception: Cannot divide by zero!");
        }
    }

    /**
     * 2. CHECKED EXCEPTION
     * Các ngoại lệ liên quan đến các yếu tố bên ngoài (File, Network, Database).
     * Trình biên dịch BẮT BUỘC phải xử lý bằng try-catch hoặc dùng 'throws'.
     */
    public static void handleCheckedExceptionWithFile() {
        File file = new File("non_existent_file.txt");
        try {
            // FileReader ném ra FileNotFoundException (là một Checked Exception)
            FileReader fr = new FileReader(file);
        } catch (IOException e) {
            System.err.println("Caught Checked Exception: File not found or cannot be read.");
        }
    }

    /**
     * Minh họa việc dùng 'throws' cho Checked Exception.
     * Phương thức này không tự xử lý lỗi mà đẩy trách nhiệm cho nơi gọi nó.
     */
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Phải khai báo 'throws' ở chữ ký hàm vì InvalidAgeException là Checked
            throw new InvalidAgeException("Age must be at least 18 to join.");
        }
        System.out.println("Welcome! Age is valid.");
    }
}
