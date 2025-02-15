package basicunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.TaskUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TaskUtilsTest {

    //Test method that should fail due to timeout
    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Timeout set to 2 seconds
    public void testLongRunningTaskTimeout() {
        //Call the long-running task method
        String result = TaskUtils.longRunningTask();

        //Assert that the task completes successfully
        assertEquals("Task Completed", result, "The task should complete with the expected result.");
    }
}
