package org.example.reflection.intermediate;

import java.lang.reflect.Field;

class Configuration {
    //Private static field
    private static String API_KEY = "Initial_API_KEY";

    public static String getAPIKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) {
        try {
            Class<?> configClass = Configuration.class;

            //Access the private static field API_KEY
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            //Set the field accessible (it is private, so we need to make it accessible)
            apiKeyField.setAccessible(true);

            //Modify the value of the static field
            apiKeyField.set(null, "Modified_API_KEY");

            //Print the modified value using the static method
            System.out.println("Modified API_KEY: " + Configuration.getAPIKey());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
