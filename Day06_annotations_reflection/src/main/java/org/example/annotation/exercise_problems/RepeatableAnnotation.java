package org.example.annotation.exercise_problems;
import java.lang.annotation.*;
import java.lang.reflect.*;    // Importing Reflection classes

//Define the container annotation for repeatable BugReports
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

//define the repeatable annotation @BugReport
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class) //This makes it repeatable on the method
@interface BugReport {
    String description();
}

//Create a class with a method annotated with multiple @BugReport annotations
class SoftwareApp {

    @BugReport(description = "App crashes when clicking the Save button.")
    @BugReport(description = "App freezes when opening the settings menu.")
    public void performTask() {
        System.out.println("Performing task...");
    }
}

public class RepeatableAnnotation {

    public static void main(String[] args) {
        try {
            //Use Reflection to retrieve all @BugReport annotations on the method
            Class<?> softwareAppClass = SoftwareApp.class;

            Method method = softwareAppClass.getMethod("performTask");

            //Check if the method is annotated with the BugReports container annotation
            if (method.isAnnotationPresent(BugReports.class)) {

                BugReports bugReports = method.getAnnotation(BugReports.class);

                //Print out each bug report description
                System.out.println("Bug Reports for method: " + method.getName());
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("Bug Description: " + bugReport.description());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
