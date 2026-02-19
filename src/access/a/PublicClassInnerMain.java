package access.a;

public class PublicClassInnerMain {
    public static void main(String[] args) {
        PublicClass publicClass = new PublicClass();
        DefaultClass1 defaultClass1 = new DefaultClass1(); //같은 패키지라 가능
        DefaultClass2 defaultClass2 = new DefaultClass2();
    }
}
