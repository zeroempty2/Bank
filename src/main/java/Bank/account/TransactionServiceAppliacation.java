package Bank.account;
import repository.*;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceAppliacation {
    TransactionInfoRepository transactionInfoRepository = new TransactionInfoRepository();

    public void saveTransaction(int accountNumber,List transaction){
        transactionInfoRepository.saveTransaction(accountNumber, new Transaction(transaction));
    }
    public LocalDate getTransactionList(int id){
        return transactionInfoRepository.getTransactionList(id);
    }
    public void showTransactionList(int id){
        transactionInfoRepository.showTransactionList(id);
    }
    public void showTransactionListTest(int id){
        transactionInfoRepository.showTransactionListTest(id);
    }
    public void TransactionListSave(int id,List<TransactionInfo> transactionInfoList ){
        transactionInfoRepository.TransactionListSave(id,transactionInfoList);
    }
    public void updateBalance(int id, int balance){
        transactionInfoRepository.updateBalance(id, balance);
    }
    public void updateDepositWithdrawStatus(int id, String Status){
        transactionInfoRepository.updateDepositWithdrawStatus(id, Status);
    }
    public void updateTransactionAmount(int id, int amount){
        transactionInfoRepository.updateTransactionAmount(id, amount);
    }
    public void updateTransactionBank(int id, String BankName){
        transactionInfoRepository.updateTransactionBank(id,BankName);
    }
}
