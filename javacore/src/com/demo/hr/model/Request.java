package com.demo.hr.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Request {
    private String id;
    private String requesterId;
    private RequestStatus status;
    private int currentLevel;
    private int requiredLevel;
    private List<History> history;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Request(String id, String requesterId, int requiredLevel) {
        this.id = id;
        this.requesterId = requesterId;
        this.status = RequestStatus.DRAFT;
        this.currentLevel = 0;
        this.requiredLevel = requiredLevel;
        this.history = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        addHistory(requesterId, "CREATE", "Request initialized");
    }

    public String getId() { return id; }
    public String getRequesterId() { return requesterId; }
    public RequestStatus getStatus() { return status; }
    public void setStatus(RequestStatus status) { this.status = status; }
    public int getCurrentLevel() { return currentLevel; }
    public void incrementLevel() { this.currentLevel++; }
    public void resetLevel() { this.currentLevel = 0; }
    public int getRequiredLevel() { return requiredLevel; }
    public List<History> getHistory() { return history; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public void addHistory(String actorId, String action, String note) {
        this.history.add(new History(actorId, action, note));
        this.updatedAt = LocalDateTime.now();
    }

    public abstract void validate() throws Exception;

    @Override
    public String toString() {
        return "Request{id='" + id + "', requester='" + requesterId + "', status=" + status + ", level=" + currentLevel + "/" + requiredLevel + "}";
    }
}
