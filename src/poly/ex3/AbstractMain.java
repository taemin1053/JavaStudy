package poly.ex3;

//추상 클래스는 생성 불가능
//AbstractAnimal animal = new AbstractAnimal();

import poly.ex2.Animal;

public class AbstractMain {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        cat.sound();
        cat.move();

        soundAnimal(cat);
        soundAnimal(dog);
        soundAnimal(cow);
    }
    private static void soundAnimal(AbstractAnimal animal) {
        animal.sound();
    }

}
