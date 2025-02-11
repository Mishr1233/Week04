package org.example.university_course_management;


import java.util.List;

// Abstract class representing the type of course
abstract class CourseType {
    public abstract String getEvaluationMethod();
}

// Different types of course evaluations
class ExamCourse extends CourseType {
    @Override
    public String getEvaluationMethod() {
        return "Evaluation: Exam-based";
    }
}

class AssignmentCourse extends CourseType {
    @Override
    public String getEvaluationMethod() {
        return "Evaluation: Assignment-based";
    }
}

class ResearchCourse extends CourseType {
    @Override
    public String getEvaluationMethod() {
        return "Evaluation: Research-based";
    }
}

// Generic Course class
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println(courseType.getEvaluationMethod());
    }
}


public class UniversityCourseManagement {

    // Modified method to handle list of Course objects, not just CourseType
    public static void displayCourseList(List<? extends Course<?>> courses) {
        for (Course<?> course : courses) {
            course.displayCourseInfo();
        }
    }

    public static void main(String[] args) {
        // Creating courses with different evaluation types
        Course<ExamCourse> examCourse = new Course<>("Java 101", new ExamCourse());
        Course<AssignmentCourse> assignmentCourse = new Course<>("Data Structures", new AssignmentCourse());
        Course<ResearchCourse> researchCourse = new Course<>("AI Research", new ResearchCourse());

        // Displaying course information dynamically using wildcard
        displayCourseList(List.of(examCourse, assignmentCourse, researchCourse));
    }
}
