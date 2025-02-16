package org.example.annotation.intermediate_level;

import java.lang.annotation.*;  // Import annotation-related classes
import java.lang.reflect.*;

//Define the custom annotation @LogExecutionTime
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
    //this annotation doesn't need any fields, it's just used to mark the method for logging execution time
}

//Create a class with methods annotated with @LogExecutionTime to measure execution time
class TaskProcessor {

    //Apply @LogExecutionTime to log the execution time of this method
    @LogExecutionTime
    public void processTaskA() {
        //Simulating a task that takes time
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Apply @LogExecutionTime to log the execution time of another method
    @LogExecutionTime
    public void processTaskB() {
        //Simulating a task that takes more time
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //A method without the annotation for comparison
    public void completeTask() {
        System.out.println("Task completed without logging execution time.");
    }
}

public class LoggingMethod  {

    public static void main(String[] args) {
        try {
            TaskProcessor taskProcessor = new TaskProcessor();

            //Use Reflection to measure the execution time of annotated methods
            Method[] methods = TaskProcessor.class.getDeclaredMethods();

            for (Method method : methods) {
                //check if the method is annotated with @LogExecutionTime
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    long startTime = System.nanoTime(); // Record start time

                    //Invoke the method
                    method.invoke(taskProcessor);

                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Execution time for method " + method.getName() + ": " + duration + " nanoseconds");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
