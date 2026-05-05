package com.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Demonstrates Buffered Streams (BufferedReader, BufferedWriter) for efficient text IO.
 */
public class BufferedStreamDemo {
    public static void main(String[] args) {
        String filename = "buffered_demo.txt";

        // 1. Writing to a file using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Line 1: Buffered writing is efficient.");
            writer.newLine();
            writer.write("Line 2: It reduces the number of I/O operations.");
            System.out.println("Successfully wrote to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Reading from a file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Reading from " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
