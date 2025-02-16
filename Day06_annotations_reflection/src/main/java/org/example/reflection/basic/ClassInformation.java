package org.example.reflection.basic;

import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInformation  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the class name (e.g., java.util.ArrayList): ");
        String className = scanner.nextLine();

        try {
            //Load the class using reflection
            Class<?> cls = Class.forName(className);

            //Display the class name
            System.out.println("\nClass: " + cls.getName());

            //Display the fields of the class
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println("  " + field.getModifiers() + " " + field.getType().getName() + " " + field.getName());
            }

            //Display the constructors of the class
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.print("  " + constructor.getModifiers() + " " + constructor.getName() + "(");
                Parameter[] parameters = constructor.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                    if (i < parameters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }

            //Display the methods of the class
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.print("  " + method.getModifiers() + " " + method.getReturnType().getName() + " " + method.getName() + "(");
                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getType().getName() + " " + parameters[i].getName());
                    if (i < parameters.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
