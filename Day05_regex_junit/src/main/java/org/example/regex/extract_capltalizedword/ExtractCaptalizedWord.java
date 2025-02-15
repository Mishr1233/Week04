package org.example.regex.extract_capltalizedword;

import java.util.regex.*;
import java.util.*;

public class ExtractCaptalizedWord{
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        //Regex for matching capitalized words
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //List to store found capitalized words
        List<String> capitalizedWords = new ArrayList<>();

        //Extract all capitalized words
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        for (String word : capitalizedWords) {
            System.out.println(word + " ");
        }
    }
}
