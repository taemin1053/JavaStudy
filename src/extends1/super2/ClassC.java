package extends1.super2;

public class ClassC extends ClassB{

    public ClassC() {
        super(10,20);
        System.out.println("ClassC 생성자");
    }
    /* ClassC는 ClassB를 상속 받았다. ClassB 다음 두 생성자가 있다
    * ClassB(int a)
    * ClassB(int a, int b)
    * 생성자는 하나만 호출할 수 있다. 따라서 두 생성자를 하나만 선택한다.
    *  */
}
