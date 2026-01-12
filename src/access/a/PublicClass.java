package access.a;

//접근 제어자 사용- 클래스 레벨
//클래스 레벨의 접근 제어자는 public, default만 사용할 수 있다.
//public 클래스는 반드시 파일명과 이름이 같아야한다. 또한 하나의 자바 파일에 public 클래스는 하나만 등장가능
public class PublicClass {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        DefaultClass1 defaultClass1 = new DefaultClass1();
        DefaultClass2 defaultClass2 = new DefaultClass2();
    }
}
class DefaultClass1 {

}
class DefaultClass2 {

}
