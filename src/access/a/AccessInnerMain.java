package access.a;

public class AccessInnerMain {
    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        //public 호출 가능
        accessData.publicField = 1;
        accessData.publicMethod();

        //같은 패키지 이므로 default 호출 가능
        accessData.defaultField = 2;
        accessData.defaultMethod();

        //외부 호출이므로 private 호출 불가
        //accessData.privateField = 3;
        //accessData.privateMethod();

        accessData.innerAccess();
    }
}
