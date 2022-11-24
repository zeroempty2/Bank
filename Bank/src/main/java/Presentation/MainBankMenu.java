package Presentation;
/////Presentation Tier/////
//스캐너를 실행시켰을때 첫 화면에 출력되는 부분입니다.
//메뉴리스트라고 생각하시면 됩니다.
import java.util.Scanner;
// 은행 업무 메인 메뉴 입니다.
public class MainBankMenu {
    public MainBankMenu() {
        while (true) {
            System.out.println("이용하실 업무의 번호를 기재하여 주십시오.(Ex. 1)");
            System.out.println("1. 잔액 조회하기");
            System.out.println("2. 입금/출금/송금하기");
            System.out.println("3. 계좌 수정/삭제하기");
            System.out.println("4. 이용 종료하기");
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

            Scanner mainSelect = new Scanner(System.in);
            int mainSelectNum = mainSelect.nextInt();

            switch (mainSelectNum) {
                case 1:
                    FindAccountMenu findAccountMenu = new FindAccountMenu();
                    break;
                case 2:
                    TransferMoneyMenu transferMoneyMenu = new TransferMoneyMenu();
                    break;
                case 3:
                    EditAccountMenu editAccountMenu = new EditAccountMenu();
                    break;
                case 4:
                    System.out.println("이용을 종료합니다");
                    break;

                default:
                    System.out.println("번호만 기재부탁드립니다.(Ex. 1)");
            }
        }
    }
}
