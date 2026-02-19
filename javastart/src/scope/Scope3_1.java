package scope;

public class Scope3_1 {
    public static void main(String[] args) {
        int m = 10;
        int temp = 0;
        if(m > 0){
            temp = m * 2;
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}
//비효울적인 메모리 사용-> temp 변수는 if에서만 사용하기때문에 main{}에서 선언하면 비효율, 코드 복잡성 증가