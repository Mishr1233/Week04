package org.example.junit.advance_testing;

public class PasswordValidator {

    //Method to validate the password
    public boolean isValid(String password) {
        if (password == null) {
            return false;
        }

        //Check if password has at least 8 characters, one uppercase letter, and one digit
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*");
    }
}
