package Presentation;
/////Presentation Tier/////
// UserInterface에서 각 번호를 호출했을때 나와야하는 화면입니다.

import java.util.Scanner;

public class FindAccountMenu {

    public FindAccountMenu() {
        while (true) {
            System.out.println("계좌를 찾을 방식을 선택하여 주십시오.(Ex. 1)");
            System.out.println("1. 계좌번호로 찾기 ");
            System.out.println("2. 소유자 명으로 찾기");
            System.out.println("3. 이전 메뉴로 돌아가기");
            System.out.println("4. 이용 종료하기");
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            FindAccount findAccount = new FindAccount();

            Scanner memoListScanner = new Scanner (System.in);
            int memoListAnswer = memoListScanner.nextInt();

            switch (memoListAnswer) {
                case 1:
                    findAccount.findAccountByNumber();
                    break;
                case 2:
                    findAccount.findAccountByName();
                    break;
                case 3:
                    MainBankMenu mainBankMenu = new MainBankMenu();
                    break;
                case 4:
                    System.out.println("이용을 종료합니다");
                    break;
                default:
                    System.out.println("번호만 기재부탁드립니다.(Ex. 1)");
                    break;
            }
        }
    } // 계좌확인 메뉴

}