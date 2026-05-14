package com.demo.student.model;

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private int age;
    private double gpa;
    private boolean gender;

    public Student() {

    }

    public Student(String id, String name, int age, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    // Validation logic (Requirement 1.6)
    public boolean isValid() {
        return id != null && !id.trim().isEmpty() &&
               age > 0 &&
               gpa >= 0.0 && gpa <= 4.0;
    }

    // Requirement 3.4 - Classification
    public String getRank() {
        if (gpa >= 3.6) return "Excellent";
        if (gpa >= 3.2) return "Good";
        if (gpa >= 2.5) return "Average";
        return "Weak";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', age=%d, gpa=%.1f, rank='%s'}", 
                id, name, age, gpa, getRank());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
