package org.example.regex.validate_socialsecurity_number;
import java.util.regex.*;

public class ValidateSocialSecurityNumber  {
    public static void main(String[] args) {
        String[] ssns = {
                "123-45-6789",
                "123456789",
                "123-456-789",
                "987-65-4321"
        };

        //Regex pattern for SSN format
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        //Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        //Check each SSN
        for (String ssn : ssns) {
            Matcher matcher = pattern.matcher(ssn);
            if (matcher.matches()) {
                System.out.println("\"" + ssn + "\" is valid.");
            } else {
                System.out.println("\"" + ssn + "\" is invalid.");
            }
        }
    }
}
