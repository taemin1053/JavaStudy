package scanner;
import java.util.Scanner;
public class ScannerEx3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("음식 이름을 입력해주세요");
        String foodName = scanner.nextLine();
        System.out.println("음식의 가격을 입력해주세요");
        int foodPrice = scanner.nextInt();
        System.out.println("음식의 수량을 입력해주세요");
        int foodCount = scanner.nextInt();
        System.out.println(foodName + " " + foodCount + "개를 주문하셨습니다. " +"총 가격은 "+ foodPrice+"원입니다." );
    }

}
