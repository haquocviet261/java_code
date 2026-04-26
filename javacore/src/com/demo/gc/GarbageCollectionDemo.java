package com.demo.gc;

import com.demo.common.DateFormatter;

import java.util.*;

public class GarbageCollectionDemo {


    public static void main(String[] args) {
        // Tạo đối tượng và gán null
        Student phuong = new Student("Phuong", 21, "10a1", 10);
        Student phi = new Student("Phi", 21, "10a1", 8);
        Student phi1 = phi;

        Student student1 = phi;
        student1 = new Student();
        List<Student> studentList = new ArrayList<>();
        studentList.add(phuong);
        studentList.add(phi);
        studentList.add(phi);
        studentList.add(phi);
        studentList.add(phi);


        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, phuong);
        studentMap.put(2, phi);

        Student defautStudent = new Student("Viet");

        Student student = studentMap.getOrDefault(5, defautStudent);
        System.out.println(student.toString());





    }

}
