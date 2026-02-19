package array.ex;
import java.util.Scanner;
public class ArrayEx8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice= 0;
        int max =10;
        String[] productNames = new String[max];
        int[] productPrices = new int[max];
        int productCount = 0;
        while(choice != 3){
            System.out.println("1. 상품 등록 | 2. 상품 목록 | 3. 종료");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    if(productCount==max){
                        System.out.println("더 이상 상품을 등록할 수 없습니다.");
                        break;
                    }
                    System.out.print("상품 이름을 입력하세요: ");
                    productNames[productCount] = scanner.nextLine();

                    System.out.print("상품 가격을 입력하세요: ");
                    productPrices[productCount] = scanner.nextInt();
                    scanner.nextLine();
                    productCount++;
                    break;
                case 2:
                    if(productCount ==0){
                        System.out.println("등록된 상품이 없습니다.");
                        break;
                    }
                    for(int i=0; i<productCount; i++){
                        System.out.println(productNames[i]+": "+productPrices[i]+"원");
                    }
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다");
                    break;

                default:
                    System.out.println("잘못 선택했습니다.");
                    break;
            }

        }


    }
}
