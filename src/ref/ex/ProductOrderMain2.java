package ref.ex;

import java.util.Scanner;

public class ProductOrderMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count =0;

        System.out.println("입력합 주문의 개수를 입력하세요");
        count = scanner.nextInt();
        scanner.nextLine();
        ProductOrder[] Order = new ProductOrder[count];
        for(int i = 0; i< Order.length; i++){
            System.out.println(i+1+"번째 주문 정보를 입력하세요.");
            System.out.print("상품명: ");
            String name = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Order[i] = createProductOrder(name,price, quantity);

        }
        printProductOrder(Order);
        System.out.println("총 가격: " + getTotal(Order));
    }
    static ProductOrder createProductOrder(String name, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = name;
        order.price = price;
        order.quantity = quantity;
        return order;
    }
    static void printProductOrder(ProductOrder[] productOrder) {
        for(int i =0; i< productOrder.length; i++){
        System.out.println("상품명: "+ productOrder[i].productName+" 가격: "+productOrder[i].price+" 수량: "+productOrder[i].quantity);
        }
    }

    static  int getTotal(ProductOrder[] productOrder) {
        int total = 0;
        for(int i =0; i < productOrder.length; i++){
            total += productOrder[i].price*productOrder[i].quantity;
        }

        return total;
    }
}
