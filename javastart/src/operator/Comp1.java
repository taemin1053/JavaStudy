package operator;

public class Comp1 {
    public static void main(String[] args) {
        //비교연산자
        int a= 2;
        int b= 3;

        System.out.println(a==b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);

        //결과를 boolean에 담기
        boolean resulit = a==b;
        System.out.println(resulit);
    }
}
