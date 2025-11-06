import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawalTest {

    @Test
    void fromCSV() {
        String line = "Withdrawal,ef178,100.0";
        Withdrawal wd = Withdrawal.fromCSV(line);
        assertTrue(wd.getAmmount() == 100.0);
        assertTrue(wd.getID().toString().equals("ef178"));
    }

    @Test
    void execute() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("ed173938");
        Account act1 = new Account(actID, "Joshua Segura", "Savings",278573.67);
        bank.addAccount(act1);
        Withdrawal wd = new Withdrawal(actID, 100.0);
        wd.execute(bank);
        Account test = bank.findAccount(actID);
        assertTrue(test.getBalance() == 278473.67);
    }

    @Test
    void failExecute(){
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("ed173938");
        Account act1 = new Account(actID, "Joshua Segura", "Savings",98);
        bank.addAccount(act1);
        Withdrawal wd = new Withdrawal(actID, 100.0);
        wd.execute(bank);
        Account test = bank.findAccount(actID);
        assertTrue(test.getBalance() == 98);
        assertTrue(!(test.getBalance() == -2));
    }
}