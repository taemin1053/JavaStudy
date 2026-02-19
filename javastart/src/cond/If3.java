package cond;

import java.util.Scanner;

public class If3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age >= 20){
            System.out.println("성인");
        }
        else if(19>=age && age >=17) {
            System.out.println("고등학생");
        }
        else if (16>=age && age >=14) {
            System.out.println("중학생");
        }
        else if (13>=age && age >=8) {
            System.out.println("초등학생");
        }
        else{
            System.out.println("미취학");
        }
    }
}
