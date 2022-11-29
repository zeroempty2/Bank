package repository;

import Bank.account.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import Bank.account.Transaction;

import java.util.HashMap;

public class TransactionInfoRepository
{
    private HashMap transactionDB = new HashMap();

    public void saveTransaction(int accountNumber, Transaction transaction) {
        transactionDB.put(accountNumber, transaction);
    }
    public LocalDate getTransactionList(int id){
        Transaction transaction = (Transaction) transactionDB.get(id);
        LocalDate transactionDateList = null;
        for (TransactionInfoList transactionInfoList : transaction.getTransactionInformationList()) {
            for(TransactionInfo transactionInfo : transactionInfoList.getTransactionInformations()){
                transactionDateList = transactionInfo.getTransactionDate();
            }
        }
        return transactionDateList;
    }
    public void showTransactionList(int id) {
        Transaction transaction = (Transaction) transactionDB.get(id);
            LocalDate transactionDateList = null;
            LocalTime transactionTimeList = null;
            int transactionAmountList = 0;
            int transactionBalanceList = 0;
            String transactionBankList = null;
            String depositWithdrawStatusList = null;

        System.out.println("계좌: " + id );
        System.out.println(" ");
        for (TransactionInfoList transactionInfoList : transaction.getTransactionInformationList()) {
            TransactionInfoList transactionInfoList1 = transactionInfoList;
            for (TransactionInfo transactionInfo : transactionInfoList.getTransactionInformations()) {
                transactionDateList = transactionInfo.getTransactionDate();
                transactionTimeList = transactionInfo.getTransactionTime();
                transactionAmountList = transactionInfo.getTransactionAmount();
                transactionBalanceList = transactionInfo.getTransactionBalance();
                transactionBankList = transactionInfo.getTransactionBankName();
                depositWithdrawStatusList = transactionInfo.getDepositWithdrawStatus();
            }

            System.out.println("거래일자:" + transactionDateList + "  거래시간: " + transactionTimeList);
            System.out.println("거래유형 : " + depositWithdrawStatusList + "  금액: " + transactionAmountList + "  거래은행 :" + transactionBankList + "  잔액 :" + transactionBalanceList);
            System.out.println("");
        }

        }

    public void TransactionListSave(int id,List<TransactionInfo> transactionInfoList ) {
        Transaction transaction = (Transaction) transactionDB.get(id);
        transaction.addTransactionInformationList(transactionInfoList);
    }
    public void updateBalance(int id, int balance){
        Transaction transaction = (Transaction) transactionDB.get(id);
        for (TransactionInfoList transactionInfoList : transaction.getTransactionInformationList()) {
            for(TransactionInfo transactionInfo : transactionInfoList.getTransactionInformations()){
                transactionInfo.setTransactionBalance(balance);
            }
    }
    }
    public void updateDepositWithdrawStatus(int id, String Status){
        Transaction transaction = (Transaction) transactionDB.get(id);
        for (TransactionInfoList transactionInfoList : transaction.getTransactionInformationList()) {
            for(TransactionInfo transactionInfo : transactionInfoList.getTransactionInformations()){
                transactionInfo.setDepositWithdrawStatus(Status);
            }
        }
    }

    public void updateTransactionAmount(int id, int amount){
        Transaction transaction = (Transaction) transactionDB.get(id);
        for (TransactionInfoList transactionInfoList : transaction.getTransactionInformationList()) {
            for(TransactionInfo transactionInfo : transactionInfoList.getTransactionInformations()){
                transactionInfo.setTransactionAmount(amount);
            }
        }
    }
    public void updateTransactionBank(int id, String BankName){
        Transaction transaction = (Transaction) transactionDB.get(id);
        for (TransactionInfoList transactionInfoList : transaction.getTransactionInformationList()) {
            for(TransactionInfo transactionInfo : transactionInfoList.getTransactionInformations()){
                transactionInfo.setTransactionBankName(BankName);
            }
        }
    }
    public void deleteTransaction(int id){
        transactionDB.remove(id);
    }

}


