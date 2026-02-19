package poly.basic;

/*다형성은 이름 그대로 다양한 형태, 여러 형태를 뜻한다.
* 프로그래밍에서는 다형성은 한 객체가 여러 타입의 객체로 취급될 수 있는 능력, 보통 하나의 객체는 하나의 타입으로 고정되어 있다.
*  그런데 다형성을 사용하면 하나의 객체가 다른 타입으로 사용될 수 있다
* 다형성의 핵심 이론
* 다형적 참조
* 메서드 오버라이딩 */
public class Parent {

    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
