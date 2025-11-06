public class AccountID {
    private String idString;

    public AccountID(String str_id){
        idString = str_id;
    }

    public String toString(){
        return idString;
    }

    public boolean equals(AccountID other){
        return idString.equals(other.toString());
    }
}
