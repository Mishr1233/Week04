package basicunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.basic_junit.DatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


public class DatabaseConnectionTest {

    private DatabaseConnection dbConnection;

    //@BeforeEach will run before each test method
    @BeforeEach
    public void setUp() {
        dbConnection = new DatabaseConnection();
        dbConnection.connect();
    }

    //@AfterEach will run after each test method
    @AfterEach
    public void tearDown() {
        dbConnection.disconnect();
    }

    //Test to verify that the connection is established
    @Test
    public void testConnectionEstablished() {
        assertTrue(dbConnection.isConnected(), "The database connection should be established.");
    }

    //Test to verify that the connection is closed
    @Test
    public void testConnectionClosed() {
        dbConnection.disconnect();
        assertFalse(dbConnection.isConnected(), "The database connection should be closed.");
    }
}
