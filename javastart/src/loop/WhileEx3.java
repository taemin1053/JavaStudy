package loop;

public class WhileEx3 {
    public static void main(String[] args) {
        int max = 10;
        int sum = 0;
        int i = 1;
        while(i <= max){
            sum += i;
            i++;
        }
        System.out.println("while: "+sum);
        for(i=1, sum =0; i <= max; i++){
            sum += i;
        }
        System.out.println("for: "+sum);
    }
}
