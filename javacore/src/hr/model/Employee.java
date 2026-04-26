package hr.model;

import hr.enums.Role;

public class Employee {
    private final String id;
    private final String name;
    private final Role role;

    public Employee(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Role getRole() { return role; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s)", id, name, role);
    }
}
