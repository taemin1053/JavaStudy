package scanner;

import java.util.Scanner;

public class ScannerEx10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hap = 0;
        int sum = 0;
        while (true) {
            System.out.println("1:상품 입력, 2: 결재, 3: 프로그램 종료");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.print("상품명을 입력하세요");
                    String name = scanner.nextLine();
                    System.out.print("상품의 가격을 입력하세요");
                    int price =scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("구매 수량을 입력하세요");
                    int count = scanner.nextInt();
                    scanner.nextLine();
                    hap += price*count;
                    System.out.println("상품명: " + name + " 가격: " + price + " 합계: "+ hap );
                    break;
                case 2:
                    sum += hap;
                    System.out.println("총 비용: " +sum);
                    hap= 0;
                    sum = 0;
                    break;
                case 3:
                    System.out.print("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("올바른 번호를 입력하세요");
                    break;
            }
        }
    }
}
