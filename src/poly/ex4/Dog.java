package poly.ex4;

public class Dog implements InterfaceAnimal {
    @Override
    public void sound() {
        System.out.println("Dog sound");
    }
    @Override
    public void move() {
        System.out.println("Dog move");
    }
}
