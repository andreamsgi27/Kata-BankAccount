package com.example.demo;

public class SavingsAccount extends BankAccount {
    boolean accIsActive;

    public SavingsAccount(float balance, int deposit, int withdrawal, float annualRate, float monthlyFee, boolean accIsActive) {
        super(balance, deposit, withdrawal, annualRate, monthlyFee);
        this.accIsActive = accIsActive;
    }

    @Override
    public void makeDeposit(float amount) {
        if (accIsActive) {
            balance += amount;
            System.out.println("Deposit of " + amount + " made successfully.");
        } else {
            System.out.println("Account is inactive.");
        }
    }

    @Override
    public void withdraw(float amount) {
        if (accIsActive) {
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                balance -= amount;
                System.out.println("Withdrawal of " + amount + " made successfully.");
            }
        } else {
            System.out.println("Account is inactive.");
        }
    }

    @Override
    public void calcMonFee() {
        if (balance > 0) {
            balance -= monthlyFee;
        } else {
            accIsActive = false;
            System.out.println("Account is now inactive due to insufficient balance.");
        }
    }

    public String printSavAccount() {
        return super.printBankAccount() + " Account Active: " + accIsActive;
    }
}
