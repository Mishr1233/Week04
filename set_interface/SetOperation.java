package org.example.set_interface;


import java.util.HashSet;
import java.util.Set;

public class SetOperation{

    // Method to compute the union of two sets
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    // Method to compute the intersection of two sets
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Computing the union of set1 and set2
        Set<Integer> unionResult = union(set1, set2);
        // Computing the intersection of set1 and set2
        Set<Integer> intersectionResult = intersection(set1, set2);

        // Print the results
        System.out.println("Union: " + unionResult);
        System.out.println("Intersection: " + intersectionResult);
    }
}
