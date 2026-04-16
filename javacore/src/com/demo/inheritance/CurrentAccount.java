package com.demo.inheritance;

/**
 * Lớp con: Tài khoản vãng lai (CurrentAccount)
 * Kế thừa BankAccount và thêm hạn mức thấu chi (overdraft limit).
 */
public class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Override phương thức withdraw để cho phép thấu chi
    @Override
    public void withdraw(double amount) {
//        if (amount > 0 && amount <= (balance + overdraftLimit)) {
//            balance -= amount;
//            System.out.println("Rút " + amount + " (Thấu chi cho phép) từ " + accountNumber);
//        } else {
//            System.out.println("Vượt quá hạn mức thấu chi!");
//        }
    }

    @Override
    public void displayInfo() {
        System.out.print("[Current] ");
        super.displayInfo();
        System.out.println("Hạn mức thấu chi: " + overdraftLimit);
    }
}
