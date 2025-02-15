package advanceunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.advance_testing.UserRegistration;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    private final UserRegistration userRegistration = new UserRegistration();

    //Test valid user registration
    @Test
    public void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("john_doe", "john.doe@example.com", "password123"));
    }

    //Test invalid username
    @Test
    public void testInvalidUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistration.registerUser("", "john.doe@example.com", "password123"));
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    //Test invalid email
    @Test
    public void testInvalidEmail() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistration.registerUser("john_doe", "john.doeexample.com", "password123"));
        assertEquals("Invalid email address.", exception.getMessage());
    }

    //Test invalid password
    @Test
    public void testInvalidPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistration.registerUser("john_doe", "john.doe@example.com", "123"));
        assertEquals("Password must be at least 6 characters.", exception.getMessage());
    }

    //Test invalid password
    @Test
    public void testNullPassword() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistration.registerUser("john_doe", "john.doe@example.com", null));
        assertEquals("Password must be at least 6 characters.", exception.getMessage());
    }
}
