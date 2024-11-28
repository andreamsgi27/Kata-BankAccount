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
        if (amount > 0) {
            super.makeDeposit(amount);
            deposit++;
        } else {
            System.out.println("Quantity should be greater than 0.");
        }
        checkAccountStatus();
    }

    @Override
    public void withdraw(float amount) {
        if (accIsActive) {
            if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else if (amount > 0) {
                super.withdraw(amount);
                withdrawal++;
            } else {
                System.out.println("Quantity to withdraw should be greater than 0.");
            }
        } else {
            System.out.println("Account is inactive.");
        }
        checkAccountStatus();
    }

    @Override
    public void generateMonthExtract() {
        if (withdrawal > 4) {
            monthlyFee += (withdrawal - 4) * 1000;
        }
        super.generateMonthExtract();
        monthlyFee = 0;
        checkAccountStatus();
    }

    @Override
    public String printAccount() {
        return String.format(
            "[Savings Account]\n" +
            "Balance: %.2f\n" +
            "Consignaciones: %d\n" +
            "Retiros: %d\n" +
            "Tasa Anual: %.2f%%\n" +
            "Comisión Mensual: %.2f\n" +
            "Estado de la cuenta: %s\n" +
            "Total de Transacciones: %d",
            balance,
            deposit,
            withdrawal,
            annualRate,
            monthlyFee,
            accIsActive ? "Activa" : "Inactiva",
            deposit + withdrawal
        );
    }
}
