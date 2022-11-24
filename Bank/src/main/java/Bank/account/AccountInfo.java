package Bank.account;
/////Application Tier/////
// 계좌정보의 속성을 지정해주는 클래스입니다.
public class AccountInfo {
    private String name;
    private String accountNumber;
    private int balance;

    public AccountInfo(String name, String accountNumber, int balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

}
