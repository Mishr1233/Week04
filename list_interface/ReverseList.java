package org.example.list_interface;

import java.util.*;

public class ReverseList {

    // Method to reverse an ArrayList
    public static <T> List<T> reverseArrayList(List<T> list) {
        List<T> reversedList = new ArrayList<>();


        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }

        return reversedList;
    }

    // Method to reverse a LinkedList
    public static <T> List<T> reverseLinkedList(List<T> list) {
        List<T> reversedList = new LinkedList<>();


        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }

        return reversedList;
    }

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Reversing the ArrayList
        List<Integer> reversedArrayList = reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        // Reversing the LinkedList
        List<Integer> reversedLinkedList = reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}
