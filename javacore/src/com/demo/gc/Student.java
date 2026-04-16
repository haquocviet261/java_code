package com.demo.gc;

class Student {
    private String name;
     int age;
    private String className;
    private static int diem;
    private boolean gender;

    public Student() {

    }

    public Student(String name, int age, String className, int diem) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.diem = diem;
    }

    public Student(int age, String name , String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public Student(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
        System.out.println(">>> Đã tạo đối tượng Student: " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public  int getDiem() {
        return diem;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("--- Garbage Collector đang thu hồi: " + this.name);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", diem='" + diem + '\'' +
                ", gender=" + gender +
                '}';
    }
}
