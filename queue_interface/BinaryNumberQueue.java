package org.example.queue_interface;

import java.util.*;

public class BinaryNumberQueue {


    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();

        // Queue to store binary numbers as strings
        Queue<String> queue = new LinkedList<>();

        // Start with the first binary number "1"
        queue.add("1");

        // Generate binary numbers
        for (int i = 0; i < N; i++) {

            String binaryNumber = queue.remove();

            result.add(binaryNumber);

            // Append "0" and "1" to the current binary number and add them back to the queue
            queue.add(binaryNumber + "0");
            queue.add(binaryNumber + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);

        // Print the generated binary numbers
        System.out.println("First " + N + " binary numbers: " + binaryNumbers);
    }
}
