package Bank.account;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionInfo {
    protected LocalDate transactionDate;
    protected LocalTime transactionTime;
    protected String depositWithdrawStatus;
    protected int transactionAmount;
    protected String BankName;
    protected int Balance;

    public TransactionInfo() {
        this.transactionDate = LocalDate.now();
        this.transactionTime = LocalTime.now();
        this.depositWithdrawStatus = null;
        this.transactionAmount = 0;
        this.BankName = null;
        this.Balance = 0;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public LocalDate setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
        return transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public LocalTime setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
        return transactionTime;
    }

    public String getDepositWithdrawStatus() {
        return depositWithdrawStatus;
    }

    public void setDepositWithdrawStatus(String depositWithdrawStatus) {
        this.depositWithdrawStatus = depositWithdrawStatus;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionBankName() {
        return BankName;
    }

    public void setTransactionBankName(String bankName) {
        BankName = bankName;
    }
    public int getTransactionBalance(){
        return Balance;
    }

    public void setTransactionBalance(int balance) {
        Balance = balance;
    }


}
