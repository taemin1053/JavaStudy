package array.ex;
import java.util.Scanner;
public class ArrayEx2 {
    public static void main(String[] args) {
        int[] numbers =  new int[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("5개의 정수를 입력해주세요");
        for(int i = 0; i<5; i++){
            numbers[i] = scanner.nextInt();
        }
        for(int j=0; j < numbers.length; j++){
            System.out.print(numbers[j]);
            if(j < numbers.length - 1){
                System.out.print(", ");
            }
        }
    }
}
