package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("상품의 종류 수를 입력해주세요");
        int count = scanner.nextInt();
        scanner.nextLine();
        ProductOrder[] productOrders = new ProductOrder[count];
        for (int i = 0; i < productOrders.length; i++) {
            productOrders[i] = new ProductOrder();
            System.out.println("상품명을 입력해주세요.");
            String productName = scanner.nextLine();
            System.out.println("가격을 입력해주세요");
            int price = scanner.nextInt();

            System.out.print("해당 제품의 수량을 입력해주세요");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            productOrders[i]=createOrder(productName, price, quantity);

        }
        printOrder(productOrders);
        getTotalPrice(productOrders);
    }
    static ProductOrder createOrder(String productName, int price , int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }
    static void printOrder(ProductOrder[] orders) {

        for(int i = 0; i < orders.length; i++){
            System.out.println("상품명: "+orders[i].productName+ " 가격: " + orders[i].price + " 수량: "
                    + orders[i].quantity);
        }
    }
    static void getTotalPrice(ProductOrder[] orders) {
        int totalPrice = 0;
        for(int i = 0; i < orders.length; i++){
            totalPrice += orders[i].price * orders[i].quantity;
        }
        System.out.println("총 결제 구역: " + totalPrice );
    }
}
