package cond;

import java.util.Scanner;

public class CondEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        String grade = switch (score/10){
            case  10,9 -> "A";
            case  8 -> "B";
            case  7 -> "C";
            case  6 -> "D";
            default -> "F";
        };
        System.out.println("score: " +score);
        System.out.println("학점은 " +grade);
    }
}
