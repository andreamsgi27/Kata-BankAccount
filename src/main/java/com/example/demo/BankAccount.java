package com.example.demo;

public class BankAccount {
    protected float balance;
    protected int deposit = 0;
    protected int withdrawal = 0;
    protected float annualRate;
    protected float monthlyFee = 0;

    public BankAccount() {
    }

    public BankAccount(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public BankAccount(float balance, int deposit, int withdrawal, float annualRate, float monthlyFee) {
        this.balance = balance;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
        this.annualRate = annualRate;
        this.monthlyFee = monthlyFee;
    }

    public void makeDeposit(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
        }
    }

    public void calcMonFee(int fee) {
        balance -= (balance * fee / 100);
    }

    public void calcMonExtract() {
        balance += (balance * annualRate / 12);
    }

    public String printBankAccount() {
        return "Balance: " + balance + " Deposit: " + deposit + " Withdrawal: " + withdrawal +
                " Annual Rate: " + annualRate + " Monthly Fee: " + monthlyFee;
    }
}
