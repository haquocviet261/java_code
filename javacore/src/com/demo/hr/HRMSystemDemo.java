package com.demo.hr;

import com.demo.hr.model.*;
import com.demo.hr.repository.EmployeeRepository;
import com.demo.hr.repository.RequestRepository;
import com.demo.hr.service.RequestService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HRMSystemDemo {
    public static void main(String[] args) throws Exception {
        EmployeeRepository empRepo = new EmployeeRepository();
        RequestRepository reqRepo = new RequestRepository();
        RequestService service = new RequestService(reqRepo, empRepo);

        // Setup Employees
        Employee alice = new Employee("E001", "Alice", "IT");
        Employee bob = new Employee("E002", "Bob", "IT");
        bob.addRole(Role.MANAGER);
        Employee charlie = new Employee("E003", "Charlie", "HR");
        charlie.addRole(Role.ADMIN);

        empRepo.save(alice);
        empRepo.save(bob);
        empRepo.save(charlie);

        System.out.println("--- Scenario 1: Multi-level Approval (Happy Path) ---");
        LeaveRequest leave = new LeaveRequest("REQ001", "E001", 2, 
                LocalDate.now().plusDays(1), LocalDate.now().plusDays(3), "Family vacation");
        service.createRequest(leave);
        service.submitRequest("REQ001", "E001");
        System.out.println("Status after submit: " + leave.getStatus() + " (Level: " + leave.getCurrentLevel() + "/" + leave.getRequiredLevel() + ")");

        service.approveRequest("REQ001", "E002"); // Manager Bob
        System.out.println("Status after Manager approval: " + leave.getStatus() + " (Level: " + leave.getCurrentLevel() + ")");

        service.approveRequest("REQ001", "E003"); // Admin Charlie
        System.out.println("Status after Admin approval: " + leave.getStatus() + " (Level: " + leave.getCurrentLevel() + ")");

        System.out.println("\n--- Scenario 2: Reject Flow ---");
        OTRequest ot = new OTRequest("REQ002", "E001", 1, 4.0, "Urgent bug fix");
        service.createRequest(ot);
        service.submitRequest("REQ002", "E001");
        service.rejectRequest("REQ002", "E002", "Not necessary");
        System.out.println("Status after reject: " + ot.getStatus());
        try {
            service.approveRequest("REQ002", "E003");
        } catch (Exception e) {
            System.out.println("Expected error when approving rejected: " + e.getMessage());
        }

        System.out.println("\n--- Scenario 3: Modify After Submit ---");
        LeaveRequest leave2 = new LeaveRequest("REQ003", "E001", 2,
                LocalDate.now().plusDays(5), LocalDate.now().plusDays(7), "Medical checkup");
        service.createRequest(leave2);
        service.submitRequest("REQ003", "E001");
        service.approveRequest("REQ003", "E002"); // Level 1/2
        System.out.println("Status before update: " + leave2.getStatus() + " (Level: " + leave2.getCurrentLevel() + ")");
        
        leave2.setToDate(LocalDate.now().plusDays(8)); // Modify content
        service.updateRequest("E001", leave2);
        System.out.println("Status after update: " + leave2.getStatus() + " (Level: " + leave2.getCurrentLevel() + ")");

        System.out.println("\n--- Scenario 4: Concurrent Approval Simulation ---");
        OTRequest ot2 = new OTRequest("REQ004", "E001", 2, 5.0, "System upgrade");
        service.createRequest(ot2);
        service.submitRequest("REQ004", "E001");
        service.approveRequest("REQ004", "E002"); // Level 1/2

        // Simulate 2 admins approving at once
        Thread t1 = new Thread(() -> {
            try { service.approveRequest("REQ004", "E003"); } catch (Exception e) { System.out.println("T1: " + e.getMessage()); }
        });
        Thread t2 = new Thread(() -> {
            try { service.approveRequest("REQ004", "E003"); } catch (Exception e) { System.out.println("T2: " + e.getMessage()); }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final status: " + ot2.getStatus() + " (Level: " + ot2.getCurrentLevel() + ")");

        System.out.println("\n--- Audit Trail for REQ001 ---");
        leave.getHistory().forEach(System.out::println);
    }
}
