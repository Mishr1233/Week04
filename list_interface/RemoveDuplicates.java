package org.example.list_interface;

import java.util.*;

public class RemoveDuplicates {

    // Remove duplicates while preserving the order
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (Integer num : list) {
            seen.add(num);
        }
        return new ArrayList<>(seen);
    }

    public static void main(String[] args) {

        List<Integer> inputList = Arrays.asList(3, 1, 2, 2, 3, 4);

        // Remove duplicates
        List<Integer> resultList = removeDuplicates(inputList);

        // Print the result
        System.out.println(resultList);
    }
}
