package hr.service.impl;

import hr.enums.Role;
import hr.model.Employee;
import hr.model.Request;
import hr.service.RequestService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RequestServiceImpl implements RequestService {
    private final List<Request<?>> requests = new ArrayList<>();

    @Override
    public void submit(Request<?> request) {
        request.submit();
        requests.add(request);
        System.out.println(">>> System: Request " + request.getId() + " submitted.");
    }

    @Override
    public List<Request<?>> getMyRequests(String employeeId) {
        return requests.stream()
                .filter(r -> r.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Request<?>> getAllRequests(Employee manager) {
        validateManager(manager);
        return new ArrayList<>(requests);
    }

    @Override
    public void approve(Employee manager, String requestId) {
        validateManager(manager);
        findRequest(requestId).approve();
        System.out.println(">>> System: Request " + requestId + " APPROVED by " + manager.getName());
    }

    @Override
    public void reject(Employee manager, String requestId) {
        validateManager(manager);
        findRequest(requestId).reject();
        System.out.println(">>> System: Request " + requestId + " REJECTED by " + manager.getName());
    }

    private void validateManager(Employee manager) {
        if (manager.getRole() != Role.MANAGER) {
            throw new RuntimeException("ACCESS DENIED: Role MANAGER required for this operation. Violator: " + manager.getName());
        }
    }

    private Request<?> findRequest(String id) {
        return requests.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error: Request not found ID " + id));
    }
}
