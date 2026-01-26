package extends1.super2;

public class Super2Main {
    public static void main(String[] args) {
        //ClassC classC = new ClassC();
        ClassB classB = new ClassB(100);
    }
    //ClassA -> ClassB -> ClassC 순서로 실행된다.
}
