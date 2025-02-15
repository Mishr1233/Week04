package org.example.regex.validate_programingname;

import java.util.regex.*;
import java.util.*;

public class ValidateProgramingName{
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        //Regex pattern to match common programming languages
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";

        //Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //Matcher to find matches in the input text
        Matcher matcher = pattern.matcher(text);

        List<String> programmingLanguages = new ArrayList<>();

        //Extract all programming language names
        while (matcher.find()) {
            programmingLanguages.add(matcher.group());
        }

        //Print the extracted programming language names
        System.out.println(String.join(", ", programmingLanguages));
    }
}
