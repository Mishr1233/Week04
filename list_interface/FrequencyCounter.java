package org.example.list_interface;

import java.util.*;

public class FrequencyCounter {

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();


        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        // input list
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");

        // Get the frequency map
        Map<String, Integer> frequency = countFrequency(inputList);


        System.out.println(frequency);
    }
}

