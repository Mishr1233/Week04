package org.example.checked_exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {

    //Read file method and throw exception if file not found
    public static void readFile(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }

    }

    public static void main(String[] args) {
        String fileName = "data.txt";
        readFile(fileName);
    }
}
