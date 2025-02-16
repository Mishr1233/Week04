package org.example.annotation.advance_level;

import java.lang.annotation.*;
import java.util.*;

//Define the custom annotation @CacheResult
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

//Define the class that will use the caching system
class ExpensiveComputation {

    //Cache to store the computed results
    private static final Map<String, Integer> cache = new HashMap<>();

    //Computationally expensive method to calculate factorial
    @CacheResult
    public int factorial(int n) {

        if (cache.containsKey(String.valueOf(n))) {
            System.out.println("Returning cached result for factorial(" + n + ")");
            return cache.get(String.valueOf(n));
        }

        //If not in cache, compute it
        System.out.println("Computing factorial(" + n + ")");
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        //Store the result in cache
        cache.put(String.valueOf(n), result);
        return result;
    }

    //Another computationally expensive method
    @CacheResult
    public int square(int n) {

        if (cache.containsKey("square_" + n)) {
            System.out.println("Returning cached result for square(" + n + ")");
            return cache.get("square_" + n);
        }

        //If not in cache, compute it
        System.out.println("Computing square(" + n + ")");
        int result = n * n;

        //Store the result in cache
        cache.put("square_" + n, result);
        return result;
    }
}

public class CustomCachingSystem {

    public static void main(String[] args) {
        ExpensiveComputation computation = new ExpensiveComputation();

        //call the expensive methods and observe the caching behavior
        System.out.println(computation.factorial(5));
        System.out.println(computation.factorial(5));

        System.out.println(computation.square(4));
        System.out.println(computation.square(4));

        System.out.println(computation.factorial(6));
        System.out.println(computation.factorial(6));
    }
}
