package org.example.reflection.advance;
import java.lang.reflect.Method;

class SampleClass {
    //Simulating some processing time
    public void method1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 executed");
    }

    // Method 2: Simulating some processing time
    public void method2() {
        try {
            Thread.sleep(2000); // Sleep for 2 seconds to simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 executed");
    }
}

public class  MethodExecution  {

    public static void main(String[] args) {
        try {
            //Create an instance of SampleClass
            SampleClass sample = new SampleClass();

            Class<?> clazz = sample.getClass();

            //Get all the methods in the class
            Method[] methods = clazz.getDeclaredMethods();

            //iterate through the methods and measure execution time
            for (Method method : methods) {
                //Measure execution time for each method
                long startTime = System.nanoTime();

                //Invoke the method dynamically
                method.invoke(sample);

                long endTime = System.nanoTime();

                //Calculate and print the execution time
                long duration = endTime - startTime;
                System.out.println("Execution time of " + method.getName() + ": " + duration + " nanoseconds\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
