package org.example.map_interface;

import java.util.*;

public class MapInverter {

    // Method to invert a Map<K, V> to Map<V, List<K>>
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Traverse the original map and invert it
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }

    // Main method to test the Map inverter
    public static void main(String[] args) {
        // Input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);

        // Print the inverted map
        System.out.println(invertedMap);
    }
}

