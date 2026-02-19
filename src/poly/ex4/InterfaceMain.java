package poly.ex4;


public class InterfaceMain {
    public static void main(String[] args) {
        //인터페이스도 메소드 생성불가

        Cat cat = new Cat();
        Dog dog = new Dog();

        soundAnimal(cat);
        soundAnimal(dog);

    }
    private static void soundAnimal(InterfaceAnimal animal) {
        animal.sound();
    }
}
