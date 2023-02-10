package org.chakkour.buissness;

import org.chakkour.Exceptions.AccountnotFoundException;
import org.chakkour.Exceptions.BalanceNotSufficienException;
import org.chakkour.model.BankAccount;

import java.util.List;

public interface BankAccountService {
         BankAccount addBankAccount(BankAccount account);
        List<BankAccount> getAllAccounts();
        BankAccount getAccountById(String id) throws AccountnotFoundException;
        void addRandomData(int size);
        void credit(String accountId, double amount) throws AccountnotFoundException;
        void debit(String accountId, double amount) throws AccountnotFoundException, BalanceNotSufficienException;
        void transfer(String accountSource, String accountDestination, double amount) throws AccountnotFoundException, BalanceNotSufficienException;

        public double getTotalBalance();
        List<BankAccount> searchAccounts(Condition<BankAccount> condition);


        }
