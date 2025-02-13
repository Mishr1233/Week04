package org.example.filterstreams;

import java.io.*;

public class FilterStreams {
    public static void main(String[] args) {
        //Specify the paths for the input and output files
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        //BufferedReader and BufferedWriter to read and write files
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            //read each line from the input file
            while ((line = reader.readLine()) != null) {

                String lowercaseLine = line.toLowerCase();

                //Write the lowercase line to the output file
                writer.write(lowercaseLine);
                writer.newLine();
            }

            System.out.println("File contents converted to lowercase and saved to " + outputFile);

        } catch (IOException e) {
            System.out.println("Error reading or writing files: " + e.getMessage());
        }
    }
}
