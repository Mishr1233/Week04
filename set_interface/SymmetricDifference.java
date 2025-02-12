package org.example.set_interface;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Adding elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);

        // Adding elements to set2
        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Copy set1 to a new set to preserve it
        Set<Integer> symmetricDifference = new HashSet<>(set1);

        // Remove elements that are in both set1 and set2
        symmetricDifference.addAll(set2);
        Set<Integer> commonElements = new HashSet<>(set1);
        commonElements.retainAll(set2); // Find common elements
        symmetricDifference.removeAll(commonElements);


        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
