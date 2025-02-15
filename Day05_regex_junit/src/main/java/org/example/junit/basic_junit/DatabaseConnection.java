package org.example.junit.basic_junit;
public class DatabaseConnection {

    private boolean isConnected;

    //Method to simulate a database connection
    public void connect() {
        isConnected = true;
        System.out.println("Connected to the database.");
    }

    //Method to simulate disconnecting from the database
    public void disconnect() {
        isConnected = false;
        System.out.println("Disconnected from the database.");
    }

    //Method to check if the connection is established
    public boolean isConnected() {
        return isConnected;
    }
}
