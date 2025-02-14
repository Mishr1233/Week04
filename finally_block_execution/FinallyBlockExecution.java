package org.example.finally_block_execution;

import java.util.Scanner;

public class FinallyBlockExecution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //Take two integers as input from the user
            System.out.print("Enter the first number (dividend): ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number (divisor): ");
            int num2 = scanner.nextInt();

            //Perform the division and print the result
            int result = num1 / num2;
            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");

        } finally {
            //The finally block is always executed
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
