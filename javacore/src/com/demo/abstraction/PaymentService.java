package com.demo.abstraction;

/**
 * Interface cho dịch vụ thanh toán.
 * Minh họa việc định nghĩa các bước nghiệp vụ mà không cần biết phương thức thanh toán cụ thể.
 */
public interface PaymentService {
    void initializeTransaction(double amount);
    void processTransaction();
    void checkTransactionStatus(String transactionId);
}
