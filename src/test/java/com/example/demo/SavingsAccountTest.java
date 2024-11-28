package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

    @Test
    void testDepositInActiveAccount() {
    BankAccount account = new SavingsAccount(10000, 0.05f);
    
    account.makeDeposit(500f);
    
    assertThat(account.balance).isEqualTo(10500f);
    }

    @Test
    void testDepositInInactiveAccount(){
        BankAccount account = new SavingsAccount(100, 0.05f);
        account.makeDeposit(500f);
        assertThat(account.balance).isEqualTo(100f);
    }

    @Test
    void testWithdrawInActiveAccount(){
        BankAccount account = new SavingsAccount(10000, 0.05f);
        account.withdraw(500f);
        assertThat(account.balance).isEqualTo(9500f);
    }

    @Test
    void testWithdrawInInactiveAccount(){
        BankAccount account = new SavingsAccount(100, 0.05f);
        account.withdraw(500f);
        assertThat(account.balance).isEqualTo(100f);
    }

    @Test
    void testApplyMonthlyFee(){
        BankAccount account = new SavingsAccount(10000, 0.05f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.applyMonthlyFee();
        assertThat(account.balance).isEqualTo(9500.0f);
    }

    @Test
    void testPrintAccount() {
        BankAccount account = new SavingsAccount(1000f, 0.05f);
        String expected = "[Savings Account]\n" +
                        "Balance: 1000,00\n" +
                        "Deposits: 0\n" +
                        "Withdrawals: 0\n" +
                        "Annual Rate: 0,05%\n" +
                        "Monthly Fee: 0,00\n" +
                        "Account Status: Inactive\n" +
                        "Total Transactions: 0";
        String actual = account.printAccount();
        assertThat(actual).isEqualTo(expected);
    }
}
