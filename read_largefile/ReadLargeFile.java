package org.example.read_largefile;

import java.io.*;
        import java.nio.file.*;
        import java.util.regex.*;

public class ReadLargeFile  {
    public static void main(String[] args) {
        String filePath = "fivehundredmbfile.txt";

        //regular expression for caseinsensitive search of "error"
        String regex = "(?i).*error.*";

        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                //Check if the line matches the pattern
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

