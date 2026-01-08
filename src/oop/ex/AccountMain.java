package oop.ex;

import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        boolean run = true;
        while(run){
            System.out.println("----1.입급----2.출금----3.종료");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.println("입급할 금액을 입력하세요");
                    int amount = scanner.nextInt();
                    account.deposit(amount);
                    break;
                case 2:
                    System.out.println("출금할 금액을 입력하세요.");
                    amount = scanner.nextInt();
                    account.withdraw(amount);
                    break;
                case 3:
                    account.exit();
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");

            }
        }
    }
}
