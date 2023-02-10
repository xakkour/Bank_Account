package org.chakkour.model;

public final class SavingAccount extends BankAccount{
    private double IntersetRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(String currency, double initialBalance, double intersetRate) {
        super(currency, initialBalance);
        this.IntersetRate = intersetRate;
    }
    @Override
    public String getType() {
        return "Saving_Account";
    }

    public double getIntersetRate() {
        return IntersetRate;
    }

    public void setIntersetRate(double intersetRate) {
        IntersetRate = intersetRate;
    }
}
