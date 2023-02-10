package org.chakkour;

import org.chakkour.model.BankAccount;
import org.chakkour.model.CurrentAccount;
import org.chakkour.model.SavingAccount;

public class App {
    public static void main(String[] args) {

        BankAccount account1=null;
        account1=new CurrentAccount ();
        // account1.setAccountId("123-543");
        account1.setCurrency("MAD");
        account1.setBalance(7600);

        BankAccount account2=new CurrentAccount("MAD",1245,1450);
        BankAccount account3=new SavingAccount("USD",1000,3.5);
        PrintAccount(account1);
        PrintAccount(account2);







    }
    public  static void PrintAccount(BankAccount account){
        System.out.println("******************************");
        System.out.println("Account ID="+account.getAccountId());
        System.out.println("Balance ="+account.getBalance());
        System.out.println("Status="+account.getStatus());
        System.out.println("Currency ="+account.getCurrency());
        System.out.println("******************************");

    }
}