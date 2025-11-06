public class Account {
    private double balance;
    private AccountID id;
    private String ownerName;
    private String accountType;

    public Account(AccountID actID, String name, String actType, double startingBal) {
        id = actID;
        ownerName = name;
        accountType = actType;
        balance = startingBal;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return ownerName;
    }

    public AccountID getId() {
        return id;
    }

    public String getType(){
        return accountType;
    }

    public String toString() {
        return "Balance: " + balance + " " + "AccountID: " + id.toString();
    }

    public static Account makeAccount(String line) {
        String[] tokens = line.split(",");
        if (tokens.length == 4) {
            AccountID id = new AccountID(tokens[1]);
            String name = tokens[2];
            String type = tokens[0];
            double balance = Double.parseDouble(tokens[3]);
            return new Account(id, name, type, balance);
        } else {
            return null;
        }
    }

    public String toCSV(){
        String csv = accountType + "," + id.toString() + "," + ownerName + "," + balance;
        return csv;
    }

    public void credit(double amount) {
        balance += amount;
    }

    public boolean debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }
}