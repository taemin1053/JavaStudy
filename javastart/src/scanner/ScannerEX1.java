package scanner;

import java.util.Scanner;

public class ScannerEX1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("이름을 입력해주세요.");
            String name = scanner.nextLine();
            if(name.equals("종료")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println("나이를 입력해주세요.");
            int age = scanner.nextInt();
            System.out.println("사용자님의 이름은 " + name +"이고, 나이는 "+ age+ "입니다.");

        }
    }
}
