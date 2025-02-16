package org.example.annotation.intermediate_level;

import java.lang.annotation.*;

//Define the custom annotation @MaxLength
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)          //Apply it to fields only
@interface MaxLength {
    int value();  //the maximum length value for the field
}

//Define the User class with a field annotated with @MaxLength
class User {

    //Apply the @MaxLength annotation to the username field
    @MaxLength(value = 10)
    private String username;

    //Constructor that validates the username length based on the @MaxLength annotation
    public User(String username) {
        //Validate the length of the username using Reflection to read the annotation
        try {
            var field = User.class.getDeclaredField("username");
            //Check if the field is annotated with @MaxLength
            if (field.isAnnotationPresent(MaxLength.class)) {
                //Retrieve the annotation
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                int maxLengthValue = maxLength.value();

                //Check if the provided username exceeds the maximum length
                if (username.length() > maxLengthValue) {
                    throw new IllegalArgumentException("Username length exceeds the maximum allowed length of " + maxLengthValue);
                }
            }
            //Set the validated username
            this.username = username;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class FieldValidation {

    public static void main(String[] args) {
        try {
            //Valid username
            User user1 = new User("Alice123");
            System.out.println("User 1: " + user1.getUsername());

            //Invalid username (exceeds the limit of 10 characters)
            User user2 = new User("VeryLongUsername");
            System.out.println("User 2: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
