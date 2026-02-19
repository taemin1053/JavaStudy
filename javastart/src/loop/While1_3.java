package loop;

public class While1_3 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        int endNum = 3;
        while (i <= endNum) {
            sum += i;
            System.out.println(sum);
            i++;
        }
    }
}
