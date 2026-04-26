package hr.main;

import hr.enums.Role;
import hr.model.*;
import hr.service.RequestService;
import hr.service.impl.RequestServiceImpl;

public class HRMain {
    public static void main(String[] args) {
        // Initialize Service using Implementation
        RequestService service = new RequestServiceImpl();

        // 1. Setup Manager and Employees
        Employee manager = new Employee("M-01", "Alex Director", Role.MANAGER);
        Employee emp1 = new Employee("E-01", "Alice", Role.EMPLOYEE);
        Employee emp2 = new Employee("E-02", "Bob", Role.EMPLOYEE);

        // 2. Employees Create and Submit Requests
        LeaveRequest leave = new LeaveRequest(emp1.getId(), new LeaveDetail(5, "Summer Vacation"));
        OTRequest ot = new OTRequest(emp2.getId(), new OTDetail(8.0, "System Migration"));

        System.out.println("--- PHASE 1: SUBMISSION ---");
        service.submit(leave);
        service.submit(ot);

        // 3. Manager View Requests BEFORE Approval
        System.out.println("\n--- PHASE 2: MANAGER VIEW (BEFORE) ---");
        service.getAllRequests(manager).forEach(System.out::println);

        // 4. Manager Processes Requests
        System.out.println("\n--- PHASE 3: PROCESSING ---");
        service.approve(manager, leave.getId());
        service.reject(manager, ot.getId());

        // 5. Final Status View
        System.out.println("\n--- PHASE 4: FINAL STATUS ---");
        service.getAllRequests(manager).forEach(System.out::println);
    }
}
