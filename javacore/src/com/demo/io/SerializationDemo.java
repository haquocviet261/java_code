package com.demo.io;

import java.io.*;

/**
 * Demonstrates Object Serialization and Deserialization.
 */
class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String password; // transient fields are not serialized
    private String gender;

    public User(String name, String password, String gender) {
        this.name = name;
        this.password = password;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', password='" + password + "'+ gender='" + gender + "}";
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        String filename = "user.ser";
        User user = new User("Alice", "secret123", "gender");

        // 1. Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(user);
            System.out.println("Serialized object: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            User deserializedUser = (User) in.readObject();
            System.out.println("Deserialized object: " + deserializedUser);
            System.out.println("Note: password is null because it was marked transient.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
