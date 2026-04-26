package hr.model;

import hr.enums.RequestStatus;
import hr.interfaces.*;
import java.util.UUID;

public abstract class Request<T> implements Approvable, Submittable, Viewable {
    private final String id;
    private final String employeeId;
    private final T detail;
    private RequestStatus status;

    public Request(String employeeId, T detail) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.employeeId = employeeId;
        this.detail = detail;
        this.status = RequestStatus.PENDING;
    }

    @Override public void submit() { this.status = RequestStatus.PENDING; }
    @Override public void approve() { this.status = RequestStatus.APPROVED; }
    @Override public void reject() { this.status = RequestStatus.REJECTED; }
    @Override public void startProcessing() { this.status = RequestStatus.IN_PROGRESS; }

    @Override public RequestStatus getStatus() { return status; }
    @Override public String getEmployeeId() { return employeeId; }

    public String getId() { return id; }
    public T getDetail() { return detail; }

    @Override
    public String toString() {
        return String.format("[%s] ID: %s | Status: %s | Detail: %s", 
                getClass().getSimpleName(), id, status, detail);
    }
}
