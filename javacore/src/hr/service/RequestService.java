package hr.service;

import hr.model.Employee;
import hr.model.Request;
import java.util.List;

public interface RequestService {
    void submit(Request<?> request);
    List<Request<?>> getMyRequests(String employeeId);
    List<Request<?>> getAllRequests(Employee manager);
    void approve(Employee manager, String requestId);
    void reject(Employee manager, String requestId);
}
