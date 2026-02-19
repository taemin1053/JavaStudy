package static2.ex;

public class Car {
    private String name;
    private static int totalCar;
    public Car(String name) {
        this.name = name;
        System.out.println("차랑 구입, 이름: " + name);
        totalCar++;
    }
    public static void showTotalCar() {
        System.out.println("구매한 차량 수: " + totalCar);
    }
}
