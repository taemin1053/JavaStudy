package oop.ex;

import java.util.Scanner;

public class RectangleProceduralMain {
    public static void main(String[] args) {
        RectangleProcedural Rect = new RectangleProcedural();
        Scanner scanner = new Scanner(System.in);
        System.out.println("너비를 입력해주세요");
        Rect.width = scanner.nextInt();
        scanner.nextLine();
        System.out.println("높이를 입력해주세요");
        Rect.height = scanner.nextInt();
        int area = Rect.calculateArea();
        System.out.println("넓이: " + area);
        int perimeter = Rect.calculatePerimeter();
        System.out.println("둘레 길이: " + perimeter);
        Rect.isSquare();
    }
}
