package org.example.regex.repeating_word;

import java.util.regex.*;
import java.util.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";

        //Regex to match words
        String regex = "\\b\\w+\\b";

        //Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sentence);

        //Map to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        //Extract words and count their occurrences
        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase to handle case sensitivity
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> repeatingWords = new ArrayList<>();

        //Find words that appear more than once
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        //Print repeating words
        System.out.println(String.join(", ", repeatingWords));
    }
}
