package method.ex;
import java.util.Scanner;
public class MethodEx4 {
    public static void main(String[] args) {
        int balance =0;
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4){
            System.out.println("---------------------------------");
            System.out.println("1.입금 | 2.출금 | 3.잔액 확인 | 4.종료");
            System.out.println("---------------------------------");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.print("입금액을 입력하세요: ");
                    int inputmoney = scanner.nextInt();
                    balance = deposit(balance, inputmoney);
                    break;
                case 2:
                    System.out.print("출금액을 입력하세요: ");
                    int removemoney = scanner.nextInt();
                    balance = withdraw(balance, removemoney);
                    break;
                case 3:
                    System.out.println("현재 잔액: "+balance);
                    break;
                case 4:
                    System.out.println("시스템을 종료합니다.");
                    return;
            }
        }
    }
    public static int deposit(int balance,int money){

        balance = balance + money;
        System.out.println(money+"원을 입금하였습니다. 현재잔액: "+balance);
        return balance;
    }
    public static int withdraw(int balance,int money){
        if(balance >= money){
            balance = balance - money;
            System.out.println(money+"원을 출금하였습니다. 현재 잔액: "+balance);
        }
        else{
            System.out.println(money+"원을 출금하려 했으나 잔액이 부족합니다.");
        }
        return balance;
    }
}
