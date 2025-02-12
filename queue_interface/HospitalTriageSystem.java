package org.example.queue_interface;

import java.util.*;

class Patient {
    String name;
    int severity;

    // Constructor
    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {

    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("John", 3));
        patients.add(new Patient("Alice", 5));
        patients.add(new Patient("Bob", 2));

        // PriorityQueue to simulate the triage system. Highest severity is treated first.
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new Comparator<Patient>() {
            @Override
            public int compare(Patient p1, Patient p2) {
                return Integer.compare(p2.severity, p1.severity); // Descending order
            }
        });

        // Add all patients to the priority queue
        triageQueue.addAll(patients);

        // Process patients in the order of severity
        System.out.println("Order of treatment based on severity:");
        while (!triageQueue.isEmpty()) {
            Patient patient = triageQueue.poll();
            System.out.println(patient);
        }
    }
}
