package org.example.junit.basic_junit;

public class TaskUtils {

    //Simulate a long-running task
    public static String longRunningTask() {
        try {
            //Sleep for 2 seconds to simulate a long-running task
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task Completed";
    }
}
