public class Withdrawal extends Transaction{
    public Withdrawal(AccountID id, double amount){
        super(id, amount);
    }

    public static Withdrawal fromCSV(String line){
        String[] tokens = line.split(",");
        if (tokens.length == 3){
            AccountID id = new AccountID(tokens[1]);
            double amount = Double.parseDouble(tokens[2]);
            return new Withdrawal(id, amount);
        }
        else {
            return null;
        }
    }

    public boolean execute(AccountAccessor accessor){
        Account account = accessor.findAccount(getID());

        if(account != null){
            if(account.getBalance() >= getAmmount()){
                account.debit(getAmmount());
                return true;
                //Audit
            }
            else{
                return false;
                //Audit-error
            }
        }
        else{
            return false;
        }
    }
}
