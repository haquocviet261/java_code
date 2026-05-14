package com.demo.abstraction;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method: Không có thân hàm, buộc lớp con phải triển khai
    protected abstract void makeSound();

    // Concrete method: Lớp con có thể sử dụng luôn
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }

}
