package com.demo.abstraction;

/**
 * Interface minh họa việc sử dụng hằng số (static final) và phương thức trừu tượng.
 */
public interface Shape {
    float PI = 3.14f;

    float calculateArea(int width, int height);
    
    // Default method (Java 8+): Cung cấp logic mặc định nếu lớp con không ghi đè
    default void printShapeName() {
        System.out.println("This is a generic shape.");
    }
}
