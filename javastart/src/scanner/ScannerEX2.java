package scanner;

import java.util.Scanner;
public class ScannerEX2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a==0){
            System.out.println("0입니다.");
        }else if(a % 2==0){
            System.out.println("짝수입니다.");
        }
        else{
            System.out.println("홀수입니다.");
        }
    }
}
