package advanceunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.advance_testing.DateFormatter;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    private final DateFormatter dateFormatter = new DateFormatter();

    @Test
    public void testValidDate() {
        String input = "2023-03-01";
        String expected = "01-03-2023";
        assertEquals(expected, dateFormatter.formatDate(input));
    }

    @Test
    public void testInvalidDateFormat() {
        String input = "2023-02-30"; // Invalid date
        assertNull(dateFormatter.formatDate(input));
    }

    @Test
    public void testEdgeCaseLeapYear() {
        String input = "2024-02-29"; // Valid leap year date
        String expected = "29-02-2024";
        assertEquals(expected, dateFormatter.formatDate(input));

        input = "2023-02-29"; // Invalid non-leap year date
        assertNull(dateFormatter.formatDate(input));
    }

    @Test
    public void testNonExistingDate() {
        String input = "2023-04-31"; // Non-existing date
        assertNull(dateFormatter.formatDate(input));
    }

    @Test
    public void testEmptyInput() {
        String input = "";
        assertNull(dateFormatter.formatDate(input));
    }

    @Test
    public void testNullInput() {
        assertNull(dateFormatter.formatDate(null));
    }

    @Test
    public void testInvalidFormat() {
        String input = "2023/03/01";
        assertNull(dateFormatter.formatDate(input));
    }
}
