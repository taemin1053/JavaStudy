package loop;

public class WhileEx1 {
    public static void main(String[] args) {
        int count = 1;
        while(count <= 10){
            System.out.println("While:" +count);
            count++;
        }

        for(int i = 1; i <= 10; i++){
            count = i;
            System.out.println("for: " +count);
        }
    }
}
