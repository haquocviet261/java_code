package com.demo.inheritance;


import com.sun.jndi.cosnaming.IiopUrl;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private IiopUrl.Address address;

    public BankAccount() {
    }

    public BankAccount(final String accountNumber,final double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(final double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Nạp " + amount + " vào tài khoản " + accountNumber);
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public void withdraw(final double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Rút " + amount + " từ tài khoản " + accountNumber);
        } else {
            System.out.println("Số dư không đủ để rút " + amount);
        }
    }

    public void displayInfo() {
        System.out.println("Tài khoản: " + this.accountNumber + " | Số dư: " + this.balance);
    }
}
