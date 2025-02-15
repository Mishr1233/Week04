package org.example.regex.validate_username;
import java.util.regex.*;

public class ValidateUserName {
    public static void main(String[] args) {
        //Test cases
        String[] usernames = {"user_123", "123user", "us", "valid_user123", "TooLongUsername12345"};

        //Regex for validation
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);

        for (String username : usernames) {
            Matcher matcher = pattern.matcher(username);

            if (matcher.matches()) {
                System.out.println(username + " → Valid");
            } else {
                System.out.println(username + " → Invalid");
            }
        }
    }
}
