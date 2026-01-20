package static2;

public class DecoData {

    private int instanceValue; //인스턴스 변수
    private static int staticValue; //정적 변수

    public static void staticCall() {
        //instanceValue++; //인스턴스 변수 접근, compile error
        //instanceMethod(); //인스턴스 메서드 접근, compile error

        //staticCall은 정적 메서드 이므로 정적 변수, 정적 메서드에는 접근할 수 있지만, static이 없는
        //인스턴스 메서드에 접근하면 컴파일 오류가 발생한다.

        staticValue++; //정적 변수 접근
        staticMethod();
    }
    public void instanceCall() {
        instanceValue++; //인스턴스 변수 접근
        instanceMethod(); //인스턴스 메서드 접근

        staticValue++; //정적 변수 접근
        staticMethod(); //정적 메서드 접근

    }
    private void instanceMethod() { //인스턴스 메서드
        System.out.println("instanceValue= " + instanceValue);
    }
    private static void staticMethod() { //정적 메서드
        System.out.println("staticValue= " + staticValue);
    }
}
