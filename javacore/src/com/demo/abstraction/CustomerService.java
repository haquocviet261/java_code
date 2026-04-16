package com.demo.abstraction;

/**
 * Triển khai UserService dành cho đối tượng Khách hàng (Customer).
 * Logic đặc thù: Khi xóa khách hàng, có thể cần kiểm tra lịch sử mua hàng.
 */
public class CustomerService implements UserService {

    @Override
    public boolean create(User user) {
        System.out.println("[CustomerService] Creating customer: " + user.getUsername());
        return true;
    }

    @Override
    public boolean update(User user) {
        System.out.println("[CustomerService] Updating profile for customer ID: " + user.getId());
        return true;
    }

    @Override
    public boolean delete(User user) {
        System.out.println("[CustomerService] Removing customer ID: " + user.getId());
        return true;
    }

    @Override
    public boolean sendEmail(User sender, User receiver) {
        System.out.println("[CustomerService] Sending promotion email from " + sender.getUsername() + " to " + receiver.getUsername());
        return true;
    }
}
