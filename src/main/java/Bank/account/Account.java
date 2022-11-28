package Bank.account;

import repository.AccountInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Account {
    List<AccountInfo> accountInformations;

    public Account(List<AccountInfo> accountInformations)
    {this.accountInformations = accountInformations;
    }


    public List<AccountInfo> getAccountInfo(){return this.accountInformations;}
}
