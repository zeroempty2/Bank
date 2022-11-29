import Bank.account.*;
import presentation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        System.out.println("4ㅏㄹ려조 은행입니다.");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        MainBankMenu mainBankMenu = new MainBankMenu();
        mainBankMenu.run();
        AccountServiceApplication accountService = new AccountServiceApplication();
        TransactionServiceAppliacation transactionService = new TransactionServiceAppliacation();
        while (true) {
            Scanner mainSelect = new Scanner(System.in);
            int mainSelectNum = mainSelect.nextInt();

            switch (mainSelectNum) {
                case 1:
                    Scanner scanner = new Scanner(System.in);
                    List<AccountInfo> accountInformations = new ArrayList<>();
                    List<TransactionInfo> transactionInfos = new ArrayList<>();
                    List<TransactionInfoList> transactionInfoLists = new ArrayList<>();

                    System.out.println("이름을 입력해주세요");
                    String creationname = scanner.nextLine();

                    System.out.println("비밀번호를 입력해 주세요");
                    String password = scanner.nextLine();

                    System.out.println("입금하실 금액을 입력해주세요");
                    int balance = Integer.parseInt(scanner.nextLine());


                    AccountInfo accountInfo = new AccountInfo(creationname, password, balance);
                    accountInformations.add(accountInfo);
                    TransactionInfo transactionInfo = new TransactionInfo();//거래내역 default값 생성
                    transactionInfos.add(transactionInfo);//default값을 List에 담음
                    TransactionInfoList transactionInfoList = new TransactionInfoList(transactionInfos);//default값을 가지고있는 List를 Transaction리스트의 요소로 담음
                    transactionInfoLists.add(transactionInfoList);//transaction을 리스트에 담음


                    accountService.saveAccount(accountService.accountNumberCreate(), accountInformations);
                    transactionService.saveTransaction(accountService.getDBAccountNumberByNameForTransaction(creationname), transactionInfoLists);
                    transactionService.updateBalance(accountService.getDBAccountNumberByNameForTransaction(creationname), balance);
                    transactionService.updateDepositWithdrawStatus(accountService.getDBAccountNumberByNameForTransaction(creationname), "입금(계좌생성)");
                    transactionService.updateTransactionAmount(accountService.getDBAccountNumberByNameForTransaction(creationname), balance);
                    transactionService.updateTransactionBank(accountService.getDBAccountNumberByNameForTransaction(creationname), "이건 4ㅏ기조");
                    System.out.println("계좌가 생성되었습니다");
                    System.out.println(creationname + "님의 계좌번호는" + accountService.getDBAccountNumberByName(creationname) + "입니다");
                    System.out.println("");
                    mainBankMenu.run();
                    break;

                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    if (accountService.findIsEmpty()) {
                        System.out.println("생성된 계좌가 없습니다");
                        mainBankMenu.run();
                        break;
                    } else {
                        System.out.println("이름을 입력해 주세요");
                        String findAccountByName = scanner2.nextLine();
                        if (accountService.findDBAccountNameEmpty(findAccountByName)) {
                            System.out.println("입력하신 이름의 계좌가 없습니다");
                            mainBankMenu.run();
                            break;
                        } else {
                            System.out.println(findAccountByName + "님의 계좌번호는 " + accountService.getDBAccountNumberByName(findAccountByName) + "입니다");
                        }
                    }
                    mainBankMenu.run();
                    break;
                case 3:
                    Scanner scanner3 = new Scanner(System.in);

                    if (accountService.findIsEmpty()) {
                        System.out.println("생성된 계좌가 없습니다");
                        mainBankMenu.run();
                        break;
                    } else {
                        System.out.println("계좌번호를 입력해 주세요");
                        int accountNumber = Integer.parseInt(scanner3.nextLine());
                        if (accountService.findNoAccount(accountNumber)) {
                            System.out.println("존재하지 않는 계좌번호입니다");
                            mainBankMenu.run();
                            break;
                        } else {
                            Account account = accountService.getAccount(accountNumber);
                            new PleaseEnterPassword(account);
                        }
                        mainBankMenu.run();
                        break;
                    }

                case 4:
                    if (accountService.findIsEmpty()) {
                        System.out.println("생성된 계좌가 없습니다");
                    } else {
                        accountService.showAccountList();
                    }
                    mainBankMenu.run();
                    break;

                case 5:
                    Scanner scanner5 = new Scanner(System.in);
                    if (accountService.findIsEmpty()) {
                        System.out.println("생성된 계좌가 없습니다");
                        mainBankMenu.run();
                        break;
                    } else {
                        System.out.println("계좌번호를 입력해 주세요");
                        int deleteAccountNumber = Integer.parseInt(scanner5.nextLine());

                        if (accountService.findNoAccount(deleteAccountNumber)) {
                            System.out.println("존재하지 않는 계좌번호입니다");
                            mainBankMenu.run();
                            break;
                        } else {
                            System.out.println("비밀번호를 입력해주십시오");
                            String deletePassword = scanner5.nextLine();
                            if (accountService.findCollectPassword(deleteAccountNumber, deletePassword)) {
                                accountService.deleteAccount(deleteAccountNumber);
                                transactionService.deleteTransaction(deleteAccountNumber);
                                System.out.println("계좌가 삭제되었습니다.");
                            } else {
                                System.out.println("비밀번호가 일치하지 않습니다");
                                mainBankMenu.run();
                                break;
                            }
                        }
                        mainBankMenu.run();
                        break;
                    }
                case 6:
                    Scanner scanner6 = new Scanner(System.in);
                    if (accountService.findIsEmpty()) {
                        System.out.println("생성된 계좌가 없습니다");
                        mainBankMenu.run();
                        break;
                    } else {
                        System.out.println("계좌번호를 입력해 주세요");
                        int accountNumber = Integer.parseInt(scanner6.nextLine());

                        if (accountService.findNoAccount(accountNumber)) {
                            System.out.println("존재하지 않는 계좌번호입니다");
                            mainBankMenu.run();
                            break;
                        } else {
                            System.out.println("비밀번호를 입력해주십시오");
                            String passwords = scanner6.nextLine();
                            if (accountService.findCollectPassword(accountNumber, passwords)) {
                                System.out.println("현재 계좌의 소유주는 " + accountService.getDBName(accountNumber) + "님 입니다.");
                                System.out.println("변경하실 소유주의 이름을 입력해 주십시오");
                                String name = scanner6.nextLine();
                                accountService.updateName(accountNumber, name);
                                System.out.println("소유주 변경이 완료되었습니다");
                                System.out.println("현재 계좌 " + accountNumber + "의 소유주는 " + accountService.getDBName(accountNumber) + "님 입니다.");
                            } else {
                                System.out.println("비밀번호가 일치하지 않습니다");
                                mainBankMenu.run();
                                break;
                            }
                        }
                        mainBankMenu.run();
                        break;
                    }
                case 7:
                    Scanner scanner11 = new Scanner(System.in);
                    if (accountService.findIsEmpty()) {
                        System.out.println("생성된 계좌가 없습니다");
                        mainBankMenu.run();
                        break;
                    } else {
                        System.out.println("계좌번호를 입력해 주세요");
                        int accountNumber = Integer.parseInt(scanner11.nextLine());

                        if (accountService.findNoAccount(accountNumber)) {
                            System.out.println("존재하지 않는 계좌번호입니다");
                            mainBankMenu.run();
                            break;
                        } else {
                            System.out.println("비밀번호를 입력해주십시오");
                            String passwords = scanner11.nextLine();
                            if (accountService.findCollectPassword(accountNumber, passwords)) {
                                System.out.println("변경하실 비밀번호를 입력해 주십시오");
                                String updatePassword = scanner11.nextLine();
                                accountService.updatePassword(accountNumber, updatePassword);
                                System.out.println("비밀번호 변경이 완료되었습니다");
                            } else {
                                System.out.println("비밀번호가 일치하지 않습니다");
                                mainBankMenu.run();
                                break;
                            }
                        }
                        mainBankMenu.run();
                        break;
                    }

                case 8:
                    Scanner scanner7 = new Scanner(System.in);
                   DepositWithdraw depositWithdraw = new DepositWithdraw();
                   depositWithdraw.run();

                    int seletNumber = mainSelect.nextInt();
                    if (seletNumber == 1) {
                        List<TransactionInfo> transactionInfos3 = new ArrayList<>();
                        if (accountService.findIsEmpty()) {
                            System.out.println("생성된 계좌가 없습니다");
                            mainBankMenu.run();
                            break;
                        } else {
                            System.out.println("계좌번호를 입력해 주세요");
                            int accountNumber = Integer.parseInt(scanner7.nextLine());

                            if (accountService.findNoAccount(accountNumber)) {
                                System.out.println("존재하지 않는 계좌번호입니다");
                                mainBankMenu.run();
                                break;
                            } else {
                                System.out.println("비밀번호를 입력해주십시오");
                                String passwords = scanner7.nextLine();
                                if (accountService.findCollectPassword(accountNumber, passwords)) {
                                    System.out.println("현재 잔액은 " + accountService.getDBBalance(accountNumber) + "원 입니다.");
                                    System.out.println("입금하실 금액을 입력하여 주십시오");
                                    int depositMoney = Integer.parseInt(scanner7.nextLine());
                                    accountService.deposit(accountNumber, depositMoney);
                                    System.out.println("거래하시는 은행을 입력하여 주십시오");
                                    String bankName = scanner7.nextLine();

                                    System.out.println("입금이 완료되었습니다");
                                    System.out.println("현재 잔액은 " + accountService.getDBBalance(accountNumber) + "원 입니다.");

                                    TransactionInfoUpdate transactionInfo3 = new TransactionInfoUpdate("입금", depositMoney, bankName, accountService.getDBBalance(accountNumber));
                                    transactionInfos3.add(transactionInfo3);
                                    transactionService.TransactionListSave(accountNumber, transactionInfos3);

                                } else {
                                    System.out.println("비밀번호가 일치하지 않습니다");
                                    mainBankMenu.run();
                                    break;
                                }
                            }
                            mainBankMenu.run();
                            break;
                        }
                    } else if (seletNumber == 2) {
                        List<TransactionInfo> transactionInfos4 = new ArrayList<>();
                        if (accountService.findIsEmpty()) {
                            System.out.println("생성된 계좌가 없습니다");
                            mainBankMenu.run();
                            break;
                        } else {
                            System.out.println("계좌번호를 입력해 주세요");
                            int accountNumber = Integer.parseInt(scanner7.nextLine());

                            if (accountService.findNoAccount(accountNumber)) {
                                System.out.println("존재하지 않는 계좌번호입니다");
                                mainBankMenu.run();
                                break;
                            } else {
                                System.out.println("비밀번호를 입력해주십시오");
                                String passwords = scanner7.nextLine();
                                if (accountService.findCollectPassword(accountNumber, passwords)) {
                                    System.out.println("현재 잔액은 " + accountService.getDBBalance(accountNumber) + "원 입니다.");
                                    System.out.println("출금하실 금액을 입력하여 주십시오");
                                    int whitdrawMoney = Integer.parseInt(scanner7.nextLine());
                                    if (whitdrawMoney > accountService.getDBBalance(accountNumber)) {
                                        System.out.println("잔액이 부족합니다");
                                        mainBankMenu.run();
                                        break;
                                    } else {
                                        accountService.withdraw(accountNumber, whitdrawMoney);
                                        System.out.println("거래하시는 은행을 입력하여 주십시오");
                                        String bankName = scanner7.nextLine();

                                        TransactionInfoUpdate transactionInfo4 = new TransactionInfoUpdate("출금", whitdrawMoney, bankName, accountService.getDBBalance(accountNumber));
                                        transactionInfos4.add(transactionInfo4);
                                        transactionService.TransactionListSave(accountNumber, transactionInfos4);

                                        System.out.println("출금이 완료되었습니다");
                                        System.out.println("현재 잔액은 " + accountService.getDBBalance(accountNumber) + "원 입니다.");
                                    }
                                } else {
                                    System.out.println("비밀번호가 일치하지 않습니다");
                                    mainBankMenu.run();
                                    break;
                                }
                            }
                            mainBankMenu.run();
                            break;
                        }
                    } else if (seletNumber == 3) {
                        mainBankMenu.run();
                        break;
                    }
                    mainBankMenu.run();
                    break;

                case 9:
                    Scanner scanner8 = new Scanner(System.in);
                    System.out.println("계좌번호를 입력해 주세요");
                    int accountNumber = Integer.parseInt(scanner8.nextLine());

                    transactionService.showTransactionList(accountNumber);

                    mainBankMenu.run();
                    break;

                case 0:
                    System.out.println("이용을 종료합니다");
                    System.exit(0);


                default:
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!!!!!!!!!!!!!잘못된 입력입니다!!!!!!!!!!!!!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }
        }
    }
}