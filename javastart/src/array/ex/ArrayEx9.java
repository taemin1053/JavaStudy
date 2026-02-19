package array.ex;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayEx9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> productPrices = new ArrayList<>();
        ArrayList<String> productNames = new ArrayList<>();

        while(true){
            System.out.println(" 1. 상품 등록 | 2. 상품 목록 | 3. 종료");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    if(productPrices.size() == 10){
                        System.out.println("더 이상 상품을 등록할 수 없습니다.");
                        break;
                    }
                    System.out.print("상품 이름을 입력하세요:");
                    String name = sc.nextLine();
                    System.out.print("상품 가격을 입력하세요");
                    int price = sc.nextInt();

                    productNames.add(name);
                    productPrices.add(price);
                    break;
                case 2:
                    if(productPrices.isEmpty()){
                        System.out.println("등록된 상품이 없습니다");
                        break;
                    }
                    for(int i=0;i<productNames.size();i++){
                        System.out.println(productNames.get(i)+": "+productPrices.get(i)+"원");
                    }
                    break;
                case 3:
                    System.out.print("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력했습니다.");
                    break;
            }
        }
    }
}
