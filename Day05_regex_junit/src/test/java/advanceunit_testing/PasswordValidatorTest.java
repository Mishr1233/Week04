package advanceunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.advance_testing.PasswordValidator;
import org.junit.jupiter.api.*;

public class PasswordValidatorTest {

    private PasswordValidator passwordValidator;

    @BeforeEach
    public void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void testValidPassword() {
        //Test a valid password with at least 8 characters, one uppercase letter, and one digit
        assertTrue(passwordValidator.isValid("Valid123"));
        assertTrue(passwordValidator.isValid("MyPassword1"));
    }

    @Test
    public void testInvalidPassword_TooShort() {
        //Test a password that is too short (less than 8 characters)
        assertFalse(passwordValidator.isValid("Short1"));
    }

    @Test
    public void testInvalidPassword_NoUppercase() {
        //Test a password with no uppercase letter
        assertFalse(passwordValidator.isValid("password1"));
    }

    @Test
    public void testInvalidPassword_NoDigit() {
        //Test a password with no digit
        assertFalse(passwordValidator.isValid("Password"));
    }

    @Test
    public void testInvalidPassword_Empty() {
        //Test an empty password
        assertFalse(passwordValidator.isValid(""));
    }

    @Test
    public void testInvalidPassword_Null() {
        //Test a null password
        assertFalse(passwordValidator.isValid(null));
    }
}
