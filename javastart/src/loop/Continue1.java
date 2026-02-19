package loop;

public class Continue1 {
    public static void main(String[] args) {
        int i = 1;

        while ( i<=5){
            if(i ==3){
                i++;
                System.out.println("건너뜁니다.");
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
