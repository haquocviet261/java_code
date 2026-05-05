package com.demo.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates Character Streams (FileReader, FileWriter) for reading and writing text.
 */
public class CharacterStreamDemo {
    public static void main(String[] args) {
        String filename = "char_demo.txt";

        // 1. Writing to a file using FileWriter
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Hello, Character Streams!\n");
            writer.write("chào anh phong");
            System.out.println("Successfully wrote to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Reading from a file using FileReader
        try (FileReader reader = new FileReader(filename)) {
            int data;
            System.out.println("Reading from " + filename + ":");
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
