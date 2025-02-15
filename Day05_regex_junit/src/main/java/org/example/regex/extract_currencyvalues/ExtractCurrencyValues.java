package org.example.regex.extract_currencyvalues;

import java.util.regex.*;
import java.util.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        //Regex pattern to match currency values
        String regex = "\\$?\\d+(\\.\\d{2})?";

        //Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //Matcher to find matches in the input text
        Matcher matcher = pattern.matcher(text);

        //List to store the matched currency values
        List<String> currencyValues = new ArrayList<>();

        //Extract all currency values
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        //Print the extracted currency values as a comma separated list
        System.out.println(String.join(", ", currencyValues));
    }
}
