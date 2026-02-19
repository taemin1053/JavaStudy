package casting;

public class Casting2 {
    public static void main(String[] args) {
        int intValue = 0;
        double doubleValue = 1.5;

        //intValue = doubleValue
        intValue = (int) doubleValue; //형변환
        System.out.println("intValue = " + intValue);
    }
}
