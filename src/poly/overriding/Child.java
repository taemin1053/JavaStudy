package poly.overriding;

public class Child extends Parent {
    public String value ="child";

    @Override
    public void method() {
        System.out.println("Child.method");
    }
    //Child에서 Parent의 method()를 재정의(오버라이딩) 했다.
}
