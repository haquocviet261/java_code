package com.demo.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    public static void main(String[] args) {
        // Đa hình tại thời điểm chạy (Runtime Polymorphism)
        Payment p1 = new CreditCardPayment();
        Payment p2 = new CashPayment();

        p1.processPayment(100.0);
        p2.processPayment(200.0);
    }
}
