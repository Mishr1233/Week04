package org.example.regex.validate_hexcolorcode;

import java.util.regex.*;

public class ValidateHexColorCode {
    public static void main(String[] args) {
        String[] hexColors = {"#FFA500", "#ff4500", "#123", "#FF5733", "#abc123", "#1234567"};

        //# followed by exactly 6 hexadecimal characters
        String regex = "^#[0-9A-Fa-f]{6}$";
        Pattern pattern = Pattern.compile(regex);

        for (String color : hexColors) {
            Matcher matcher = pattern.matcher(color);

            //Check if the hex color code matches the pattern
            if (matcher.matches()) {
                System.out.println(color + " → Valid");
            } else {
                System.out.println(color + " → Invalid");
            }
        }
    }
}
