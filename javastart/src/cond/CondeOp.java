package cond;
//삼항 연산자
public class CondeOp {
    public static void main(String[] args) {
        int age = 18;
        String status = (age >= 18) ? "성인" : "미성년자";
        System.out.println(status);
    }
}
