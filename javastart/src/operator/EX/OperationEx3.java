package operator.EX;

import java.util.Scanner;

public class OperationEx3 {
    public static void main(String[] args) {
        int score;
        Scanner sc = new Scanner(System.in); // python-> input(), C++ -> scanf
        score = sc.nextInt();
        boolean result = score >=80 && score <=100;
        System.out.println(result);


    }
}
