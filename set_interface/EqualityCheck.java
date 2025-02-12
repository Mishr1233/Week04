package org.example.set_interface;

import java.util.HashSet;
import java.util.Set;

public class EqualityCheck{

    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        // Use the equals method to compare both sets
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        // Create two sets with the same elements but different orders
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);


        boolean result = areSetsEqual(set1, set2);

        // Print the result
        System.out.println(result);
    }
}

