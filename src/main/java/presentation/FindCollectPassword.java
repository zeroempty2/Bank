package presentation;

import Bank.account.Account;
import Bank.account.AccountInfo;

import java.util.Objects;

public class FindCollectPassword {
    public FindCollectPassword(Account account, String password) {
        String listPassword = null;
        for (AccountInfo accountInfo1 : account.getAccountInfo()) {
            listPassword = accountInfo1.getPassword();
        }
        if(Objects.requireNonNull(listPassword).equals(password)){
            String listName = null;
            int listBalance = 0;
            for (AccountInfo accountInfo : account.getAccountInfo()) {
                listBalance = accountInfo.getBalance();
                listName = accountInfo.getName();
            }
            System.out.println(listName+"님의 잔액은 " + listBalance + "원 입니다");
    }
        else{
            System.out.println("비밀번호가 일치하지 않습니다");
        }
    }
}
