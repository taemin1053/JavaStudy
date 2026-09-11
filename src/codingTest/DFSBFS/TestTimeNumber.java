package codingTest.DFSBFS;
class Counter{
    private final int[] number;
    private int count= 0;
    private int sum = 0;
    public Counter(int[] number){
        this.number = number;
    }
    private  void dfs(int[] number, int target, int index, int sum){
        if(index == number.length) {
            if (sum == target) {
                count++;

            }
            return;
        }
        dfs(number , target, index +1 , sum + number[index]);
        dfs(number , target, index +1 , sum - number[index]);

    }
    public int getCount(int target){
        dfs(number, target, 0,0);
        return count;
    }
}
public class TestTimeNumber {
    public int solution(int[] numbers, int target) {
        Counter counter = new Counter(numbers);
        return counter.getCount(target);
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1};
        int b = 4;
        TestTimeNumber ts = new TestTimeNumber();
        System.out.println(ts.solution(a,b));

    }
}
