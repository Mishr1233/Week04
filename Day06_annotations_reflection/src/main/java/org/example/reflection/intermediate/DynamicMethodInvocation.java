package org.example.reflection.intermediate;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    //Add method
    public int add(int a, int b) {
        return a + b;
    }

    //Subtract method
    public int subtract(int a, int b) {
        return a - b;
    }

    //Multiply method
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        try {
            //Create an instance of MathOperations
            MathOperations mathOps = new MathOperations();

            //Get the MathOperations class using reflection
            Class<?> mathClass = mathOps.getClass();

            Scanner scanner = new Scanner(System.in);

            //Ask the user which method they want to invoke
            System.out.println("Choose an operation: add, subtract, multiply");
            String operation = scanner.nextLine();

            //Get the method based on user input
            Method method = mathClass.getMethod(operation, int.class, int.class);

            //taking the two numbers for the operation
            System.out.println("Enter first number:");
            int num1 = scanner.nextInt();
            System.out.println("Enter second number:");
            int num2 = scanner.nextInt();

            //Invoke the method dynamically and display the result
            Object result = method.invoke(mathOps, num1, num2);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            //Handle any exceptions that occur
            e.printStackTrace();
        }
    }
}
