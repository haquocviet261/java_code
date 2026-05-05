package com.demo.hr.model;

import com.demo.hr.exception.ValidationException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LeaveRequest extends Request {
    private LocalDate fromDate;
    private LocalDate toDate;
    private String reason;

    public LeaveRequest(String id, String requesterId, int requiredLevel, LocalDate fromDate, LocalDate toDate, String reason) {
        super(id, requesterId, requiredLevel);
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reason = reason;
    }

    public LocalDate getFromDate() { return fromDate; }
    public void setFromDate(LocalDate fromDate) { this.fromDate = fromDate; }
    public LocalDate getToDate() { return toDate; }
    public void setToDate(LocalDate toDate) { this.toDate = toDate; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    @Override
    public void validate() throws ValidationException {
        if (fromDate.isAfter(toDate)) {
            throw new ValidationException("FromDate cannot be after ToDate");
        }
        long days = ChronoUnit.DAYS.between(fromDate, toDate) + 1;
        if (days > 30) {
            throw new ValidationException("Leave period cannot exceed 30 days");
        }
    }
}
