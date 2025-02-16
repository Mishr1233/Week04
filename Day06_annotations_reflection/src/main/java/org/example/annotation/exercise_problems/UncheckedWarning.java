package org.example.annotation.exercise_problems;

import java.util.ArrayList;

public class UncheckedWarning {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Create an ArrayList without generics
        ArrayList list = new ArrayList();

        //Add elements to the list
        list.add("Hello");
        list.add(123);
        list.add(45.67);

        //Display the contents of the list
        for (Object item : list) {
            System.out.println(item);
        }
    }
}
