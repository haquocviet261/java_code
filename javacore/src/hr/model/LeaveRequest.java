package hr.model;

public class LeaveRequest extends Request<LeaveDetail> {
    public LeaveRequest(String employeeId, LeaveDetail detail) {
        super(employeeId, detail);
    }
}
