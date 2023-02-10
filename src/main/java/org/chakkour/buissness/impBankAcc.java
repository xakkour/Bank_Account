package org.chakkour.buissness;

import org.chakkour.Exceptions.AccountnotFoundException;
import org.chakkour.Exceptions.BalanceNotSufficienException;
import org.chakkour.model.AccountStatus;
import org.chakkour.model.BankAccount;
import org.chakkour.model.CurrentAccount;
import org.chakkour.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class impBankAcc implements BankAccountService{
    private List<BankAccount> bankAccountList=new ArrayList<>();


    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountList;
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountnotFoundException {
        return bankAccountList.stream()
                .filter(acc ->acc.getAccountId().equals(id) )
                .findFirst()
                .orElseThrow(()->new AccountnotFoundException(String.format("Bank Account %s not Found by This ID!",id)));


        //Imperative Approach
        /*for (BankAccount bankAccount:bankAccountList){
            if (bankAccount.getAccountId().equals(id)){
                return bankAccount;
            }
        }
        throw new AccountnotFoundException("Bank Account not Found by This ID!");*/
    }

    @Override
    public void addRandomData(int size) {
        BankAccount account;
        AccountStatus[] values=AccountStatus.values();
        Random random=new Random();
        for (int i = 0; i < size; i++) {
            if (Math.random()>0.5){
                account=new CurrentAccount(Math.random()>0.5?"MAD":"USD",Math.random()*1000000,Math.random()*5000);
                account.setStatus(values[random.nextInt(values.length)]);
            }else {
                account=new SavingAccount(Math.random()>0.5?"MAD":"USD",Math.random()*1000000,Math.random()+3);
                account.setStatus(values[random.nextInt(values.length)]);
            }
            bankAccountList.add(account);
        }

    }

    @Override
    public void credit(String accountId, double amount) throws AccountnotFoundException {
        BankAccount accountById= getAccountById(accountId);
        accountById.setBalance(accountById.getBalance()+amount);
    }
    @Override
    public void debit(String accountId, double amount) throws AccountnotFoundException,BalanceNotSufficienException {
        BankAccount accountById= getAccountById(accountId);
        if(amount>accountById.getBalance()) throw new BalanceNotSufficienException("Balance Not Sufficient");

        accountById.setBalance(accountById.getBalance()-amount);

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountnotFoundException, BalanceNotSufficienException {
        debit(accountSource,amount);
        credit(accountDestination,amount);

    }

    @Override
    public double getTotalBalance() {
        return bankAccountList
                .stream()
                .map(account -> account.getBalance())
                .reduce(0.0,(a,v)->a+v);


      /*  double sum=0;
        for (BankAccount acc:bankAccountList){
            sum=sum+ acc.getBalance();
        }
        return sum;*/
    }

    @Override
    public List<BankAccount> searchAccounts(Condition<BankAccount> condition) {
        List<BankAccount> result=new ArrayList<>();
        for (BankAccount acc:bankAccountList){

        if(condition.test(acc)){
            result.add(acc);
        }
    }
        return result;
}}
