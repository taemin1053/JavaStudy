package operator;

public class Logical1 {
    //논리연산자
    public static void main(String[] args) {
        System.out.println("&&:AND 연산");
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && false);

        System.out.println("||: OR 연산");
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || false);

        System.out.println("!(부정) 연산");
        System.out.println(!true);
        System.out.println(!false);

        //변수활용
        System.out.println("변수활용");
        boolean a = true;
        boolean b = false;
        System.out.println(a && b);
        System.out.println(a || b);
        System.out.println(!a);
        System.out.println(!b);

    }
}
