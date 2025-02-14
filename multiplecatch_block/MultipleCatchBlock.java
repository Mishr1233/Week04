package org.example.multiplecatch_block;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchBlock {

    //Method to retrieve value at the specified index
    public static void getValueAtIndex(int[] arr, int index) {
        try {

            if (arr == null) {
                throw new NullPointerException();
            }

            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            //handle invalid index
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            //Handle null array
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try{
            //Accept array size input from the user
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            if (size < 0) {
                throw new NegativeArraySizeException();
            }
            int[] array = new int[size];

            //Accept elements for the array
            System.out.println("Enter " + size + " elements for the array:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }

            //Accept index to retrieve value from the user
            System.out.print("Enter an index to retrieve value: ");
            int index = scanner.nextInt();

            getValueAtIndex(array, index);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid integer.");
        } catch (NegativeArraySizeException e) {
            System.out.println("Array size cannot be negative!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }
}
