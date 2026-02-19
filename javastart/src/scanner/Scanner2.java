package scanner;

import java.util.Scanner;

//두 수를 입력받고 그 합을 출력하는 예제
public class Scanner2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a  = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println("sum = " + sum);
    }
}
