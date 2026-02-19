package method;

public class MethodReturn1 {
    public static void main(String[] args) {
        System.out.println("void 사용안한 method 호출");
        checkAge(18);
        checkAge(17);
        System.out.println("void 사용 method 호출");
        checkAge2(18);
        checkAge2(17);
    }
    public static int checkAge(int age){
        if(age < 18){
            System.out.println(age+"살, 미셩년자입니다.");

        }
        else{
            System.out.println(age+ "살 성인입니다.");

        }
        return age;
    }
    //반환 타입이 없는 void를 사용하면 마지막 줄 return을 생략할 수 있다
    public static void checkAge2(int age){
        if(age < 18){
            System.out.println(age+"살 미성년자입니다.");
            return;
    //여기서 retrun을 사용하지 않은 이유는 조건문이 맞으면 바로 mrthod를 빠져나오게 하기위해서
        }
        System.out.println(age+"살 성인입니다.");
    }
}
