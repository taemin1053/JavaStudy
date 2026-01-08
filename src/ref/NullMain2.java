package ref;

public class NullMain2 {
    public static void main(String[] args) {
        Data data = null;
        data.value = 10;
        System.out.println("data.value = " + data.value);
        //->NullPointerException 발생 data.value ->null.value null은 참조할 주소가 존재하지 않기 때문에 10이 들어가지 않는다.
    }
}
