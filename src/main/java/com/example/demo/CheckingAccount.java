package com.example.demo;

public class CheckingAccount extends BankAccount {
    private float overdraftLimit;

    public CheckingAccount(float balance, float annualRate, float overdraftLimit) {
        super(balance, annualRate);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void makeDeposit(float amount) {
        if (amount > 0) {
            super.makeDeposit(amount);
        } else {
            System.out.println("Quantity should be greater than 0");
        }
    }

    @Override
    public void withdraw(float amount) {
        if (amount > 0) {
            if (balance - amount >= -overdraftLimit) {
                super.withdraw(amount);
            } else {
                System.out.println("Exceeds overdraft limit.");
            }
        } else {
            System.out.println("Quantity to withdraw should be greater than 0.");
        }
    }

    @Override
    public void applyMonthlyFee() {
        super.applyMonthlyFee();
    }

    @Override
public String printAccount() {
    return super.printAccount() + " Overdraft Limit: " + overdraftLimit + "[Checking Account]";
}

}
