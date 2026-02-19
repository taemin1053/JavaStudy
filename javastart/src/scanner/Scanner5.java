package scanner;

import java.util.Scanner;
//첫 번째 숫자와 두 번째 숫자를 더해서 출력하는 프로그램, 첫번째 숫자와 두번째 숫자 모르 0을 입력하면 프로그램 종료
public class Scanner5 {
    public static void main(String[] args) {
        System.out.println("첫번째 숫자와 두번째 숫자를 더해서 출력합니다. 두 수를 0을 입력하면 프로그램 종료");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        while(a!=0 && b!=0){
            int c =  a + b;
            System.out.println("첫번째 숫자 + 두번째 숫자 = " + c);
            System.out.println("첫번째 숫자 입력해주세요");
            a = scanner.nextInt();
            System.out.println("두번째 숫자 입력해주세요");
            b = scanner.nextInt();
            if(a==0 && b==0){
                System.out.println("프로그램을 종료합니다.");
            }


        }
    }
}
