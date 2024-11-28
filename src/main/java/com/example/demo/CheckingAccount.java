package com.example.demo;

public class CheckingAccount extends BankAccount {
    float overdraftLimit;

    public CheckingAccount(float balance, int deposit, int withdrawal, float annualRate, float monthlyFee, float overdraftLimit) {
        super(balance, deposit, withdrawal, annualRate, monthlyFee);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void makeDeposit(float amount) {
        
    }

    @Override
    public void withdraw(float amount) {
    }

    @Override
    public void calcMonFee() {
    }

    public String printCheckAccount() {
        return "Checking Account";
    }
}
