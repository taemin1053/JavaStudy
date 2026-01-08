package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("메소드 호출 전: dataA.value = " + dataA.value);
        changeReference(dataA);
        System.out.println("메소드 호출 후: dataA.value = " + dataA.value);
    }

    static void changeReference(Data dataX){
        dataX.value = 20;
    }
    //dataA도 value도 변함 -> 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다.
}
