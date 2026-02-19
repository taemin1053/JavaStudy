package cond;

import java.util.Scanner;

public class Switch2 {
    //java 14 Switch update

    public static void main(String[] args) {
        System.out.println("회원등급을 입력해주세요");
        Scanner sc = new Scanner(System.in);
        int grade = sc.nextInt();
        int coupon = switch (grade){
            case 1 -> 1000;
            case 2 -> 2000;
            case 3 -> 3000;
            default -> 500;
        };
        System.out.println("발급받은 쿠폰 " + coupon);
    }
}
