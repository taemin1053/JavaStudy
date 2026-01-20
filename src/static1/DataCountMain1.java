package static1;

public class DataCountMain1 {
    public static void main(String[] args) {
        Data1 data1 = new Data1("A");
        System.out.println("A count: " + data1.count);

        Data1 data2 = new Data1("B");
        System.out.println("B count: " + data2.count);

        Data1 data3 = new Data1("C");
        System.out.println("C count: " + data3.count);
    }
    /*객체를 생성할 때 마다 Data1인스턴스는 새로 만들어진다. 그리고 인스턴스에 포함된 count 변수도 새로 만들어지기 때문이다.
    * 처음 Data1("A") 인스턴스를 생성하면 count값은 0으로 초기화 된다. 생성자에서 count++을 호출해서 count의 값은 1이 된다.
    **/
}
