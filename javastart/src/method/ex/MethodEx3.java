package method.ex;
import java.util.Scanner;
public class MethodEx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 10000;
        balance =deposit(balance,1000);
        balance =withdraw(balance,2000);
        System.out.print("최종 잔액: "+balance);
    }
    public static int deposit(int balance,int money){
        balance = balance + money;
        System.out.println(money + "원을 입금하였습니다. 현재 잔액: "+balance);
        return balance;
    }
    public static int withdraw(int balance,int money){
        balance = balance - money;
        System.out.println(money+"원을 출금 하였습니다. 현재 잔액: "+balance);
        return balance;
    }
}
