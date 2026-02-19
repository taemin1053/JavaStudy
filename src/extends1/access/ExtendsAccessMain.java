package extends1.access;

import extends1.access.child.Child;
public class ExtendsAccessMain {

    public static void main(String[] args) {
        Child child = new Child();
        child.call();
    }
}
//코드 실행 순서를 보면 Child.call -> parent.printParent()