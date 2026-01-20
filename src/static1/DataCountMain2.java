package static1;

public class DataCountMain2 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Data2 data1 = new Data2("A",counter);
        System.out.println("A count: " + counter.count);
        Data2 data2 = new Data2("B",counter);
        System.out.println("B count: " + counter.count);
        Data2 data3 = new Data2("C",counter);
        System.out.println("C count: " + counter.count);
    }
}
//Counter 인스턴스를 공용으로 사용한 덕분에 객체를 생성할 때 마다 값을 정확하게 증가시킬 수 있다.