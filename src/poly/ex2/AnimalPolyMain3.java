package poly.ex2;

public class AnimalPolyMain3 {
    public static void main(String[] args) {
        Animal[] animalArray = {new Cat(), new Dog(), new Cow()};
        for (Animal animal : animalArray) {
            soundAnimal(animal);
        }
    }
    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
