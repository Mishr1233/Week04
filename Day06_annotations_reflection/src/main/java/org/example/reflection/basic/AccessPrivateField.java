package org.example.reflection.basic;

import java.lang.reflect.Field;

class Person {
    //Private field
    private int age;

    //Constructor
    public Person(int age) {
        this.age = age;
    }
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);

            //Get the Person class
            Class<?> personClass = person.getClass();

            //Access the private field "age" using Reflection
            Field ageField = personClass.getDeclaredField("age");

            //Set accessible to true
            ageField.setAccessible(true);

            //Retrieve the current value of the private field "age"
            int age = (int) ageField.get(person);
            System.out.println("Initial age: " + age);

            //Modify the value of the private field "age"
            ageField.set(person, 30);

            //Retrieve the modified value
            age = (int) ageField.get(person);
            System.out.println("Modified age: " + age);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
