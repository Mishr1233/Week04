package org.example.map_interface;

import java.util.*;

public class MacxValueKeyFinder {

    // Method to find the key with the maximum value in the map
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map to find the key with the maximum value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        // Example map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        // Find the key with the maximum value
        String maxKey = findKeyWithMaxValue(inputMap);

        // Print the result
        System.out.println("Key with the highest value: " + maxKey);
    }
}
