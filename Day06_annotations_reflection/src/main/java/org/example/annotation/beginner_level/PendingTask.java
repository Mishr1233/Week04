package org.example.annotation.beginner_level;

import java.lang.annotation.*;
import java.lang.reflect.*;    // Import Reflection classes

//Define the custom annotation @Todo
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)          // Apply it only to methods
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

//Create a class with methods annotated with @Todo to mark pending tasks
class ProjectManager {

    //Mark this method with @Todo to describe a pending feature
    @Todo(task = "Implement user login functionality", assignedTo = "Alice", priority = "HIGH")
    public void userLogin() {
        System.out.println("User login feature is under development...");
    }

    //Mark this method with @Todo for another pending feature
    @Todo(task = "Design homepage UI", assignedTo = "Bob", priority = "MEDIUM")
    public void homepageUI() {
        System.out.println("Homepage UI design is in progress...");
    }

    //another method with a default priority
    @Todo(task = "Setup database schema", assignedTo = "Charlie")
    public void setupDatabase() {
        System.out.println("Setting up the database schema...");
    }

    //A method without the @Todo annotation (not a pending task)
    public void completeTask() {
        System.out.println("Task completed!");
    }
}

public class PendingTask {

    public static void main(String[] args) {
        try {
            //Use Reflection to retrieve all methods with the @Todo annotation
            Class<?> projectManagerClass = ProjectManager.class;

            //Get all declared methods from the ProjectManager class
            Method[] methods = projectManagerClass.getDeclaredMethods();

            //Loop through all methods to check for @Todo annotations
            for (Method method : methods) {
                //Check if the method is annotated with @Todo
                if (method.isAnnotationPresent(Todo.class)) {
                    //Retrieve the @Todo annotation
                    Todo todo = method.getAnnotation(Todo.class);

                    System.out.println("Method: " + method.getName());
                    System.out.println("Task: " + todo.task());
                    System.out.println("Assigned To: " + todo.assignedTo());
                    System.out.println("Priority: " + todo.priority());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
