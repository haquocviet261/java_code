package com.demo.gc;

import com.demo.common.DateFormatter;

public class GarbageCollectionDemo {
    static {
        float PI = 3.14f;
    }

    public static void main(String[] args) {
        // Tạo đối tượng và gán null
        Student phuong = new Student("Phuong", 21, "10a1", 10);
        Student phi = new Student("Phuong", 21, "10a1", 8);
        Date currentdate;
        currentdate.format(DateFormatter.FORMAT_DD_MM_YYYY);

        System.out.println(phuong.toString());

        // Tạo đối tượng ẩn danh qua hàm
        createAnonymousStudent();

        System.out.println("Yêu cầu JVM chạy Garbage Collector...");
        System.gc(); 

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Kết thúc chương trình demo GC.");
    }

    public static void sum(int a) {

    }

    public static void sum() {
        System.out.println("0 tham so");
    }

    public static int sum(int a, int b) {
        return 0;
    }

    public static int sum(float a, int b) {
        return 0;
    }

    private static void createAnonymousStudent() {
        Student s2 = new Student("Tran Thi B");
    }
}
