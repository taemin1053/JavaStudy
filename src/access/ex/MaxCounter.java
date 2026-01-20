package access.ex;

public class MaxCounter {
    private int count = 0;
    private int max;

    public MaxCounter(int max) {
        this.max = max;
    }
    public void increase() {
        if (count >= max) {
            System.out.println("최대치를 초과했습니다.");
        }
        else {
            count++;
        }
    }
    public int getCount() {
        return count;
    }
}

