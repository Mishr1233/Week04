package org.example.nested_try_catch;

import java.util.Scanner;
import java.util.InputMismatchException;

public class NestedTryCatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //taking the size of the array from the user
            System.out.print("Enter the number of elements in the array: ");
            int size = scanner.nextInt();

            int[] numbers = new int[size];

            //Take the elements of the array as input
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < size; i++) {
                try {
                    System.out.print("Element " + (i + 1) + ": ");
                    numbers[i] = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next();
                    i--;
                }
            }

            //Take the divisor input
            double divisor = 0;
            while (true) {
                try {
                    System.out.print("Enter the divisor: ");
                    divisor = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer for the divisor.");
                    scanner.next(); // Consume the invalid input
                }
            }

            // Take the index input for array access
            int index = -1;
            while (true) {
                try {
                    System.out.print("Enter the index of the element to divide: ");
                    index = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter an integer for the index.");
                    scanner.next(); // Consume the invalid input
                }
            }

            //Nested try-catch block to handle array access and division
            try {
                int element = numbers[index];

                //Try to divide the element by the divisor
                double result = element / divisor;
                System.out.println("Result of division: " + result);
            } catch (ArithmeticException e) {
                //Handle division by zero error
                System.out.println("Cannot divide by zero!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } catch (InputMismatchException e) {
            //Handle invalid input for array size, divisor, or index
            System.out.println("Invalid input! Please enter an integer.");
        } catch (Exception e) {
            //Catch any unforeseen exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
