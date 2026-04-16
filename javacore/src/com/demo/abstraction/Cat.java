package com.demo.abstraction;

public class Cat extends Animal implements Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow Meow!");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing with a yarn ball.");
    }
}
