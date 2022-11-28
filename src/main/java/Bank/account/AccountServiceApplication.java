package Bank.account;
import repository.*;

import java.util.List;

public class AccountServiceApplication {
    private final AccountInfoRepository accountInfoRepository = new AccountInfoRepository();
    public AccountNumberCreate accountNumberCreate = new AccountNumberCreate();

    public void saveAccount(int accountNumber, List accountInformations) {
        accountInfoRepository.saveAccount(accountNumber, new Account(accountInformations));
    }
    public int accountNumberCreate(){
        return accountNumberCreate.accountNumberCreateRandom();
    }
    public boolean findIsEmpty(){
        return accountInfoRepository.findIsEmpty();
    }
    public boolean findNoAccount(int id){
        return accountInfoRepository.findNoAccount(id);
    }
    public boolean findCollectPassword(int id, String password){
        return accountInfoRepository.findCollectPassword(id, password);
    }
    public void showAccountList(){
        accountInfoRepository.showAccountList();
    }

    public String getDBName(int id){
        return accountInfoRepository.getDBName(id);
    }

    public int getDBBalance(int id){
        return accountInfoRepository.getDBBalance(id);
    }

    public List<Integer> getDBAccountNumberByName (String name){
        return  accountInfoRepository.getDBAccountNumberByName(name);
    }
    public boolean findDBAccountNameEmpty(String name){
        return accountInfoRepository. findDBAccountNameEmpty(name);
    }

    public void deleteAccount(int id){
        accountInfoRepository.deleteAccount(id);
    }
    public void deposit(int id, int balance){
        accountInfoRepository.deposit(id, balance);
    }
    public void withdraw(int id, int balace){
        accountInfoRepository.withdraw(id, balace);
    }
    public void updateName(int id, String name){
        accountInfoRepository.updateName(id, name);
    }
    public String updatePassword(int id, String password) {
        return accountInfoRepository.updatePassword(id, password);
    }

    public int getDBAccountNumberByNameForTransaction(String name){
        return accountInfoRepository.getDBAccountNumberByNameForTransaction(name);
    }
    public Account getAccount(int id){
        return accountInfoRepository.getAccount(id);
    }


}

