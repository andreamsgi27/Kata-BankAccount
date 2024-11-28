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
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Quantity should be greater than 0");
        }
    }

    public void withdraw(float amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else if (amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Quantity to withdraw should be greater than 0.");
        }
    }

    public void applyMonthlyFee() {
        balance -= monthlyFee;
    }

    public void calcMonthlyInterest() {
        float monthlyInterest = (balance * annualRate) / 12;
        balance += monthlyInterest;
    }

    public void generateMonthExtract() {
        applyMonthlyFee();
        calcMonthlyInterest();
    }

    public String printAccount() {
        return "Balance: " + balance + " Deposit: " + deposit + " Withdrawal: " + withdrawal +
                " Annual Rate: " + annualRate + " Monthly Fee: " + monthlyFee;
    }
}
