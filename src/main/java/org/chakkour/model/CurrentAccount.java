package org.chakkour.model;

public class CurrentAccount extends BankAccount  {
    private double overDraft;

    public CurrentAccount()  {
        super();
        this.overDraft = overDraft;
    }

    public CurrentAccount(String currency, double initialBalance, double overDraft) {
        super(currency, initialBalance);
        this.overDraft = overDraft;
    }

    @Override
    public String toString() {
        return "Current Account ,OverDraft= "+overDraft+super.toString();
    }

    @Override
    public String getType() {
        return "Current_Account";
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }
}
