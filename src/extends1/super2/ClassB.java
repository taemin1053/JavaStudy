package extends1.super2;

public class ClassB extends ClassA {
    public ClassB(int a) {
        this(a,0);//this 사용 ,기본 생성자 생략 가능
        System.out.println("ClassB 생성자  a= " +a);
    }
    public ClassB(int a, int b){
        super(); //기본 생성자는 생략 가능
        System.out.println("ClassB 생성자 a= " +a+",b= " +b);
    }
    /*ClassB는 ClassA를 상속 받았다. 상속을 받으면 생성자의 첫줄에 super()를 사용해서 부모 클래스의 생성자를 호출해야한다.
    * 예외로 생성자 첫줄에 this()를 사용할 수 있다. 하지만 super()는 자식의 생성자 안에서 언젠가는 반드시 호출해야한다.
    * 부모 클래스의 생성자가 기본 생성자(파라미터가 없는 생성자)인 경우 super()를 생략할 수 있다. */
}
