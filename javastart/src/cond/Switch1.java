package cond;

import java.util.Scanner;

public class Switch1 {
    public static void main(String[] args) {
        System.out.println("회원 등급을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int grade = sc.nextInt();
        int coupon = 0;
        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
                coupon = 2000;
                break;
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
                break;
        }
        System.out.println("발급받은 쿠폰" + " " +coupon);


    }
}
