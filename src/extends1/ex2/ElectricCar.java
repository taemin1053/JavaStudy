package extends1.ex2;
//Car는 부모 클래스가 된다. 여기에는 자동차의 공통 기능인 move()가 포함되어 있다.
//또한 extends Car를 사용해서 부모 클래스인 Car를 상속
public class ElectricCar extends Car {

    public void charge() {
        System.out.println("충전합니다.");
    }
}
