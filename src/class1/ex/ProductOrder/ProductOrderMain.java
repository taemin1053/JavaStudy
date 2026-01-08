package class1.ex.ProductOrder;
import java.util.Scanner;
public class ProductOrderMain {
    public static void main(String[] args){
        int count;
        Scanner scanner = new Scanner(System.in);
        System.out.println("상품의 수량 입력하세요.(중복제외, 예 각휴지 2개 두르마리 휴지 1개 -> 2개 )");
        count = scanner.nextInt();
        scanner.nextLine();
        ProductOrder[] productOrder = new ProductOrder[count];
        System.out.println(productOrder.length);
        for(int i =0; i< productOrder.length; i++){
            productOrder[i] = new ProductOrder();
            System.out.println("상품명을 입력하세요");
            productOrder[i].productName = scanner.nextLine();
            System.out.println("상품의 가격을 입력하세요.");
            productOrder[i].price = scanner.nextInt();
            System.out.println("해당 상품의 개수를 입력하세요.");
            productOrder[i].quantity = scanner.nextInt();
            scanner.nextLine();
        }
        int total = 0;
        for (int i = 0; i < productOrder.length; i++) {
            System.out.println("상품명: "+productOrder[i].productName+ " 가격: "+productOrder[i].price+ " 수량: "+productOrder[i].quantity);
            total += productOrder[i].price * productOrder[i].quantity;
        }

        System.out.println("총 결제 금액: "+ total);
    }
}
