package com.demo.inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        // 1. Demo SavingAccount

        System.out.println("--- DEMO TÀI KHOẢN TIẾT KIỆM ---");
        BankAccount saving = new SavingAccount("SV001", 1000, 5.0);
//        saving.displayInfo();
//        saving.deposit(1500);
//        saving.addInterest();
//        saving.displayInfo();
//        System.out.println("saving: " + saving.toString());

        System.out.println("\n---------------------------------");

        // 2. Demo CurrentAccount
        System.out.println("--- DEMO TÀI KHOẢN VÃNG LAI ---");
        BankAccount current = new CurrentAccount("CR001", 200, 500);
        current.displayInfo();
        current.withdraw(600); // Rút vượt số dư hiện tại nhưng trong hạn mức thấu chi
        current.displayInfo();

        System.out.println("\n--- DEMO TÍNH ĐA HÌNH (POLYMORPHISM) ---");
        // Một biến kiểu BankAccount có thể trỏ tới đối tượng lớp con
        BankAccount acc = new SavingAccount("SV002", 2000, 3.0);
        acc.displayInfo(); // Sẽ gọi displayInfo() của SavingAccount
    }
}
