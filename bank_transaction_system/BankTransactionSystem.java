package org.example.bank_transaction_system;


//Custom Exception class for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

//BankAccount class to handle transactions
class BankAccount {
    private double balance;

    //Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //Withdraw method that throws exceptions
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        //Check if withdrawal amount exceeds balance
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
    }

    //Get the current balance
    public double getBalance() {
        return balance;
    }
}

public class BankTransactionSystem {

    public static void main(String[] args) {
        //Initialize a bank account with an initial balance of 500
        BankAccount account = new BankAccount(500.00);

        try {
            //Trying to withdraw a valid amount
            double withdrawAmount = 200;
            account.withdraw(withdrawAmount);
            System.out.println("Withdrawal successful, new balance: " + account.getBalance());

            //trying to withdraw an amount greater than the balance
            withdrawAmount = 600;
            account.withdraw(withdrawAmount);

        } catch (InsufficientBalanceException e) {
            System.out.println("Insufficient balance!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
