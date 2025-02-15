package org.example.junit.basic_junit;


import java.util.List;

public class ListManager {

    //Method to add an element to a list
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    //Method to remove an element from a list
    public static boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element));
    }

    //Method to get the size of a list
    public static int getSize(List<Integer> list) {
        return list.size();
    }
}
