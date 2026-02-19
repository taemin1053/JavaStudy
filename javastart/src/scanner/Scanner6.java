package scanner;

import java.util.Scanner;
public class Scanner6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.println("정수를 입력하세요(0 입력시 종료)");
        int a = scanner.nextInt();
        while(a!=0){
            sum += a;
            System.out.println("입력한 모든 정수의 합: " + sum);
            System.out.println("정수를 입력하세요 ");
            a = scanner.nextInt();
        }
    }
}
