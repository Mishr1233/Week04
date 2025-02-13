package org.example.file_handling;

import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        //Input file
        String sourceFile = "input.txt";

        //output file
        String destinationFile = "output.txt";

        //Input output streams
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
          //print message
            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
