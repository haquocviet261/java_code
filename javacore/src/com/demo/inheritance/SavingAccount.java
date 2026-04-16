package com.demo.inheritance;

/**
 * Lớp con: Tài khoản tiết kiệm (SavingAccount)
 * Kế thừa BankAccount và thêm tính năng lãi suất.
 */
public class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(String accountNumber, double balance, double interestRate) {
        // Gọi constructor của lớp cha
        this(interestRate);
        this.interestRate = interestRate;
    }


    public SavingAccount(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    public void addInterest(float interestRate) {
        double interest = super.getBalance() * interestRate / 100;
        super.setBalance(super.getBalance() + interest);
        System.out.println("Đã cộng lãi suất: " + interest);
    }

    public void addInterest(int interestRate) {
        double interest = super.getBalance() * interestRate / 100;
        super.setBalance(super.getBalance() + interest);
        System.out.println("Đã cộng lãi suất: " + interest);
    }

    public void addInterest(int interestRate, boolean isAccountActive) {
        double interest = super.getBalance() * interestRate / 100;
        super.setBalance(super.getBalance() + interest);
        System.out.println("Đã cộng lãi suất: " + interest);
    }

    public void addInterest() {
        double interest = super.getBalance() * interestRate / 100;
        super.setBalance(super.getBalance() + interest);
        System.out.println("Đã cộng lãi suất: " + interest);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            super.setBalance(super.getBalance() + amount);
            System.out.println("[SAVING] " + amount + " vào tài khoản " + super.getBalance());
        }

    }

    @Override
    public void displayInfo() {
        System.out.print("[Saving] ");
        super.displayInfo();
        System.out.println("Lãi suất: " + interestRate + "%");
    }

//    @Override
//    public boolean equals(Object obj) {
//        SavingAccount saving  = (SavingAccount) obj;
//        return saving.getBalance() == this.getBalance() && interestRate == saving.interestRate && saving.getAccountNumber() == saving.getAccountNumber();
//    }
}
