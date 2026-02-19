package scanner;

import java.util.Scanner;

public class Scanner3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int max = a > b ? a: b;
        System.out.println(max);
        if( a==b){
            System.out.println("두수가 같습니다.");
        }
    }
}
