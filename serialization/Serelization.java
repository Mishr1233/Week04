package org.example.serialization;

import java.io.*;
        import java.util.*;

public class Serelization {
    public static void main(String[] args) {
        //list of employees to be serialized
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Alice", "HR", 60000));
        employeeList.add(new Employee(2, "Bob", "Engineering", 80000));
        employeeList.add(new Employee(3, "Charlie", "Marketing", 75000));

        //serialize the list of employees to a file
        String fileName = "employees.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employeeList);
            System.out.println("Employee list has been serialized to " + fileName);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        //deserialize the list of employees from the file and display
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Employee> deserializedList = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employee List:");
            for (Employee emp : deserializedList) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}
