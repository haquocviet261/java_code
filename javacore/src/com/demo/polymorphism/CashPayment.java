package com.demo.polymorphism;

public class CashPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount + " (No transaction fee)");
    }
}
