package extends1.ex1;

public class CarMain {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.move();
        electricCar.charge();

        GasCar gasCar = new GasCar();
        gasCar.move();
        gasCar.fillUp();
    }
    //전기차와 가스차는 둘다 move(),charge(fillUp)기능이 있다, 또한 전기차와 가스차는 자동차(Car)의 좀더 구체적인 개념이다.
    //반대로Car는 전기차와 가스차를 포함한 추상적 개념
    //전기차든 가스차든 주유하는 방식이 다르지 이동하는 것은 똑같다 ->이럴때 상속관계 extends를 사용하면 효과적이다
}
/*상속관계
* 기존 클래스의 필드와 메서드를 새로운 클래스에서 재사용하게 해준다. 이름 그대로 기존 클래스의 속성과 기능을 그대로 물려받는 것이다. 상속을 사용할려면 extends 키워드를 사용
* 그리고 extends 대상은 하나만 가능
* 용어 정리
* 부모 클래스 (슈퍼 클래스): 상속을 통해 자신의 필드와 메서드를 다른 클래스에 제공하는 클래스
* 자식 클래스 (서브 클래스): 부모 클래스로부터 필드와 메서드를 상속받는 클래스 */