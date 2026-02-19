package poly.ex4;

public class Cat implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("Cat sound");
    }
    @Override
    public void move() {
        System.out.println("cat move");
    }
}
