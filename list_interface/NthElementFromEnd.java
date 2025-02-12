package org.example.list_interface;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthElementFromEnd {

    // Method to find the Nth element from the end of the list
    public static String findNthFromEnd(LinkedList<String> list, int N) {
        ListIterator<String> slow = list.listIterator();
        ListIterator<String> fast = list.listIterator();

        //Move the fast pointer N steps ahead
        int count = 0;
        while (count < N && fast.hasNext()) {
            fast.next();
            count++;
        }

        // it means N is greater than the list size
        if (count < N) {
            return "N is greater than the list size.";
        }

        // Move both pointers together one step at a time
        while (fast.hasNext()) {
            slow.next();
            fast.next();
        }


        return slow.next();
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //Find the 2nd element from the end of the list
        String result = findNthFromEnd(list, 2);

        // Output the result
        System.out.println(result);
    }
}
