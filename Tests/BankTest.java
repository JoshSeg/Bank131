import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void addAccount1() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 315.92);
        bank.addAccount(account);
        Account[] list = bank.getList();
        assertTrue(list[0].getId().equals(actID));
    }

    @Test
    void addAccount2() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 315.92);
        bank.addAccount(account);
        AccountID actID2 = new AccountID("Testing2");
        Account accound2 = new Account(actID2, "Jessica Ventura", "Checkings", 315.92);
        bank.addAccount(accound2);
        Account[] list = bank.getList();
        assertTrue(list[0].getId().equals(actID));
        assertTrue(list[1].getId().equals(actID2));
    }

    @Test
    void findAccount1() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 315.92);
        bank.addAccount(account);
        assertTrue(bank.findAccount(actID).getId().equals(account.getId()));
    }

    @Test
    void findAccount2() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 315.92);
        bank.addAccount(account);
        AccountID actID2 = new AccountID("Testing2");
        Account account2 = new Account(actID2, "Jessica Ventura", "Checkings", 67.69);
        bank.addAccount(account2);
        AccountID actID3 = new AccountID("Testing3");
        Account account3 = new Account(actID3, "Benito Segura", "Checkings", 27.54);
        bank.addAccount(account3);
        assertTrue(bank.findAccount(actID).getId().equals(account.getId()));
    }

    @Test
    void getCount1() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 315.92);
        bank.addAccount(account);
        assertTrue(bank.getCount() == 1);
    }

    @Test
    void getCount2() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 315.92);
        bank.addAccount(account);
        AccountID actID2 = new AccountID("Testing2");
        Account account2 = new Account(actID2, "Jessica Ventura", "Checkings", 67.69);
        bank.addAccount(account2);
        AccountID actID3 = new AccountID("Testing3");
        Account account3 = new Account(actID3, "Benito Segura", "Checkings", 27.54);
        bank.addAccount(account3);
        assertTrue(bank.getCount() == 3);
    }


    @Test
    void loadAccount() {
        Bank bank = new Bank(10);
        bank.loadAccount("loadAccounts.csv");
        Account[] list = bank.getList();
        assertTrue(bank.getCount()==3);
        AccountID actID = new AccountID("ed173938");
        assertTrue(list[0].getId().equals(actID));
    }

    @Test
    void toCSV(){
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("ed173938");
        Account act1 = new Account(actID, "Joshua Segura", "Checking",278973.67);
        bank.addAccount(act1);
        AccountID actID2 = new AccountID("pk278103");
        Account act2 = new Account(actID2, "Jessica Ventura", "Savings", 178926.69);
        bank.addAccount(act2);
        bank.toCSV("writeAccounts.csv");
        Bank bank2 = new Bank(10);
        bank2.loadAccount("writeAccounts.csv");
        Account[] list = bank2.getList();
        assertTrue(bank2.getCount()==2);
        assertTrue(list[0].getId().equals(actID));
        assertTrue(list[1].getId().equals(actID2));
    }


    @Test
    void loadTransactions() {
        Bank bank = new Bank(10);
        Transaction[] tList = bank.loadTransactions("loadTransactionsCSVTest.csv");
        Transaction dp = tList[0];
        Transaction wd = tList[1];
        Transaction tf = tList[2];
        assertTrue(dp.getID().toString().equals("ex598"));
        assertTrue(dp.getAmmount() == 100.0);
        assertTrue(wd.getID().toString().equals("gx550"));
        assertTrue(wd.getAmmount() == 268.64);
        assertTrue(tf.getID().toString().equals("pk095"));
        assertTrue(tf.getAmmount() == 125.0);
    }

    @Test
    void executeTransactions(){
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("ex598");
        Account act1 = new Account(actID, "Joshua Segura", "Checkings", 278873.67);
        bank.addAccount(act1);
        AccountID actID2 = new AccountID("gx550");
        Account act2 = new Account(actID2, "Jessica Ventura", "Savings", 178926.69);
        bank.addAccount(act2);
        AccountID actID3 = new AccountID("pk095");
        Account act3 = new Account(actID3, "Benito Segura", "Savings", 467.21);
        bank.addAccount(act3);
        AccountID actID4 = new AccountID("ty783");
        Account act4 = new Account(actID4, "Benito Segura", "Checkings", 45.82);
        bank.addAccount(act4);
        Transaction[] tList = bank.loadTransactions("loadTransactionsCSVTest.csv");
        bank.execute(tList);
        Account test1 = bank.findAccount(actID);
        Account test2 = bank.findAccount(actID2);
        Account test3 = bank.findAccount(actID3);
        Account test4 = bank.findAccount(actID4);
        assertTrue(test1.getBalance() == 278973.67);
        assertTrue(test2.getBalance() == 178658.05);
        assertTrue(test3.getBalance() == 342.21);
        assertTrue(test4.getBalance() == 170.82);
    }


}