package org.example.annotation.exercise_problems;
import java.lang.annotation.*;
import java.lang.reflect.*;

//Define a custom annotation @TaskInfo
@Retention(RetentionPolicy.RUNTIME)  // This ensures the annotation is available at runtime
@Target(ElementType.METHOD)
@interface TaskInfo {
    int priority();
    String assignedTo();
}

//Create the TaskManager class where tasks will be managed
class TaskManager {

    //Annotate method task1 with @TaskInfo and specify priority and assignee
    @TaskInfo(priority = 1, assignedTo = "John Doe")
    public void task1() {
        System.out.println("Executing Task 1");
    }

    //Annotate method task2 with @TaskInfo and specify priority and assignee
    @TaskInfo(priority = 2, assignedTo = "Jane Smith")
    public void task2() {
        System.out.println("Executing Task 2");
    }
}

public class CustomAnnotation{

        public static void main(String[] args) {
        try {
            // Get the TaskManager class for inspecting its methods
            Class<?> taskManagerClass = TaskManager.class;

            //Get all declared methods in the TaskManager class
            Method[] methods = taskManagerClass.getDeclaredMethods();

            //Loop through each method to check for the @TaskInfo annotation
            for (Method method : methods) {

                if (method.isAnnotationPresent(TaskInfo.class)) {
                    //Retrieve the annotation for the method
                    TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);

                    System.out.println("Method: " + method.getName());
                    System.out.println("Priority: " + taskInfo.priority());
                    System.out.println("Assigned To: " + taskInfo.assignedTo());
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
