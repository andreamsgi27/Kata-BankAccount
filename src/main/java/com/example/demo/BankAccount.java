package com.example.demo;


public class BankAccount {
    protected float balance;
    protected int deposit = 0;
    protected int withdrawal = 0;
    protected float annualRate;
    protected float monthlyFee = 0;

    public BankAccount(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public void makeDeposit(float amount) {
        if (amount > 0) {
            balance += amount;
            deposit++;
        } else {
            System.out.println("Quantity should be greater than 0");
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            withdrawal++;
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }

    public void applyMonthlyFee() {
        balance -= monthlyFee;
    }

    public String printAccount() {
        return String.format("Balance: %.2f, Deposits: %d, Withdrawals: %d, Annual Rate: %.2f%%",
                balance, deposit, withdrawal, annualRate);
    }
}