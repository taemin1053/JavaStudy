package scanner;
import java.util.Scanner;
public class Scanner4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("문자열을 입력하세요(exit)");
            String input = scanner.nextLine();
            System.out.println("입력한 문자열: " + input);
            if(input.equals("exit")){
                break;
            }
        }
    }
}
