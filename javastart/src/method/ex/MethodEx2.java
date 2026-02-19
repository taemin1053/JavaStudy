package method.ex;

public class MethodEx2 {
    public static void main(String[] args) {
        printMessage("hello world",3);
    }
    public static void printMessage(String msg, int time){
        for(int i = 0 ; i < time ; i++){
            System.out.println(msg);
        }
    }
}
