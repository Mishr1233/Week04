package basicunit_testing;
import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.MathOperations;
import org.junit.jupiter.api.Test;

public class MathOperationTest {

    //Test for the divide method when dividing by zero
    @Test
    public void testDivideByZero() {

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            MathOperations.divide(10, 0);
        });

        // Optionally verify the exception message
        assertEquals("Cannot divide by zero.", exception.getMessage(), "The exception message should match.");
    }

    //Test for normal division
    @Test
    public void testDivideNormal() {
        int result = MathOperations.divide(10, 2);
        assertEquals(5, result, "The result of dividing 10 by 2 should be 5.");
    }
}
