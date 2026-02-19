package loop;

public class WhileEx2 {
    public static void main(String[] args) {
        int num = 0;
        int count = 0;
        while(count <10){
            num++;
            if(num % 2 == 0){
                count++;
                System.out.println("while:  num: "+num + " count = " + count);

            }
        }
        for(num= 1, count = 0; count < 10; num++){
            if(num % 2 == 0){
                count++;
                System.out.println("for:  num: "+num + " count = " + count);

            }
        }
    }
}
