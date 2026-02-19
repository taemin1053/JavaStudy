package poly.ex3;

/*추상 메서드: 부모 클래스를 제공하지만 , 실제 생성되면 안되는 클래스, 실체는 존재 X */
public abstract class AbstractAnimal {
    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }
}
