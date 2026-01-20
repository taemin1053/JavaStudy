package memory;

public class JavaMemoryMain2 {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
    }
    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10);
        method2(data1);
        System.out.println("method1 end");
    }
    static void method2(Data data2) {
        System.out.println("method2 start");
        System.out.println("data.value= " + data2.getValue());
        System.out.println("method2 end");
    }
    /*main에서 method1 호춣  지역 변수로 data data1 method1()은 new Data(10)를 사용해서 heap 영역에 Data 인스터스를 생성
    * 그리고 참조값을 data1에 보관한다.
    * method1은 method2()를 호출하면서 Data data2 매개변수에 참조값읋 넘긴다.
    * 이제 method1()에 있는 data1과 method2에 있는 data2 지역 변수는 둘다 같은 인스턴스를 참조한다.
    *
    * 정리
    * 지역 변수는 스택 영역에, 객체(인스턴스)는 힙 영역에 관리되는 것을 확인했다.  */
}
