package com.demo.abstraction;

/**
 * Triển khai cụ thể của UserService.
 * Trong thực tế, lớp này có thể gọi tới Database hoặc một Web Service khác.
 * Việc sử dụng Interface giúp tách biệt 'hành vi' và 'cách thực hiện'.
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean create(User user) {
        System.out.println("Saving user to database: " + user.getUsername());
        return true;
    }

    @Override
    public boolean update(User user) {
        System.out.println("Updating user info for ID: " + user.getId());
        return true;
    }

    @Override
    public boolean delete(User user) {
        System.out.println("Deleting user: " + user.getUsername());
        return true;
    }

    @Override
    public boolean sendEmail(User sender, User receiver) {
        System.out.println("Email sent from [" + sender.getEmail() + "] to [" + receiver.getEmail() + "]");
        return true;
    }
}
