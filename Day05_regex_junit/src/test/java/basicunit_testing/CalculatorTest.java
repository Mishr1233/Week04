package basicunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    //Create an instance of the Calculator
    Calculator calculator = new Calculator();

    //Test add method
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        assertEquals(-1, calculator.add(-2, 1), "-2 + 1 should equal -1");
    }

    //Test subtract method
    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
        assertEquals(-3, calculator.subtract(-2, 1), "-2 - 1 should equal -3");
    }

    //Test multiply method
    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(-6, calculator.multiply(-2, 3), "-2 * 3 should equal -6");
    }

    //Test divide method
    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), "6 / 3 should equal 2.0");
        assertEquals(-2.0, calculator.divide(-6, 3), "-6 / 3 should equal -2.0");
    }

    //Test division by zero and handle exceptions properly
    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage(), "Exception message should be 'Cannot divide by zero'");
    }
}
