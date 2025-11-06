import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bank implements AccountAccessor{
    private Account[] accountList;
    public Bank(int maxSize){
        accountList = new Account[maxSize];
    }

    public boolean addAccount(Account newAccount){
        for (int i = 0; i < accountList.length; i++){
            if (accountList[i] == null){
                accountList[i] = newAccount;
                return true;
            }
        }
        return false;
    }

    public Account findAccount(AccountID id){
        for (int i = 0; i < accountList.length; i++){
            if (accountList[i].getId().equals(id)){
                return accountList[i];
            }
        }
        return null;
    }

    public int getCount(){
        int count = 0;
        for (int i = 0; i < accountList.length; i++){
            if (accountList[i] != null){
                count++;
            }
        }
        return count;
    }

    public Account[] getList(){
        return accountList;
    }

    public boolean loadAccount(String fileName){
        Boolean result = false;
        File file = new File(fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Account act = Account.makeAccount(line);
                addAccount(act);
                result = true;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean toCSV(String fileName){
        Boolean result = false;
        File file = new File(fileName);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
                for (int i = 0; i < accountList.length; i++){
                    if (accountList[i] != null){
                        String line =  accountList[i].toCSV();
                        writer.write(line);
                        writer.write("\n");
                    }
                }
                result = true;
                writer.close();
        }
        catch (IOException ex){
        }
        return result;
    }

    public static int countLines(String fileName){
        File file = new File(fileName);
        int count = 0;
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                count++;
            }
        }
        catch (FileNotFoundException ex){
            throw new RuntimeException(ex);

        }
        return count;
    }

    public Transaction[] loadTransactions(String fileName){
        int listSize = countLines(fileName);
        Transaction[] transactions;
        File file = new File(fileName);
        try{
            Scanner sc = new Scanner(file);
            transactions = new Transaction[listSize];
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String [] tokens = line.split(",");
                Transaction newTr = null;
                if (tokens[0].equals("Deposit")){
                    newTr = Deposit.fromCSV(line);
                }
                else if (tokens[0].equals("Withdrawal")){
                    newTr = Withdrawal.fromCSV(line);
                }
                else if (tokens[0].equals("Transfer")){
                    newTr = Transfer.fromCSV(line);
                }

                if (newTr != null){
                   for  (int i = 0; i < transactions.length; i++){
                       if (transactions[i] == null){
                           transactions[i] = newTr;
                           break;
                       }
                   }
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    public boolean execute(Transaction[] transactions){
        int didCount = 0;
        boolean result = false;
        for (int i =0; i < transactions.length; i++){
            if(transactions[i] != null) {
                Account acct = findAccount(transactions[i].getID());
                if(acct != null){
                    if (transactions[i].execute(this)){
                        didCount++;
                    }
                }
                else {
                    //error
                }
            }
        }
        if (didCount == transactions.length){
            result = true;
        }
        return result;
    }


   // public class TransactionList{
     //   private Transaction[] transactionList;
       // private int iterationIndex;

//        public boolean addTransaction(Transaction trs){
  //          boolean result = false;
    //        for (int i = 0; i < transactionList.length; i++){
      //          if (transactionList[i] == null){
        //            transactionList[i] = trs;
          //          result = true;
            //    }
              //  else{
                //    result = false;
              //  }
          //  }
           // return result;
       // }

      //  public void init(){
      //      iterationIndex = -1;
     //   }

       // public Transaction next(){
       //     if(iterationIndex < transactionList.length-1 && transactionList[iterationIndex] != null){
       //         iterationIndex++;
       //         return transactionList[iterationIndex];
        //    }
         //   else {
          //      iterationIndex++;
           //     return null;
          //  }

      //  }
  //  }
}
