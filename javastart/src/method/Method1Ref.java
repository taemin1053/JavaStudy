package method;

public class Method1Ref {
    public static void main(String[] args) {
        int sum1 = add(5, 10);
//5,10은 add method에 넘기는 값인데 이 값을 영어로 Argument(아규먼트),인자라고한다.
        System.out.println(sum1);

        int sum2 = add(15,20);
        System.out.println(sum2);

    }

    public static int add(int a, int b) {//int a, int b->이것이 파라미터
        //public:다른 클래스에서 호출할 수 있는 메서드
        //static:객체를 생성하지 않고 호출할 수 있는 정적 메서드
        //메서드 선언에 사용되는 변수를 파라미터, 매개변수라고 한다.
        System.out.println(a + "+" + b + "연산수행");
        int sum = a + b;
        return sum;
    }
}

