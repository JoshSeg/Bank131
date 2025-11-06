import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountIDTest {

    @org.junit.jupiter.api.Test
    void testToString1() {
        AccountID actID1 = new AccountID("Testing");
        assertTrue(actID1.toString().equals("Testing"));
    }

    @Test
    void testToString2() {
        AccountID actID1 = new AccountID("Testing");
        assertTrue(!actID1.toString().equals("Wrong"));
    }

    @Test
    void testToString3() {
        AccountID act1ID1 = new AccountID("765test12");
        assertTrue(act1ID1.toString().equals("765test12"));
    }

    @Test
    void testToString4() {
        AccountID act1ID1 = new AccountID("765test12");
        assertTrue(!act1ID1.toString().equals("765test15"));
    }

    @Test
    void testToString5() {
        AccountID actID1 = new AccountID("000912jsegura05");
        assertTrue(actID1.toString().equals("000912jsegura05"));
    }

    @org.junit.jupiter.api.Test
    void testEquals1() {
        AccountID actID1 = new AccountID("Testing");
        AccountID actID2 = new AccountID("Testing");
        assertTrue(actID1.equals(actID2));
    }

    @Test
    void testEquals2() {
        AccountID actID1 = new AccountID("Testing");
        AccountID actID2 = new AccountID("Wrong");
        assertTrue(!actID1.equals(actID2));
    }

    @Test
    void testEquals3() {
        AccountID actID1 = new AccountID("765test12");
        AccountID actID2 = new AccountID("765test12");
        assertTrue(actID1.equals(actID2));
    }

    @Test
    void testEquals4() {
        AccountID actID1 = new AccountID("765test12");
        AccountID actID2 = new AccountID("765test15");
        assertTrue(!actID1.equals(actID2));
    }

    @Test
    void testEquals5() {
        AccountID actID1 = new AccountID("000912jsegura05");
        AccountID actID2 = new AccountID("000912jsegura05");
        assertTrue(actID1.equals(actID2));
    }
}