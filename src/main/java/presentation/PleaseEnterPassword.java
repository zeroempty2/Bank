package presentation;

import Bank.account.Account;
import Bank.account.AccountServiceApplication;

import java.util.Scanner;

public class PleaseEnterPassword {
    AccountServiceApplication accountService = new AccountServiceApplication();
    public PleaseEnterPassword(Account account) {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("비밀번호를 입력해주세요");
        String inquiryPassword = scanner3.nextLine();
        new FindCollectPassword(account,inquiryPassword);
        }
}

