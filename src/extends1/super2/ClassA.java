package extends1.super2;

/*상속 관계의 인스턴스를 생성하면 결국 메모리 내부에는 자식과 부모 클래스가 각각 다 만들어진다. Child를 만들면 부모인 Parent까지 함께 만들어지는 것이다
* 따라서 각각의 생성자도 모두 호출 되어야한다.
* 상속 관계를 사용하면 자식 클래스의 생성자에서 부모 클래스의 생성자를 반드 호출해야한다. */
public class ClassA {
    public ClassA() {
        System.out.println("ClassA 생성자");
    }
    //ClassA는 최상위 부모 클래스다.
}
