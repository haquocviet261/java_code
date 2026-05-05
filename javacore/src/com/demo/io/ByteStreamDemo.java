package com.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Demonstrates Byte Streams (FileInputStream, FileOutputStream) for reading and writing raw bytes.
 */
public class ByteStreamDemo {
    public static void main(String[] args) {
        String filename = "byte_demo.bin";

        // 1. Writing to a file using FileOutputStream
        try (FileOutputStream out = new FileOutputStream(filename)) {
            String content = "Hello, Byte Streams!";
            byte[] bytes = content.getBytes();
            out.write(bytes);
            System.out.println("Successfully wrote to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Reading from a file using FileInputStream
        try (FileInputStream in = new FileInputStream(filename)) {
            int data;
            System.out.print("Reading from " + filename + ": ");
            while ((data = in.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
