package org.example.junit.basic_junit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileProcessor {

    //Method to write content to a file
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    //Method to read content from a file
    public String readFromFile(String filename) throws IOException {
        Path filePath = Paths.get(filename);
        if (!Files.exists(filePath)) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        return new String(Files.readAllBytes(filePath));
    }
}
