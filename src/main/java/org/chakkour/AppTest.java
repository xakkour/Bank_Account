package org.chakkour;

import org.chakkour.Exceptions.AccountnotFoundException;
import org.chakkour.Exceptions.BalanceNotSufficienException;
import org.chakkour.Utils.DataFormatUtils;
import org.chakkour.buissness.BankAccountService;
import org.chakkour.buissness.impBankAcc;
import org.chakkour.model.AccountStatus;
import org.chakkour.model.BankAccount;
import org.chakkour.model.CurrentAccount;

import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new impBankAcc();
        bankAccountService.addRandomData(20);
        BankAccount bankAccount1=new CurrentAccount("USD",1000000,3250);
        bankAccount1.setAccountId("Oussama_Chakkour");
        //Affichage Table
        /*bankAccountService.getAllAccounts()
                .stream()
                .map(DataFormatUtils::ToJson)
                .forEach(System.out::println);*/
        //Find Account
        bankAccountService.addBankAccount(bankAccount1);
        try {

            BankAccount account = bankAccountService.getAccountById("Oussama_Chakkour");
            System.out.println(DataFormatUtils.ToJson(account));

            System.out.println("#########Affiche #################");
            bankAccountService.debit(account.getAccountId(),860);
            System.out.println(DataFormatUtils.ToJson(account));

        } catch (AccountnotFoundException | BalanceNotSufficienException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("--********Total Balance ****************");
        System.out.println(bankAccountService.getTotalBalance());
        System.out.println("--********   Searching  ****************");
        List<BankAccount> bankAccountsList = bankAccountService.searchAccounts(acc -> acc.getStatus().equals(AccountStatus.BLOCKED));
        bankAccountsList.stream().map(DataFormatUtils::ToJson).forEach(System.out::println);
    }
}
