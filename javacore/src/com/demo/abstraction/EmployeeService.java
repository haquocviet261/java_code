package com.demo.abstraction;

/**
 * Triển khai UserService dành cho đối tượng Nhân viên (Employee).
 * Logic đặc thù: Khi thao tác với nhân viên, chúng ta gọi thông qua một ApiService (UserClient).
 */
public class EmployeeService implements UserService {
    private ApiService apiService = new UserClient();

    @Override
    public boolean create(User user) {
        System.out.println("[EmployeeService] Delegating creation to API...");
        return apiService.callApiPost(user);
    }

    @Override
    public boolean update(User user) {
        System.out.println("[EmployeeService] Delegating update to API...");
        return apiService.callApiPut(user);
    }

    @Override
    public boolean delete(User user) {
        System.out.println("[EmployeeService] Delegating deletion to API...");
        return apiService.callApiDelete(user);
    }

    @Override
    public boolean sendEmail(User sender, User receiver) {
        System.out.println("[EmployeeService] Internal employee email notification sent.");
        return true;
    }
}
