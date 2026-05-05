package com.demo.hr.model;

import com.demo.hr.exception.ValidationException;

public class OTRequest extends Request {
    private double hours;
    private String reason;

    public OTRequest(String id, String requesterId, int requiredLevel, double hours, String reason) {
        super(id, requesterId, requiredLevel);
        this.hours = hours;
        this.reason = reason;
    }

    public double getHours() { return hours; }
    public void setHours(double hours) { this.hours = hours; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    @Override
    public void validate() throws ValidationException {
        if (hours <= 0) {
            throw new ValidationException("OT hours must be positive");
        }
        if (hours > 12) {
            throw new ValidationException("OT hours cannot exceed 12 hours per day");
        }
    }
}
