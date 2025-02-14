package org.example.try_with_resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {
        //Try-with-resources to ensure automatic closing of resources
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {

            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }
        } catch (IOException e) {
            //handle IOException and print error message
            System.out.println("Error reading file");
        }
    }
}
