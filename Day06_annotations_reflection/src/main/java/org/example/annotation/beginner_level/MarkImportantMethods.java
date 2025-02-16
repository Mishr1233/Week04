package org.example.annotation.beginner_level;

import java.lang.annotation.*;
import java.lang.reflect.*;

//Define the custom annotation @ImportantMethod
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

//create a class with methods annotated with @ImportantMethod
class TaskManager {

    //Mark this method as important with level "HIGH"
    @ImportantMethod(level = "HIGH")
    public void criticalTask() {
        System.out.println("Executing critical task...");
    }

    //Mark this method as important with level "MEDIUM"
    @ImportantMethod(level = "MEDIUM")
    public void routineTask() {
        System.out.println("Executing routine task...");
    }

    //A method without the @ImportantMethod annotation
    public void regularTask() {
        System.out.println("Executing regular task...");
    }
}

public class MarkImportantMethods {

    public static void main(String[] args) {
        try {
            //Use Reflection to retrieve all methods with the @ImportantMethod annotation
            Class<?> taskManagerClass = TaskManager.class;

            //Get all declared methods from TaskManager class
            Method[] methods = taskManagerClass.getDeclaredMethods();

            //Loop through all methods
            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    //Retrieve the annotation from the method
                    ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
                    //Print the method name and the level of importance
                    System.out.println("Method: " + method.getName());
                    System.out.println("Importance Level: " + importantMethod.level());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
