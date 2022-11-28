package repository;
import Bank.account.*;

import java.util.*;


public class AccountInfoRepository {
    private HashMap accountDB = new HashMap();

    public void saveAccount(int accountNumber,Account account) {
        accountDB.put(accountNumber, account);
    }
    public Account getAccount(int id){
        return (Account)this.accountDB.get(id);
    }

    public boolean findNoAccount(int id) {
        if(accountDB.containsKey(id)){
            return false;
        }
        else{
            return true;
        }
    }

    public boolean findIsEmpty() {
        return accountDB.isEmpty();
    }

    public void showAccountList() {
        Iterator accountList = accountDB.keySet().iterator();
        while (accountList.hasNext()) {
            int key = (int) accountList.next();
            Account account = (Account) accountDB.get(key);
            String name = null;
            for (AccountInfo accountInfo1 : account.getAccountInfo()) {
                name = accountInfo1.getName();
            }
            System.out.println("계좌번호 : " + key + " 이름 : " + name);
        }
    }
    public Iterator getAccountList(){
        return accountDB.keySet().iterator();
    }
    public int getDBAccountNumberByNameForTransaction(String name) {
        int accountNumber = 0;
        Iterator accountList = accountDB.keySet().iterator();
        while (accountList.hasNext()) {
            int key = (int) accountList.next();
            Account account = (Account) accountDB.get(key);
            String listName = null;
            for (AccountInfo accountInfo1 : account.getAccountInfo()) {
                listName = accountInfo1.getName();
            }
            if (listName.equals(name)) {
                accountNumber = key;
            }
        }
        return accountNumber;
    }
    public boolean findCollectPassword(int id, String password) {
        Account account = (Account) accountDB.get(id);
        String listPassword = null;
        for (AccountInfo accountInfo1 : account.getAccountInfo()) {
            listPassword = accountInfo1.getPassword();
        }
        return Objects.requireNonNull(listPassword).equals(password);
    }

    public List<Integer> getDBAccountNumberByName(String name) {
        List<Integer>accountNumberList = new ArrayList<>();
        Iterator accountList = accountDB.keySet().iterator();
        while (accountList.hasNext()) {
            int key = (int) accountList.next();
            Account account = (Account) accountDB.get(key);
            String listName = null;
            for (AccountInfo accountInfo1 : account.getAccountInfo()) {
                listName = accountInfo1.getName();
            }
            if (listName.equals(name)) {
                accountNumberList.add(key);
            }
        }
        return accountNumberList;
    }
    public boolean findDBAccountNameEmpty(String name) {
        Iterator accountList = accountDB.keySet().iterator();
        String listName = null;
        while (accountList.hasNext()) {
            int key = (int) accountList.next();
            Account account = (Account) accountDB.get(key);
            for (AccountInfo accountInfo1 : account.getAccountInfo()) {
                listName = accountInfo1.getName();
            }
        }
        if (listName.equals(name)) {
            return false;
        } else {
            return true;
        }
    }
    public String getDBName(int id){
        Account account = (Account) accountDB.get(id);
        String listName = null;
        for (AccountInfo accountInfo1 : account.getAccountInfo()) {
            listName = accountInfo1.getName();
        }
        return listName;
    }

    public int getDBBalance(int id) {
        Account account = (Account) accountDB.get(id);
        int listBalance = 0;
        for (AccountInfo accountInfo : account.getAccountInfo()) {
            listBalance = accountInfo.getBalance();
        }
        return listBalance;
    }
    public void deleteAccount(int id){
        accountDB.remove(id);
    }
    public int deposit(int id, int balance){
        Account account = (Account) accountDB.get(id);
        int listBalance = 0;
        for (AccountInfo accountInfo : account.getAccountInfo()) {
            listBalance = accountInfo.setBalance(accountInfo.getBalance() + balance);
        }
        return listBalance;
    }
    public int withdraw(int id, int balance){
        Account account = (Account) accountDB.get(id);
        int listBalance = 0;
        for (AccountInfo accountInfo : account.getAccountInfo()) {
            listBalance = accountInfo.setBalance(accountInfo.getBalance() - balance);
        }
        return listBalance;
    }
    public String updateName(int id, String name){
        Account account = (Account) accountDB.get(id);
        String listName = null;
        for (AccountInfo accountInfo : account.getAccountInfo()) {
            listName = accountInfo.setName(name);
        }
        return listName;
    }
    public String updatePassword(int id, String password){
        Account account = (Account) accountDB.get(id);
        String listPassword = null;
        for (AccountInfo accountInfo : account.getAccountInfo()) {
            listPassword = accountInfo.setPassword(password);
        }
        return listPassword;
    }
}