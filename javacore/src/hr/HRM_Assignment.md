# HRM System Architecture Assignment

## 1. Problem Description
The goal was to redesign a legacy HR package using modern Java architectural standards. The system handles employee Leave and Overtime requests with a robust, type-safe, and role-secured workflow.

## 2. Requirements
- Standardized lifecycle for all requests (Submit -> Review -> Result).
- Deep separation between logic (Service) and data (Model).
- Secure approval mechanism based on employee roles.

## 3. Technical Constraints
- **Generic Abstract Base**: `Request<T>` allows for unlimited extensibility. Adding a new request type (e.g., `EquipmentRequest`) only requires a new detail class.
- **Interface-Driven Design**: 
    - Behaviors are decoupled via `Approvable`, `Submittable`, and `Viewable`.
    - Business logic follows the **Service Interface Pattern** (`RequestService` + `RequestServiceImpl`).
- **Enum Domain Integrity**: Magic strings are replaced with Enums for roles, types, and statuses.

## 4. Example Output
```text
--- PHASE 1: SUBMISSION ---
>>> System: Request 8a2b1c3d submitted.
>>> System: Request f4e5d6c7 submitted.

--- PHASE 2: MANAGER VIEW (BEFORE) ---
LeaveRequest [ID: 8a2b1c3d, EmpID: E-01, Status: PENDING, Detail: 5 days off (Reason: Summer Vacation)]
OTRequest [ID: f4e5d6c7, EmpID: E-02, Status: PENDING, Detail: 8.0 hours OT (Project: System Migration)]

--- PHASE 3: PROCESSING ---
>>> System: Request 8a2b1c3d APPROVED by Alex Director
>>> System: Request f4e5d6c7 REJECTED by Alex Director
```

## 5. Bonus Features
- [x] **IN_PROGRESS State**: Integrated into `RequestStatus` and the `Approvable` interface.
- [ ] **Department-based approval**: Can be implemented in `RequestServiceImpl` by adding a department check during validation.
- [ ] **Multi-level approval**: Can be implemented by tracking an approval stage integer inside the `Request` class.
