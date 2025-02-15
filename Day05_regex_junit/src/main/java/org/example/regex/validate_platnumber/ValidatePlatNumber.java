package org.example.regex.validate_platnumber;

import java.util.regex.*;

public class ValidatePlatNumber{
    public static void main(String[] args) {
        // Test cases
        String[] licensePlates = {"AB1234", "A12345", "XY9876", "1234AB", "ZZ0000"};

        //Two uppercase letters followed by four digits
        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        for (String plate : licensePlates) {
            Matcher matcher = pattern.matcher(plate);

            //Check if the license plate matches the pattern
            if (matcher.matches()) {
                System.out.println(plate + " → Valid");
            } else {
                System.out.println(plate + " → Invalid");
            }
        }
    }
}
