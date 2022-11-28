package Bank.account;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionInfoUpdate extends TransactionInfo{
    public TransactionInfoUpdate(String depositWithdrawStatus,int transactionAmount,String BankName,int Balance) {
        this.depositWithdrawStatus = depositWithdrawStatus;
        this.transactionAmount = transactionAmount;
        this.BankName = BankName;
        this.Balance = Balance;
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalTime.now();
    }
}
