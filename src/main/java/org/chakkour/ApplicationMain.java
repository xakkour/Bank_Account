package org.chakkour;

import org.chakkour.buissness.BankAccountService;
import org.chakkour.buissness.impBankAcc;
import org.chakkour.model.BankAccount;
import org.chakkour.model.CurrentAccount;
import org.chakkour.model.SavingAccount;

import java.util.List;
import java.util.function.Consumer;

public class ApplicationMain {
    public static void main(String[] args) {
        BankAccountService bankAccountService =new impBankAcc() ;
        bankAccountService.addBankAccount(new CurrentAccount("MAD",4501,100));
        bankAccountService.addBankAccount(new SavingAccount("USD",5102,2.6));
        BankAccount bankAccount1=new CurrentAccount("USD",1000000,3250);
        bankAccount1.setAccountId("Oussama_Chakkour");
        bankAccountService.addBankAccount(bankAccount1);
        List<BankAccount> allAccounts= bankAccountService.getAllAccounts();
        // Affichage LIST:

        /*for (int i = 0; i < allAccounts.size(); i++) {
            System.out.println(allAccounts.get(i).toString());
        }*/

        /*for(BankAccount bankAccount:allAccounts){
            System.out.println(bankAccount.toString());
        }*/

     /*   allAccounts.forEach(new Consumer<BankAccount>() {
            @Override
            public void accept(BankAccount account) {
                System.out.println(account.toString());
            }
        });
        //**********  ARROW Function  **************
        allAccounts.forEach((account)->{
            System.out.println(account.toString());
        });*/
        allAccounts.forEach(System.out::println);

        System.out.println("************************************");
        try {
            BankAccount accountById = bankAccountService.getAccountById("Oussama_Chakkour");
            System.out.println("Account Found: "+accountById.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println("*************************************");
        System.out.println("Suite Programme");
    }
}