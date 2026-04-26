package com.demo.exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionAdvancedDemo {

    public static void main(String[] args) {
        System.out.println("--- 1. MULTIPLE CATCH BLOCKS ---");
        handleMultipleExceptions("abc");

        System.out.println("\n--- 2. FINALLY BLOCK ---");
        demoFinallyBlock();

        System.out.println("\n--- 3. TRY-WITH-RESOURCES ---");
        demoTryWithResources();

        System.out.println("\n--- 4. CUSTOM UNCHECKED EXCEPTION ---");
        processData(null);
    }

    /**
     * Minh họa xử lý nhiều loại ngoại lệ trong cùng một khối try.
     * Lưu ý: Các exception cụ thể phải được catch trước các exception chung (cha).
     */
    public static void handleMultipleExceptions(String input) {
        try {
            int number = Integer.parseInt(input); // Có thể gây NumberFormatException
            int result = 100 / number;            // Có thể gây ArithmeticException
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.err.println("Error: Input is not a valid number.");
        } catch (ArithmeticException e) {
            System.err.println("Error: Cannot divide by zero.");
        } catch (Exception e) {
            System.err.println("Generic error occurred: " + e.getMessage());
        }
    }

    /**
     * Khối 'finally' luôn chạy dù có lỗi hay không.
     * Thường dùng để giải phóng tài nguyên (đóng stream, kết nối DB).
     */
    public static void demoFinallyBlock() {
        try {
            System.out.println("Inside try block.");
            throw new RuntimeException("Something went wrong!");
        } catch (RuntimeException e) {
            System.err.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed (always runs).");
        }
    }

    /**
     * Try-with-resources (Java 7+): 
     * Tự động đóng các tài nguyên (như FileReader) sau khi kết thúc khối try.
     */
    public static void demoTryWithResources() {
        // BufferedReader sẽ được tự động đóng mà không cần khối finally
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }

    /**
     * Sử dụng Custom Unchecked Exception.
     * Không cần từ khóa 'throws' ở chữ ký phương thức.
     */
    public static void processData(String data) {
        if (data == null) {
            throw new InvalidDataException("Data cannot be null.");
        }
        System.out.println("Processing: " + data);
    }
}
