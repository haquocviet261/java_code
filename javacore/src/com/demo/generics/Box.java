package com.demo.generics;

/**
 * A simple generic class that can hold any type of object.
 * @param <T> the type of value in this box.
 */
public class Box<T> {
    private T value;

    public Box() {}

    public Box(T value) {
        this.value = value;
    }

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public String toString() {
        return "Box{value=" + (value != null ? value.toString() : "null") + "}";
    }
}
