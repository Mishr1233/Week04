package org.example.map_interface;

import java.util.*;

public class EmployeGroup {

    // Enum for Department
    enum Department {
        HR, IT, SALES, FINANCE
    }

    // Employee class to represent an employee
    static class Employee {
        String name;
        Department department;

        // Constructor
        public Employee(String name, Department department) {
            this.name = name;
            this.department = department;
        }

        // Getters
        public String getName() {
            return name;
        }

        public Department getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Method to group employees by their department
    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> groupedByDepartment = new HashMap<>();

        // Loop through each employee and group by department
        for (Employee employee : employees) {
            Department department = employee.getDepartment();

            groupedByDepartment.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
        }

        return groupedByDepartment;
    }

    // Main method to test the grouping functionality
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR),
                new Employee("David", Department.FINANCE),
                new Employee("Eve", Department.IT)
        );

        // Group employees by department
        Map<Department, List<Employee>> groupedEmployees = groupByDepartment(employees);

        for (Map.Entry<Department, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
