package org.example.count_word;


import java.io.*;
import java.util.*;
import java.util.regex.*;

public class CountWord {

    public static void main(String[] args) {
        String filePath = "input.txt";  //Path to the input file

        //HashMap to store the word counts
        Map<String, Integer> wordCount = new HashMap<>();

        //Regular expression to match words
        String regex = "[a-zA-Z]+";

        //Use a pattern to match words
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                //Match words in the line
                Matcher matcher = pattern.matcher(line);

                //for each matched word, update the count in the HashMap
                while (matcher.find()) {
                    String word = matcher.group().toLowerCase();
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            //Sort the words by frequency
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
            sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            //Display the top 5 most frequent words
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
