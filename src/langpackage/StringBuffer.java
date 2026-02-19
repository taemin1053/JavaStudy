package langpackage;
import java.lang.*;
public class StringBuffer {
    public static void main(String[] args) {
        java.lang.StringBuffer sb = new java.lang.StringBuffer();
        sb.append("hello");
        sb.append(" ");
        sb.append("world");

        String str = sb.toString();
        System.out.println(str);

        java.lang.StringBuffer sb2 = new java.lang.StringBuffer();
        java.lang.StringBuffer sb3 = sb2.append("hello");
        if(sb2 == sb3) {
            System.out.println("sb2 ==sb3");
        }
        //sb2가 자기 자신을 반환했으므로 sb3와 sb2는 같다
        //이런 방식을 메소드 체이닝이라고 한다
        //메서드 체이닝 예시
        String str2 = new java.lang.StringBuffer().append("hello").append(" ").append("world").toString();
        System.out.println(str2);


    }
}
