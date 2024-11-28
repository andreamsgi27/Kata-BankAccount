package com.example.demo;

public class SavingsAccount extends BankAccount {
    private boolean accIsActive;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.accIsActive = balance >= 10000;
    }

    private void checkAccountStatus() {
        accIsActive = balance >= 10000;
    }

    @Override
    public void makeDeposit(float amount) {
        if (!accIsActive){
            System.out.println("Account is inactive.");
            return;
        }
        if (amount > 0) {
            super.makeDeposit(amount);
        } else {
            System.out.println("Quantity should be greater than 0.");
        }
        checkAccountStatus();
    }

    @Override
    public void withdraw(float amount) {
        if (!accIsActive) {
            System.out.println("Account is inactive.");
            return;
        }

        if (amount > 0) {
            if (amount <= balance) {
                super.withdraw(amount);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Quantity to withdraw should be greater than 0.");
        }
        checkAccountStatus();
    }

    @Override
    public void applyMonthlyFee() {
        if (withdrawal > 4) {
            monthlyFee += (withdrawal - 4) * 1000;
        }
        super.applyMonthlyFee();
    }

    @Override
    public String printAccount() {
        return String.format(
            "[Savings Account]\n" +
            "Balance: %.2f\n" +
            "Deposits: %d\n" +
            "Withdrawals: %d\n" +
            "Annual Rate: %.2f%%\n" +
            "Monthly Fee: %.2f\n" +
            "Account Status: %s\n" +
            "Total Transactions: %d",
            balance,
            deposit,
            withdrawal,
            annualRate,
            monthlyFee,
            accIsActive ? "Active" : "Inactive",
            deposit + withdrawal
        );
    }
}
