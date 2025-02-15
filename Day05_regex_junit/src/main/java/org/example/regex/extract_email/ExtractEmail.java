package org.example.regex.extract_email;


import java.util.regex.*;
import java.util.*;

public class ExtractEmail{
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for more info.";

        //Regex for matching email addresses
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> emailAddresses = new ArrayList<>();

        //Extract all email addresses
        while (matcher.find()) {
            emailAddresses.add(matcher.group());
        }

        //Print all extracted email addresses
        for (String email : emailAddresses) {
            System.out.println(email);
        }
    }
}
