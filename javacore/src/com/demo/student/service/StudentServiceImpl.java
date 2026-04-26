package com.demo.student.service;

import com.demo.student.model.Student;
import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    // Requirement 3.1 - Refactor: List -> Map
    private Map<String, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        if (!student.isValid()) {
            System.out.println("Error: Invalid student data.");
            return;
        }
        if (studentMap.containsKey(student.getId())) {
            System.out.println("Error: Student ID " + student.getId() + " already exists.");
            return;
        }
        studentMap.put(student.getId(), student);
        System.out.println("Student added successfully.");
    }

    @Override
    public Student findById(String id) {
        return studentMap.get(id);
    }

    @Override
    public void displayAll() {
        if (studentMap.isEmpty()) {
            System.out.println("The student list is empty.");
            return;
        }
        studentMap.values().forEach(System.out::println);
    }

    @Override
    public void deleteById(String id) {
        if (studentMap.remove(id) != null) {
            System.out.println("Student with ID " + id + " deleted.");
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    @Override
    public void sortByGpa() {
        // Sort descending by GPA
        List<Student> sortedList = studentMap.values().stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .collect(Collectors.toList());
        
        System.out.println("Students sorted by GPA (Descending):");
        sortedList.forEach(System.out::println);
    }

    @Override
    public List<Student> searchByName(String keyword) {
        return studentMap.values().stream()
                .filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public void showStatistics() {
        if (studentMap.isEmpty()) return;

        double avgGpa = studentMap.values().stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        Student topStudent = studentMap.values().stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);

        System.out.println("\n--- Statistics ---");
        System.out.printf("Average GPA: %.2f%n", avgGpa);
        if (topStudent != null) {
            System.out.println("Top Student: " + topStudent.getName() + " (GPA: " + topStudent.getGpa() + ")");
        }
    }
}
