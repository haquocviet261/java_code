package com.demo.polymorphism;

public class CreditCardPayment extends Payment{
    public CreditCardPayment() {
    }

    public void processPayment(double amount) {

        System.out.println("Processing credit card payment of $" + amount + " (Applying 2% transaction fee)");
    }
}
