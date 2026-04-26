package hr.interfaces;

import hr.enums.RequestStatus;

public interface Viewable {
    RequestStatus getStatus();
    String getEmployeeId();
}
