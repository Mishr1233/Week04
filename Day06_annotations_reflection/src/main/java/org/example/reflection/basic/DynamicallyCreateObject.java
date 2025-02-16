package org.example.reflection.basic;

import java.lang.reflect.Constructor;

class Student {
    private String name;
    private int age;

    //Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Method to display student information
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
    }
}

public class DynamicallyCreateObject {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("org.example.reflection.basic.Student");

            //Get the constructor of Student class
            Constructor<?> constructor = studentClass.getDeclaredConstructor(String.class, int.class);

            //Create a new instance of Student using the constructor
            Object studentObj = constructor.newInstance("John Doe", 20);

            //Cast the created object to Student type and call the method to display info
            Student student = (Student) studentObj;
            student.displayInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
