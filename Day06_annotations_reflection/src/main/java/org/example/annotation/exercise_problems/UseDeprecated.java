package org.example.annotation.exercise_problems;

public class UseDeprecated {

    //Marking the old method as deprecated
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature, which is deprecated.");
    }

    //New and improved method to be used instead of the old one
    public void newFeature() {
        System.out.println("This is the new feature, use this instead of oldFeature.");
    }

    public static void main(String[] args) {
        //Create an instance of LegacyAPI
        UseDeprecated api = new UseDeprecated();

        //Call the deprecated method
        api.oldFeature();

        //Call the new method
        api.newFeature();
    }
}
