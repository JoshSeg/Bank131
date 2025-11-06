public class Deposit extends Transaction{
    public Deposit(AccountID id, double amount){
        super(id, amount);
    }

    public static Deposit fromCSV(String line){
        String[] tokens = line.split(",");
        if (tokens.length == 3){
            AccountID id = new AccountID(tokens[1]);
            double amount = Double.parseDouble(tokens[2]);
            return new Deposit(id, amount);
        }
        else {
            return null;
        }
    }

    public boolean execute(AccountAccessor accessor){
        Account account = accessor.findAccount(getID());
        if (account != null){
            account.credit(getAmmount());
            return true;
            //Audit
        }
        return false;
    }
}
