package scanner;

import java.util.Scanner;
public class Scanner5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫 번째 숫자와 두 번째 숫자 모두 0을 입력하면 프로그램을 종료합니다.");
        while (true){
            System.out.println("첫 번째 숫자를 입력하세요");
            int a = scanner.nextInt();

            System.out.println("두 번째 숫자를 입력하세요");
            int b = scanner.nextInt();
            if(a==0 && b==0){
                System.out.println("프로그램을 종료합니다");
                break;
            }
            int sum = a+b;
            System.out.println("두 수의 합: " + sum);
        }
    }
}
