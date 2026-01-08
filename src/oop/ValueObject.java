package oop;

public class ValueObject {
    int value;
    void add() {
        value++;
        System.out.println("숫자 증가 value= "+value);
    }
    /*메서드는 객체를 생성해 호출할 수 있다. 하지만  static이 붙으면 객체를 생성하지 않고도 메서드를 호출할 수 있다. */
}
