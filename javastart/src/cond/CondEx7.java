package cond;

import java.util.Scanner;

public class CondEx7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String s = x % 2 ==0 ? "짝수": "홀수";
        System.out.println(s);
    }
}
