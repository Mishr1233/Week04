package org.example.annotation.advance_level;

import java.lang.annotation.*;
import java.lang.reflect.*;

//Define the custom annotation @RoleAllowed
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)          // Apply it only to methods
@interface RoleAllowed {
    String value();
}

//Define the User class that simulates user roles
class User {
    private String role;

    //Constructor to initialize the role of the user
    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

//Define the AdminOperations class with restricted methods
class AdminOperations {

    //Apply @RoleAllowed annotation to restrict access to the method
    @RoleAllowed("ADMIN")
    public void performAdminTask() {
        System.out.println("Admin task performed successfully.");
    }

    //Apply @RoleAllowed annotation to restrict access to another method
    @RoleAllowed("ADMIN")
    public void performSensitiveOperation() {
        System.out.println("Sensitive operation performed successfully.");
    }
}

public class AccessControl {

    public static void main(String[] args) {
        try {
            User adminUser = new User("ADMIN");
            User regularUser = new User("USER");

            AdminOperations adminOperations = new AdminOperations();

            //Admin user accessing methods
            invokeMethodIfAllowed(adminUser, adminOperations, "performAdminTask");
            invokeMethodIfAllowed(adminUser, adminOperations, "performSensitiveOperation");

            //Regular user accessing methods (should be denied)
            invokeMethodIfAllowed(regularUser, adminOperations, "performAdminTask");
            invokeMethodIfAllowed(regularUser, adminOperations, "performSensitiveOperation");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to invoke the annotated method if the user has the required role
    public static void invokeMethodIfAllowed(User user, AdminOperations adminOperations, String methodName) {
        try {
            //Use Reflection to get the method
            Method method = AdminOperations.class.getDeclaredMethod(methodName);

            //check if the method is annotated with @RoleAllowed
            if (method.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                String requiredRole = roleAllowed.value();

                //Check if the user's role matches the required role
                if (user.getRole().equals(requiredRole)) {

                    method.invoke(adminOperations);
                } else {
                    System.out.println("Access Denied! You don't have the required role to access this method.");
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
