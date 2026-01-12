package access.b;

//import access.a.DefaultClass1;
//import access.a.DefaultClass2;
import access.a.PublicClass;

public class PublicClassOuterMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        //DefaultClass1 defaultClass1 = new DefaultClass1();
        //DefaultClass2 defaultClass2 = new DefaultClass2();
        //클래스와 서로 다른 패키지에 있어서 불가능
    }
}
