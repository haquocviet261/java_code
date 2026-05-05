package com.demo.hr.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Employee {
    private String id;
    private String name;
    private String departmentId;
    private Set<Role> roles;

    public Employee(String id, String name, String departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.roles = new HashSet<>();
        this.roles.add(Role.EMPLOYEE);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartmentId() { return departmentId; }
    public Set<Role> getRoles() { return roles; }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', dept='" + departmentId + "', roles=" + roles + "}";
    }
}
