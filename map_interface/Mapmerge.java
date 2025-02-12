package org.example.map_interface;

import java.util.*;

public class Mapmerge{

    // Method to merge two maps with sum of values for common keys
    public static <K, V extends Number> Map<K, V> mergeMaps(Map<K, V> map1, Map<K, V> map2) {

        Map<K, V> mergedMap = new HashMap<>(map1);

        // Iterate through the second map and merge
        for (Map.Entry<K, V> entry : map2.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();

            // If the key already exists in the first map, add the values
            if (mergedMap.containsKey(key)) {

                mergedMap.put(key, (V) Integer.valueOf(mergedMap.get(key).intValue() + value.intValue()));
            } else {

                mergedMap.put(key, value);
            }
        }

        return mergedMap;
    }

    public static void main(String[] args) {
        // Example maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Print the merged map
        System.out.println("Merged Map: " + mergedMap);
    }
}
