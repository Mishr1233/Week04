package org.example.reflection.basic;

import java.lang.reflect.Method;

class Calculator {
    //Private method
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();

            //Get the Calculator class
            Class<?> calculatorClass = calculator.getClass();

            //Access the private method using Reflection
            Method multiplyMethod = calculatorClass.getDeclaredMethod("multiply", int.class, int.class);

            //Set accessible to true to bypass Java access control checks
            multiplyMethod.setAccessible(true);

            //Invoke the private method with parameters 5 and 4
            Object result = multiplyMethod.invoke(calculator, 5, 4);

            //Display the result
            System.out.println("Result of multiply(5, 4): " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
