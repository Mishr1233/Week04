package org.example.insurence_policy_management;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class PolicyInsuranceManager {
    private Set<InsurancePolicy> hashSetPolicies;
    private Set<InsurancePolicy> linkedHashSetPolicies;
    private Set<InsurancePolicy> treeSetPolicies;

    public PolicyInsuranceManager() {
        hashSetPolicies = new HashSet<>();
        linkedHashSetPolicies = new LinkedHashSet<>();
        treeSetPolicies = new TreeSet<>(Comparator.comparing(InsurancePolicy::getExpiryDate));
    }

    // Method to add policies
    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    // Method to retrieve all policies
    public void retrieveAllPolicies() {
        System.out.println("HashSet Policies:");
        hashSetPolicies.forEach(System.out::println);
        System.out.println("LinkedHashSet Policies:");
        linkedHashSetPolicies.forEach(System.out::println);
        System.out.println("TreeSet Policies:");
        treeSetPolicies.forEach(System.out::println);
    }

    // Method to retrieve policies expiring soon
    public void retrieveExpiringSoon() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date futureDate = calendar.getTime();

        System.out.println("Policies Expiring Soon:");
        for (InsurancePolicy policy : treeSetPolicies) {
            if (policy.getExpiryDate().before(futureDate)) {
                System.out.println(policy);
            }
        }
    }

    // Method to retrieve policies with a specific coverage type
    public void retrievePoliciesByCoverage(String coverageType) {
        System.out.println("Policies with Coverage Type: " + coverageType);
        for (InsurancePolicy policy : treeSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    // Method to find duplicate policies based on policy number
    public void findDuplicatePolicies() {
        Set<String> policyNumbers = new HashSet<>();
        System.out.println("Duplicate Policies:");
        for (InsurancePolicy policy : linkedHashSetPolicies) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    // Method to compare performance
    public void comparePerformance() {
        long startTime, endTime;

        // Adding Policies
        startTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            addPolicy(new InsurancePolicy("Policy" + i, "Policyholder" + i, new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(i)), "Health", 1000.0));
        }
        endTime = System.nanoTime();
        System.out.println("Time to add policies: " + (endTime - startTime) + " ns");

        // Removing Policies
        startTime = System.nanoTime();
        hashSetPolicies.removeIf(policy -> policy.getPolicyNumber().equals("Policy500"));
        endTime = System.nanoTime();
        System.out.println("Time to remove policies from HashSet: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.removeIf(policy -> policy.getPolicyNumber().equals("Policy500"));
        endTime = System.nanoTime();
        System.out.println("Time to remove policies from LinkedHashSet: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.removeIf(policy -> policy.getPolicyNumber().equals("Policy500"));
        endTime = System.nanoTime();
        System.out.println("Time to remove policies from TreeSet: " + (endTime - startTime) + " ns");

        // Searching Policies
        startTime = System.nanoTime();
        hashSetPolicies.contains(new InsurancePolicy("Policy500", "", new Date(), "", 0)); // Search for specific policy
        endTime = System.nanoTime();
        System.out.println("Time to search policies in HashSet: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linkedHashSetPolicies.contains(new InsurancePolicy("Policy500", "", new Date(), "", 0)); // Search for specific policy
        endTime = System.nanoTime();
        System.out.println("Time to search policies in LinkedHashSet: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        treeSetPolicies.contains(new InsurancePolicy("Policy500", "", new Date(), "", 0)); // Search for specific policy
        endTime = System.nanoTime();
        System.out.println("Time to search policies in TreeSet: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        PolicyInsuranceManager manager = new PolicyInsuranceManager();

        // Adding some sample policies
        manager.addPolicy(new InsurancePolicy("P123", "John Doe", new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(5)), "Health", 1000.0));
        manager.addPolicy(new InsurancePolicy("P124", "Jane Smith", new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(10)), "Auto", 500.0));
        manager.addPolicy(new InsurancePolicy("P125", "Alice Johnson", new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(20)), "Home", 1500.0));

        // Retrieving and displaying policies
        manager.retrieveAllPolicies();
        manager.retrieveExpiringSoon();
        manager.retrievePoliciesByCoverage("Health");

        // Finding duplicate policies
        manager.findDuplicatePolicies();

        // Comparing performance
        manager.comparePerformance();
    }
}
