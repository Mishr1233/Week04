package org.example.regex.extract_links;
import java.util.regex.*;
import java.util.*;

public class ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        //Regex for matching URLs
        String regex = "https?://[a-zA-Z0-9.-]+(?:/[a-zA-Z0-9&%$#_=-]*)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //List to store found links
        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group());
        }

        //Print all extracted links
        for (String link : links) {
            System.out.print(link + ", ");
        }
    }
}
