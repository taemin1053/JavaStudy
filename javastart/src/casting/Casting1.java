package casting;

public class Casting1 {
    public static void main(String[] args) { //형변환
        //int < long < double, 작은 범위에서 큰 범위에 값을 대입하도 다음 코드를 실행하면 특별한 문제 없이 잘 수행
        int intValue = 10;
        long longValue;
        float doubleValue;

        longValue = intValue;
        System.out.println("longValue = " + longValue);

        doubleValue = intValue;
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L;
        System.out.println("doubleValue = " + doubleValue);
    }
}
