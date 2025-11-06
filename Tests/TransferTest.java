import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferTest {

    @Test
    void fromCSV() {
        String line = "Transfer,ef178,100.0,gx550";
        Transfer tr = Transfer.fromCSV(line);
        assertTrue(tr.getAmmount() == 100.0);
        assertTrue(tr.getID().toString().equals("ef178"));
        assertTrue(tr.getToID().toString().equals("gx550"));
    }

    @Test
    void execute() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("ed173938");
        Account act1 = new Account(actID, "Joshua Segura", "Savings",278573.67);
        bank.addAccount(act1);
        AccountID actID2 = new AccountID("po56422");
        Account act2 = new Account(actID2, "Joshua Segura", "Checking",1356.0);
        bank.addAccount(act2);
        Transfer tr = new Transfer(actID, 100.0, actID2);
        tr.execute(bank);
        Account test = bank.findAccount(actID);
        assertTrue(test.getBalance() == 278473.67);
        Account test2 = bank.findAccount(actID2);
        assertTrue(test2.getBalance() == 1456.0);
    }

    @Test
    void failExecute(){
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("ed173938");
        Account act1 = new Account(actID, "Joshua Segura", "Savings",98.0);
        bank.addAccount(act1);
        AccountID actID2 = new AccountID("po56422");
        Account act2 = new Account(actID2, "Joshua Segura", "Checking",1356.0);
        bank.addAccount(act2);
        Transfer tr= new Transfer(actID, 100.0, actID2);
        tr.execute(bank);
        Account test = bank.findAccount(actID2);
        Account test2 = bank.findAccount(actID);
        assertTrue(test.getBalance() == 1356.0);
        assertTrue(!(test.getBalance() == 1456.0));
        assertTrue(test2.getBalance()==98.0);
        assertTrue(!(test2.getBalance() == -2));
    }
}