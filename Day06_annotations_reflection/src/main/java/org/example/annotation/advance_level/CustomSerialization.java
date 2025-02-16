package org.example.annotation.advance_level;

import java.lang.annotation.*;
import java.lang.reflect.*;

//Define the custom annotation @JsonField
@Retention(RetentionPolicy.RUNTIME)  //Make it available at runtime for Reflection
@Target(ElementType.FIELD)          //Apply it to fields
@interface JsonField {
    String name();
}

//Define the User class with fields annotated with @JsonField
class User1 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    //Constructor
    public User1(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    //Getter for age
    public int getAge() {
        return age;
    }
}

public class CustomSerialization {

    //Method to convert an object to a JSON-like string based on @JsonField annotations
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        //Get all fields of the class including private ones
        Field[] fields = obj.getClass().getDeclaredFields();

        //Iterate through each field and check for @JsonField annotation
        for (Field field : fields) {

            if (field.isAnnotationPresent(JsonField.class)) {
                try {
                    //Get the @JsonField annotation and retrieve the custom name for the JSON key
                    JsonField jsonField = field.getAnnotation(JsonField.class);
                    String jsonKey = jsonField.name();

                    //Make the field accessible if it is private
                    field.setAccessible(true);

                    //Get the value of the field from the object
                    Object value = field.get(obj);

                    //Add the key-value pair to the JSON string
                    json.append("\"").append(jsonKey).append("\": \"").append(value).append("\", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        //Remove the trailing comma and space, then close the JSON string
        if (json.length() > 1) {
            json.setLength(json.length() - 2);
        }
        json.append("}");

        return json.toString();
    }

    public static void main(String[] args) {
        //Create a User object
        User1 user = new User1("JohnDoe", 25);

        //Convert the User object to a JSON-like string
        String jsonString = toJson(user);

        System.out.println(jsonString);
    }
}
