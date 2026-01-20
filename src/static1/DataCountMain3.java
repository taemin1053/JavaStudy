package static1;

public class DataCountMain3 {
    public static void main(String[] args) {
        Data3 data1 = new Data3("A");
        System.out.println("A count: " + data1.count);
        Data3 data2 = new Data3("B");
        System.out.println("B count: " + data2.count);
        Data3 data3 = new Data3("C");
        System.out.println("C count: " + data3.count);
        //정적 변수 접근 법
        //static 변수는 클래스를 통해 바로 접근할 수도 있고, 인스턴를 통해서도 접근할 수 있다.
        //인스턴스를 통한 접근
        Data3 data4 = new Data3("D");
        System.out.println(data4.count);
        //정적 변수의 경우 인스턴스를 통한 접근은 추천하지 않는다. 왜냐하면 코드를 읽을 때 인스턴스 변수에  접근하는 것 처럼 오해할 수 있다.
        //클래스를 통한 접근
        System.out.println(Data3.count);
    }
}
