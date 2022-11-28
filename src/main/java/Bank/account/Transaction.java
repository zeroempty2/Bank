package Bank.account;

import java.util.List;

public class Transaction {
    List<TransactionInfoList> transactionInformationList;

    public Transaction(List<TransactionInfoList> transactionInformationList) {
        this.transactionInformationList = transactionInformationList;
    }

    public List<TransactionInfoList> getTransactionInformationList() {
        return this.transactionInformationList;
    }
    public void addTransactionInformationList(List<TransactionInfo> transactionInfoLists){
        this.transactionInformationList.add(new TransactionInfoList(transactionInfoLists));
    }
}
