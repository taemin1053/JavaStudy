package loop;

public class ForEx2 {
    public static void main(String[] args) {
        int rows;
        for(rows = 1; rows <=5; rows++){
            for(int i =1 ; i <= rows; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
