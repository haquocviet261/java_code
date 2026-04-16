package com.demo.abstraction;

public class Dog extends Animal implements Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing fetch.");
    }
}
