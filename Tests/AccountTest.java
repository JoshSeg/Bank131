import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getBalance1() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 200.00);
        assertTrue(account.getBalance() == 200.00);
    }

    @Test
    void getBalance2() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 615.47);
        assertTrue(account.getBalance() == 615.47);
    }

    @Test
    void getBalance3() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 12750.39);
        assertTrue(account.getBalance() == 12750.39);
    }

    @Test
    void getName1() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 200.00);
        assertTrue(account.getName().equals("Joshua Segura"));
    }

    @Test
    void getName2() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Jessica Ventura", "Checkings", 200.00);
        assertTrue(account.getName().equals("Jessica Ventura"));
    }

    @Test
    void getName3() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Benito Segura", "Checkings", 200.00);
        assertTrue(account.getName().equals("Benito Segura"));
    }

    @Test
    void getId1() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 200.0);
        assertTrue(account.getId().equals(actID));
    }

    @Test
    void getId2() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 200.0);
        assertTrue(account.getId().equals(actID));
    }

    @Test
    void getId3() {
        AccountID actID = new AccountID("Different");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 200.0);
        assertTrue(account.getId().equals(actID));
    }

    @Test
    void testToString1() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 200.0);
        assertTrue(account.toString().equals("Balance: 200.0 AccountID: Testing"));
    }

    @Test
    void testToString2() {
        AccountID actID = new AccountID("Testing");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 615.47);
        assertTrue(account.toString().equals("Balance: 615.47 AccountID: Testing"));
    }

    @Test
    void testToString3() {
        AccountID actID = new AccountID("Different");
        Account account = new Account(actID, "Joshua Segura", "Checkings", 315.92);
        assertTrue(account.toString().equals("Balance: 315.92 AccountID: Different"));
    }
}