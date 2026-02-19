package poly.overriding;

//메서드 오버라이딩에서 기억해야할 점: 오버라이딩 된 메서드가 항상 우선권을 가진다.
public class Parent {

    public String value = "parent";

    public void method() {
        System.out.println("Parent.method");
    }
}
