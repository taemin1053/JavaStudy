package access.ex;

public class CounterMain {
    public static void main(String[] args) {
        MaxCounter maxCounter = new MaxCounter(3);
        maxCounter.increase();
        maxCounter.increase();
        maxCounter.increase();
        maxCounter.increase();
        int counter = maxCounter.getCount();
        System.out.println(counter);
    }
}
