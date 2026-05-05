package com.demo.hr.repository;

import com.demo.hr.model.Employee;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeRepository {
    private Map<String, Employee> employees = new ConcurrentHashMap<>();

    public void save(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public Employee findById(String id) {
        return employees.get(id);
    }

    public Collection<Employee> findAll() {
        return employees.values();
    }
}
