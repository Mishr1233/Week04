package org.example.reflection.advance;
import java.lang.reflect.Field;

public class JsonRepresentation  {

    //Method to convert an object to a JSON-like string using Reflection
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder jsonBuilder = new StringBuilder();

        //Start the JSON object
        jsonBuilder.append("{");

        //Get the class of the object
        Class<?> objClass = obj.getClass();

        //Get all fields of the class
        Field[] fields = objClass.getDeclaredFields();

        //Iterate over each field
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            //make private fields accessible
            field.setAccessible(true);

            //Get the name of the field
            String fieldName = field.getName();

            // get the value of the field for the given object
            Object value = field.get(obj);

            //Append the field name and value to the JSON string
            jsonBuilder.append("\"").append(fieldName).append("\": ");

            //If the value is a String, surround it with quotes
            if (value instanceof String) {
                jsonBuilder.append("\"").append(value).append("\"");
            } else {
                jsonBuilder.append(value);
            }

            if (i < fields.length - 1) {
                jsonBuilder.append(", ");
            }
        }

        //End the JSON object
        jsonBuilder.append("}");

        //Return the JSON-like string
        return jsonBuilder.toString();
    }

    public static void main(String[] args) {
        //Create a test object
        Person1 person = new Person1("John Doe", 30);

        try {
            //Convert the object to a JSON-like string and print the result
            String json = toJson(person);
            System.out.println(json);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Person1 {
    private String name;
    private int age;

    //Constructor
    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
