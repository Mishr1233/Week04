package org.example.regex.censor_badwords;


import java.util.regex.*;
import java.util.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";

        //List of bad words
        List<String> badWords = Arrays.asList("damn", "stupid");

        String regex = String.join("|", badWords);

        //Replace bad words with ****
        String modifiedText = text.replaceAll("(?i)\\b(" + regex + ")\\b", "****");

        //Print the modified text
        System.out.println(modifiedText);
    }
}
