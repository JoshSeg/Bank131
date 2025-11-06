import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @Test
    void fromCSV() {
        String line = "Deposit,ef178,100.0";
        Deposit dp = Deposit.fromCSV(line);
        assertTrue(dp.getAmmount() == 100.0);
        assertTrue(dp.getID().toString().equals("ef178"));
    }

    @Test
    void execute() {
        Bank bank = new Bank(10);
        AccountID actID = new AccountID("ed173938");
        Account act1 = new Account(actID, "Joshua Segura", "Savings",278573.67);
        bank.addAccount(act1);
        Deposit dp = new Deposit(actID, 100.0);
        dp.execute(bank);
        Account test = bank.findAccount(actID);
        assertTrue(test.getBalance() == 278673.67);
    }
}