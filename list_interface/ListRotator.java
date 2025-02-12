package org.example.list_interface;

import java.util.*;

public class ListRotator {

    // Rotate list by the given number of positions
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        if (list == null || list.size() <= 1 || positions == 0) {
            return list;
        }

        // Ensure the positions are within the list's size
        int n = list.size();
        positions = positions % n;

        // Split the list and concatenate
        List<Integer> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(positions, n));
        rotatedList.addAll(list.subList(0, positions));

        return rotatedList;
    }

    public static void main(String[] args) {
        // Sample input
        List<Integer> inputList = Arrays.asList(10, 20, 30, 40, 50);

        // Rotate by 2 positions
        List<Integer> rotatedList = rotateList(inputList, 2);

        // Print the result
        System.out.println(rotatedList);
    }
}
