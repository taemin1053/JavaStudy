package ref;

public class InitMain {
    public static void main(String[] args) {
        InitData data = new InitData();
        System.out.println("value1 = " + data.value1);
        System.out.println("value2 = " + data.value2);
        //InitData value1가 초기화를 안했기 때문에 0으로 출력
    }
}
