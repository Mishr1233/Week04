package org.example.readuser_input;

import java.io.*;

public class ReadUserInput {
    public static void main(String[] args) {
        //Create a BufferedReader for reading input
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            //user input
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            //Prepare data to write to file
            String data = "Name: " + name + "\nAge: " + age + "\nFavorite Programming Language: " + language;

            //Write the data into a file using FileWriter
            try (FileWriter fw = new FileWriter("user_info.txt")) {
                fw.write(data);
                System.out.println("Data successfully written to user_info.txt");
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}
