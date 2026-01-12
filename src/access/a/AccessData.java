package access.a;
//접근 제어자 사용 - 필드, 메서드
public class AccessData {

    public  int publicField;
    int defaultField;
    private int privateField;


    public void publicMethod(){
        System.out.println("publicMethod 호출 " + publicField );
    }
    void defaultMethod(){
        System.out.println("defaultField 호출 "+ defaultField );
    }
    private void privateMethod(){
        System.out.println("privatedField 호출 "+ privateField );
    }

    public void innerAccess() {
        System.out.println("내부 호출");
        publicField = 100;
        defaultField = 200;
        privateField = 300;
        publicMethod();
        defaultMethod();
        privateMethod();
    }
    //innerAccess()는 내부호출을 하는 데 내부 호출은 자기 자신에게 접근하는 것이므로, private를 포함한 모든 곳에 접근할 수 있다
}
