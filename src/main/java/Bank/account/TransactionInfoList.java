package Bank.account;

import java.util.List;

public class TransactionInfoList {
    List<TransactionInfo> transactionInformations;

    public TransactionInfoList(List<TransactionInfo> transactionInformations) {
        this.transactionInformations = transactionInformations;
    }

    public List<TransactionInfo> getTransactionInformations() {
        return this.transactionInformations;
    }

}
