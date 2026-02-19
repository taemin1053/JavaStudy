package cond;

import java.util.Scanner;

public class CondEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();
        System.out.println("distance: " + distance);
        if (distance <= 1){
            System.out.println("도보를 이용하세요.");
        } else if (distance <= 10){
            System.out.println("자건거를 이용하세요");
        } else if (distance <= 100){
            System.out.println("자동차를 이용하세요");
        } else{
            System.out.println("비행기를 이용하세요");
        }
    }
}
