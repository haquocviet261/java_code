package hr.model;

public class LeaveDetail {
    private final int days;
    private final String reason;

    public LeaveDetail(int days, String reason) {
        this.days = days;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return days + " days off (Reason: " + reason + ")";
    }
}
