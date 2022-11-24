package Bank.account;
///////Application Tier//////
// 거래내역의 속성을 지정해주는 클래스입니다.
//거래내역에 계좌정보의 속성이 들어가야하기 때문에 AccountInfo 클래스를 상속해 주었습니다.
public class AccountTransactionHistory extends AccountInfo{
    String transactionDay;
    String transactionTime;
    int transactionMoney;
    String bankName;

    public AccountTransactionHistory(String name, String accountNumber, int balance, String transactionDay, String transactionTime, int transactionMoney, String bankName) {
        super(name, accountNumber, balance);
        this.transactionDay = transactionDay;
        this.transactionTime = transactionTime;
        this.transactionMoney = transactionMoney;
        this.bankName = bankName;
    }


}

