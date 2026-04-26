package hr.model;

public class OTRequest extends Request<OTDetail> {
    public OTRequest(String employeeId, OTDetail detail) {
        super(employeeId, detail);
    }
}
