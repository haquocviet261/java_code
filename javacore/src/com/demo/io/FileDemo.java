package com.demo.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Demonstrates basic file and directory operations using java.io.File.
 */
public class FileDemo {
    public static void main(String[] args) {
        // 1. Create a File object (doesn't create the file on disk yet)
        File file = new File("demo.txt");

        try {
            // 2. Create a new file
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // 3. File metadata
            System.out.println("Absolute path: " + file.getAbsolutePath());
            System.out.println("Writeable: " + file.canWrite());
            System.out.println("Readable: " + file.canRead());
            System.out.println("File size in bytes: " + file.length());

            // 4. Directory operations
            File dir = new File("test_dir");
            if (dir.mkdir()) {
                System.out.println("Directory created: " + dir.getName());
            }

            // List files in current directory
            File currentDir = new File(".");
            String[] files = currentDir.list();
            System.out.println("Files in current directory: " + Arrays.toString(files));

            // 5. Cleanup (optional)
            // file.delete();
            // dir.delete();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
