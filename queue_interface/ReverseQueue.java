package org.example.queue_interface;

import java.util.*;

public class ReverseQueue {

    // Method to reverse a queue using recursion
    public static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element and store it temporarily
        int frontElement = queue.remove();

        // Recurse with the remaining queue
        reverseQueue(queue);

        // Add the front element back at the end of the queue
        queue.add(frontElement);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Print the original queue
        System.out.println("Original Queue: " + queue);

        // Reverse the queue
        reverseQueue(queue);

        // Print the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}
