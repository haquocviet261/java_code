package hr.model;

public class OTDetail {
    private final double hours;
    private final String project;

    public OTDetail(double hours, String project) {
        this.hours = hours;
        this.project = project;
    }

    @Override
    public String toString() {
        return hours + " hours OT (Project: " + project + ")";
    }
}
