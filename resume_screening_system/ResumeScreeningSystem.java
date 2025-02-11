package org.example.resume_screening_system;

import java.util.List;

//Define the abstract class JobRole
abstract class JobRole {
    public abstract String getRoleDescription();
}

//define specific job roles that extend JobRole
class SoftwareEngineer extends JobRole {
    @Override
    public String getRoleDescription() {
        return "Software Engineer: Develops software solutions.";
    }
}

class DataScientist extends JobRole {
    @Override
    public String getRoleDescription() {
        return "Data Scientist: Analyzes and interprets complex data.";
    }
}

class ProductManager extends JobRole {
    @Override
    public String getRoleDescription() {
        return "Product Manager: Oversees the development of products.";
    }
}

//Create the generic class Resume<T extends JobRole>
class Resume<T extends JobRole> {
    private String applicantName;
    private T jobRole;

    public Resume(String applicantName, T jobRole) {
        this.applicantName = applicantName;
        this.jobRole = jobRole;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void displayResumeInfo() {
        System.out.println("Applicant: " + applicantName);
        System.out.println("Applying for: " + jobRole.getRoleDescription());
    }
}

//method to process resumes dynamically using wildcards
public class ResumeScreeningSystem {

    // Method to screen a list of resumes for different job roles using wildcards
    public static void screenResumes(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            System.out.println("Screening for: " + resume.getRoleDescription());
        }
    }

    public static void main(String[] args) {
        //Create resumes for different job roles
        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> dataScientistResume = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> productManagerResume = new Resume<>("Charlie", new ProductManager());

        //Display resume information for each applicant
        softwareEngineerResume.displayResumeInfo();
        dataScientistResume.displayResumeInfo();
        productManagerResume.displayResumeInfo();

        //Process a list of resumes dynamically using wildcards
        System.out.println("\nScreening Resumes:");
        screenResumes(List.of(softwareEngineerResume.getJobRole(), dataScientistResume.getJobRole(), productManagerResume.getJobRole()));
    }
}

