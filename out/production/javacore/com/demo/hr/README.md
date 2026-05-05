# HRM Request Management System Implementation

This is a Java Core implementation of the HRM - Request Management System based on the provided SRS.

## Architecture
The project follows **Clean Architecture** principles:
- **`model`**: Contains entities and value objects (Employee, Request, History, etc.).
- **`repository`**: In-memory data storage using `ConcurrentHashMap`.
- **`service`**: Core business logic (Approval workflow, Validation, Authorization).
- **`exception`**: Custom exceptions for domain-specific errors.

## Key Features
1.  **Multi-Level Approval**: Supports an arbitrary number of approval levels.
2.  **Role-Based Access Control**: Different permissions for Employees, Managers, and Admins.
3.  **Validation**: Specific rules for Leave (max 30 days) and OT (max 12 hours) requests.
4.  **Audit Trail**: Every action is recorded with a timestamp, actor, and note.
5.  **Thread-Safety**: Handles concurrent approval attempts safely.
6.  **State Management**: Implements the state transition table as defined in the SRS.

## How to Run the Demo
The `HRMSystemDemo.java` file contains a main method that executes the scenarios described in the SRS.

```bash
javac com/demo/hr/*.java com/demo/hr/model/*.java com/demo/hr/repository/*.java com/demo/hr/service/*.java com/demo/hr/exception/*.java
java com.demo.hr.HRMSystemDemo
```
