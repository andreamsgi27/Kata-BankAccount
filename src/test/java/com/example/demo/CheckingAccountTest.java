package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {
    @Test
    void testMakeDeposit() {
        CheckingAccount account = new CheckingAccount(1000f, 10f, -50f);
        account.makeDeposit(100f);
        assertThat(account.balance).isEqualTo(1100f);
    }

    @Test
    void testWithdraw() {
        CheckingAccount account = new CheckingAccount(1000f, 10f, -50f);
        account.withdraw(100f);
        assertThat(account.balance).isEqualTo(900f);
    }

    @Test
    void testWithdrawExceedsLimit() {
        CheckingAccount account = new CheckingAccount(1000f, 10f, -50f);
        account.withdraw(10000f);
        assertThat(account.balance).isEqualTo(1000f);
    }

    @Test
    void testApplyMonthlyFee() {
        CheckingAccount account = new CheckingAccount(10000f, 10f, -50f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.withdraw(500f);
        account.applyMonthlyFee();
        assertThat(account.balance).isEqualTo(6500.0f);
    }

    @Test
    void testPrintAccount() {
        BankAccount account = new CheckingAccount(1000f, 0.05f, -50f);
        String expected = "Balance: 1000,00, Deposits: 0, Withdrawals: 0, Annual Rate: 0,05%, Overdraft Limit: -50,00";
        String actual = account.printAccount();
        assertThat(actual).isEqualTo(expected);
    }
}
