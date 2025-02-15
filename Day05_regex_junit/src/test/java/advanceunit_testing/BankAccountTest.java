package advanceunit_testing;

import static org.junit.jupiter.api.Assertions.*;

import org.example.junit.advance_testing.BankAccount;
import org.junit.jupiter.api.*;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        //Initialize a bank account with an initial balance of 100.0
        bankAccount = new BankAccount(100.0);
    }

    @Test
    public void testDeposit() {
        //Deposit a valid amount and check if the balance is updated correctly
        bankAccount.deposit(50.0);
        assertEquals(150.0, bankAccount.getBalance());

        //deposit another valid amount and check again
        bankAccount.deposit(25.0);
        assertEquals(175.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        //Withdraw a valid amount
        assertTrue(bankAccount.withdraw(50.0));
        assertEquals(50.0, bankAccount.getBalance());

        //Withdraw another valid amount and check balance
        assertTrue(bankAccount.withdraw(30.0));
        assertEquals(20.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw_InsufficientFunds() {
        //Try to withdraw more than the available balance
        assertFalse(bankAccount.withdraw(150.0));
        assertEquals(100.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw_InvalidAmount() {
        //Try to withdraw a negative amount
        assertFalse(bankAccount.withdraw(-10.0));
        assertEquals(100.0, bankAccount.getBalance());
    }

    @Test
    public void testDeposit_InvalidAmount() {
        //Try depositing a negative amount
        bankAccount.deposit(-50.0);
        assertEquals(100.0, bankAccount.getBalance()); // Balance should remain unchanged
    }

    @Test
    public void testGetBalance() {
        //Check if the balance is correctly returned
        assertEquals(100.0, bankAccount.getBalance());
    }
}
