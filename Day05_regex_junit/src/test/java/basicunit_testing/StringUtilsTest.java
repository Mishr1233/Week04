package basicunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    //Test reverse method
    @Test
    public void testReverse() {
        assertEquals("edcba", StringUtils.reverse("abcde"), "The reverse of 'abcde' should be 'edcba'");
        assertEquals("a", StringUtils.reverse("a"), "The reverse of 'a' should be 'a'");
        assertEquals("", StringUtils.reverse(""), "The reverse of an empty string should be an empty string");
        assertNull(StringUtils.reverse(null), "The reverse of null should be null");
    }

    //Test isPalindrome method
    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"), "'madam' is a palindrome");
        assertTrue(StringUtils.isPalindrome("racecar"), "'racecar' is a palindrome");
        assertFalse(StringUtils.isPalindrome("hello"), "'hello' is not a palindrome");
        assertFalse(StringUtils.isPalindrome("world"), "'world' is not a palindrome");
        assertFalse(StringUtils.isPalindrome(null), "Null should not be considered a palindrome");
    }

    //Test toUpperCase method
    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"), "'hello' should be converted to 'HELLO'");
        assertEquals("WORLD", StringUtils.toUpperCase("world"), "'world' should be converted to 'WORLD'");
        assertEquals("JAVA", StringUtils.toUpperCase("java"), "'java' should be converted to 'JAVA'");
        assertEquals("", StringUtils.toUpperCase(""), "Empty string should remain empty");
        assertNull(StringUtils.toUpperCase(null), "Null should return null");
    }
}
