package com.example;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        // Arrange phase for tests: Initialize the test fixture
        account = new BankAccount(100.0);
        System.out.println("Set up: BankAccount initialized with 100.0");
    }

    @After
    public void tearDown() {
        // Clean up or log at the end of each test execution
        account = null;
        System.out.println("Tear down completed");
    }

    @Test
    public void testDeposit() {
        // Arrange
        double depositAmount = 50.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Arrange
        double withdrawAmount = 40.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        // Arrange
        double withdrawAmount = 150.0;

        // Act
        account.withdraw(withdrawAmount);

        // Assert (implicitly handled by expected exception)
    }
}
