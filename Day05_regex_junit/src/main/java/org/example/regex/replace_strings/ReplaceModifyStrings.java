package org.example.regex.replace_strings;

public class ReplaceModifyStrings {
    public static void main(String[] args) {
        //Sample input text
        String text = "This   is    an  example   with   multiple   spaces.";

        //Replace multiple spaces with a single space
        String modifiedText = text.replaceAll("\\s+", " ");

        //Print the modified text
        System.out.println(modifiedText);
    }
}
