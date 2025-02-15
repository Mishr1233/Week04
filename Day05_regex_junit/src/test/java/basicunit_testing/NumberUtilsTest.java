package basicunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    //@ParameterizedTest with @ValueSource to provide multiple input values
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenWithEvenNumbers(int number) {
        //Checking if the number is even
        assertTrue(NumberUtils.isEven(number), "The number " + number + " should be even.");
    }

    //@ParameterizedTest with @ValueSource to provide odd numbers
    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenWithOddNumbers(int number) {
        //Checking if the number is odd
        assertFalse(NumberUtils.isEven(number), "The number " + number + " should be odd.");
    }
}
