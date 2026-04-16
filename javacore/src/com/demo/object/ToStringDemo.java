package com.demo.object;

public class ToStringDemo {
    public static void main(String[] args) {
        // Demo khi chưa override toString()
        Category cat = new Category("Điện tử");
        System.out.println("Kết quả Category (chưa override): " + cat);
        
        System.out.println("-------------------------------------------------");

        // Demo khi đã override toString()
        Product prod = new Product(101, "Laptop Dell", 1500.0);
        System.out.println("Kết quả Product (đã override): " + prod);
    }
}
