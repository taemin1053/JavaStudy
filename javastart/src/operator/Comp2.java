package operator;

public class Comp2 {
    public static void main(String[] args) {
        //문자열 비교 java에서는 문자열 비교를 할 때 equals()메서드를 사용해야함
        String a = "문자열1";
        String b = "문자열2";

        boolean result = a.equals("hello");
        boolean result2 = a.equals("문자열1");
        boolean result3 = a.equals(b);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}
