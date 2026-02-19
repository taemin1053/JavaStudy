package scanner;
//사용자가 입력한 문자열을 그대로 출력하는 예제를 만들어보자, exit라는 문자가 입력되면 프로그램 종료
import java.util.Scanner;
public class Scanner4 {
    public static void main(String[] args) {
        System.out.println("입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("exit")){
            System.out.println("입력한 값: " + input);
            System.out.println("입력해주세요");
            input = scanner.nextLine();
        }
    }

}
