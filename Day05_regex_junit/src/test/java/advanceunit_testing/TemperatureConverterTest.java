package advanceunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.advance_testing.TemperatureConvertor;
import org.junit.jupiter.api.*;

public class TemperatureConverterTest {

    private TemperatureConvertor converter;

    @BeforeEach
    public void setUp() {
        //Initialize the TemperatureConverter before each test
        converter = new TemperatureConvertor();
    }

    @Test
    public void testCelsiusToFahrenheit() {
        //Test valid Celsius to Fahrenheit conversions
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.001);
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius() {
        //Test valid Fahrenheit to Celsius conversions
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.001);
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), 0.001);
    }

    @Test
    public void testNegativeCelsiusToFahrenheit() {
        //Test negative Celsius value
        assertEquals(-40.0, converter.celsiusToFahrenheit(-40), 0.001); // Negative case where Celsius = Fahrenheit
    }

    @Test
    public void testNegativeFahrenheitToCelsius() {
        //Test negative Fahrenheit value
        assertEquals(-40.0, converter.fahrenheitToCelsius(-40), 0.001);
    }

    @Test
    public void testZeroCelsiusToFahrenheit() {
        //Test 0°C to Fahrenheit
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001);
    }

    @Test
    public void testZeroFahrenheitToCelsius() {
        //Test 0°F to Celsius
        assertEquals(-17.7778, converter.fahrenheitToCelsius(0), 0.001);
    }
}
