package com.demo.student.service;

import com.demo.student.model.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    Student findById(String id);
    void displayAll();
    void deleteById(String id);
    void sortByGpa();
    
    // Bonus methods
    List<Student> searchByName(String keyword);
    void showStatistics();
}
