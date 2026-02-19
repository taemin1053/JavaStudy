package ref;

//기본형과 메서드 호출
public class MethodChange1 {
    public static void main(String[] args){
        int a = 10; //기본형
        System.out.println("메소드 호출 전: a = " + a);
        changePrimitive(a);
        System.out.println("메소드 호출 후 a = " + a);
    }
    static void changePrimitive(int x){
        x = 20;
    }
}
