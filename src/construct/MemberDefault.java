package construct;

//기본 생성자
// 매개변수가 없는 생성자
//클래스에 생성자가 하나도 없으면 자바 컴파일러는 매개변수가 없고, 작동하는 코드가 없는 기본 생성자를 자동으로 생성한다.
//MemberDefault 클래스에는 생성자가 없으므로 자바가 기본 생성자를 만들어준다.
public class MemberDefault {
    String name;

    //기본 생성자
    MemberDefault() {
        System.out.println("생성자 호출");
    }
}
