abstract public class Transaction {
    private AccountID accountId;
    private double amount;
    protected Transaction(AccountID id, double amt){
        accountId = id;
        amount = amt;
    }

    abstract public boolean execute(AccountAccessor accessor);

    protected double getAmmount(){
        return amount;
    }

    protected AccountID getID(){
        return accountId;
    }
}
