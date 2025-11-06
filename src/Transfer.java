public class Transfer extends Transaction{
    private AccountID toID;
    public Transfer(AccountID from, double amount, AccountID to){
        super(from, amount);
        toID = to;
    }

    public AccountID getToID(){
        return toID;
    }

    public static Transfer fromCSV(String line){
        String[] tokens = line.split(",");
        if (tokens.length ==4){
            AccountID from = new AccountID(tokens[1]);
            Double  amount = Double.parseDouble(tokens[2]);
            AccountID to = new AccountID(tokens[3]);
            return new Transfer(from, amount, to);
        }
        else {
            return null;
        }
    }

    public boolean execute(AccountAccessor accessor){
        boolean result = false;
        Account accountTo = accessor.findAccount(toID);
        Account accountFrom = accessor.findAccount(getID());

        if (accountTo != null && accountFrom != null){
            if (accountFrom.getBalance() >= getAmmount()){
                accountFrom.debit(getAmmount());
                accountTo.credit(getAmmount());
                result = true;
            }
        }
        return result;
    }
}
