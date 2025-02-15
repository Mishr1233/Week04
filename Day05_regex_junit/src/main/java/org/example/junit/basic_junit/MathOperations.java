package org.example.junit.basic_junit;

public class MathOperations {

    //Method to divide two numbers, throws ArithmeticException if b is zero
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }
}
