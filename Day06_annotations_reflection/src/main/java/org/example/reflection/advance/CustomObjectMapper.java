package org.example.reflection.advance;

import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {

    //Method to map properties from Map to an object
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        //Get all fields of the class
        Field[] fields = clazz.getDeclaredFields();

        //Iterate over each field in the class
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            field.setAccessible(true);

            //Get the name of the field
            String fieldName = field.getName();

            //Check if the map contains the key matching the field name
            if (properties.containsKey(fieldName)) {

                Object value = properties.get(fieldName);

                //Ensure that the value type matches the field type
                if (field.getType().isAssignableFrom(value.getClass())) {
                    field.set(obj, value);
                } else {
                    //Handle type conversion if necessary
                    Object convertedValue = convertValue(value, field.getType());
                    if (convertedValue != null) {
                        field.set(obj, convertedValue);
                    } else {
                        throw new IllegalArgumentException("Type mismatch for field: " + fieldName);
                    }
                }
            }
        }

        return obj;
    }

    //Method to convert value to the appropriate field type
    private static Object convertValue(Object value, Class<?> fieldType) {
        if (fieldType == String.class) {
            return value.toString();  // Convert to String
        } else if (fieldType == int.class && value instanceof Number) {
            return ((Number) value).intValue();  // Convert to int
        } else if (fieldType == double.class && value instanceof Number) {
            return ((Number) value).doubleValue();  // Convert to double
        } else if (fieldType == boolean.class && value instanceof Boolean) {
            return value;  // Convert to boolean
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            //Define a Map with field names as keys and corresponding values
            Map<String, Object> properties = Map.of(
                    "name", "John Doe",
                    "age", 30
            );

            //Use the toObject method to map the properties to a new Person object
            Person person = toObject(Person.class, properties);

            //Print the result
            System.out.println(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    private int age;

    //Default constructor
    public Person() {}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Override toString for easier display
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
