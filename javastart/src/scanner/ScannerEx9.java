package scanner;
import java.util.Scanner;
public class ScannerEx9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요. 입력을 중단하면 -1을 입력하세요.");
        int sum =0;
        int number=0;
        int count = 0;
        while(true){
            number = scanner.nextInt();
            if(number == -1){
                break;
            }
            sum += number;
            count++;
        }
        double average = (double) sum/count;
        System.out.println("입력한 숫자들의 합계: " + sum);
        System.out.println("입력한 숫자들의 평균: " + average);
    }
}
