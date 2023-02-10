package org.chakkour;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.chakkour.model.BankAccount;

import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.chakkour.model.CurrentAccount;
import org.chakkour.model.SavingAccount;

public class App2 {
    public static void main(String[] args) throws JsonProcessingException {





        //------------AFFICHAGE MAP TABLE LIST--------------------


         /*  for (int i = 0; i < account.length ; i++) {
            System.out.println(account[i].toString());

        }*/



        //--------TABLE-----------------
        BankAccount [] accounts= new BankAccount[4];
        accounts[0]=new CurrentAccount("MAD",1258,548);
        accounts[1]=new CurrentAccount("MAD",3520,5441);
        accounts[2]=new SavingAccount("USD",1000,2.85);
        accounts[3]=new CurrentAccount("USD",1500,5481);

        for (BankAccount acc:accounts){
            //Sous Casting

          /*  if (acc instanceof CurrentAccount){
                System.out.println(((CurrentAccount)acc).getType());
            } else if (acc instanceof SavingAccount) {
                System.out.println(((SavingAccount)acc).getType());
            }*/
            // pour Exploit Polymophisme ici:
           System.out.println( acc.getType());

           if(acc instanceof SavingAccount)
                System.out.println("Rate="+((SavingAccount)acc).getIntersetRate());

            if(acc instanceof CurrentAccount){
                System.out.println("Overdraft="+((CurrentAccount)acc).getOverDraft());
            }
        }




        //******************* LIST *****************
        List <BankAccount> bankAccounts=new ArrayList<>();
        bankAccounts.add(new CurrentAccount("USD",522,5684));
        bankAccounts.add(new SavingAccount("USD",5487,2.3));
        bankAccounts.add(new SavingAccount("MAD",2145,2.54));
        bankAccounts.add(new CurrentAccount("USD",1457,2541));
        for (BankAccount acc:bankAccounts){
            System.out.println( acc.getBalance());
        }

        System.out.println("//============= MAP/DICTIONAIRY =================");
        Map<String ,BankAccount >bankAccountMap=new HashMap<>();
        bankAccountMap.put("cc1",new CurrentAccount("USD",8858,5412));
        bankAccountMap.put("cc2",new SavingAccount("MAD",1457,2.3));
        bankAccountMap.put("cc3",new SavingAccount("MAD",7484,2.3));
        bankAccountMap.put("cc4",new SavingAccount("USD",1457,2.3));
        for (String key : bankAccountMap.keySet()) {
            System.out.println(bankAccountMap.get(key));

        }
        System.out.println("--------------------");
        for (BankAccount ba:bankAccountMap.values()){
            System.out.println(toJson(ba));
        }



    }
    // Affichage JSON
    public static String toJson(Object o ) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }
}

