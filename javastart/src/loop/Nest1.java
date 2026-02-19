package loop;

public class Nest1 {
    public static void main(String[] args) {
        for(int i = 1; i < 3; i++){
            System.out.println("외부 for 시작 i: " +i);
            for(int j = 1; j < 3; j++){
                System.out.println("내부 for " + i +"-" + j);
            }
            System.out.println("외부 for 종료 i: " +i);
            System.out.println();
        }
    }
}
