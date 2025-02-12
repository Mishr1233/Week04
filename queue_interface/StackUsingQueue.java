package org.example.queue_interface;

import java.util.*;

public class StackUsingQueue {

    // Declare two queues to simulate the stack
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor to initialize the two queues
    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    //Add an element to the stack
    public void push(int x) {
        queue1.add(x);
    }


    public int pop() {
        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element in queue1 is the top element in stack (LIFO)
        int topElement = queue1.poll();

        // Swap the queues: queue1 becomes the new queue for future operations
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Top operation: Get the top element without removing it
    public int top() {
        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }

        // The last element in queue1 is the top element in stack
        int topElement = queue1.peek();

        // Move the last element to queue2 to maintain the queue order
        queue2.add(queue1.poll());

        // Swap the queues: queue1 becomes the new queue for future operations
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Pop the top element and print it
        System.out.println("Pop: " + stack.pop());

        // View the current top element
        System.out.println("Top: " + stack.top());

        // Pop again and print it
        System.out.println("Pop: " + stack.pop());
    }
}
