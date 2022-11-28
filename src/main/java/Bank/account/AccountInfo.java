package Bank.account;

public class AccountInfo {
    private String name;
    private int balance;
    private String password;

    public AccountInfo(String name, String password ,int balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;

    }


    public  String getName(){return name;}
    public int getBalance(){
        return balance;
    }
    public String getPassword(){
        return password;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }

}
