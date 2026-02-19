package pack;
//다른 package , 같은 이름에 클래스
import pack.a.User;
//import pack.b.User;
// -> 같은 이름의 클래스가 있다면 import는 둘중 하나만 선택할 수 있다.
public class PackageMain3 {

    public static void main(String[] args) {
        User userA = new User();
        pack.b.User userB = new pack.b.User();
    }
}
//패키지 규칙
/*
* 1. 패키지의 이름과 위츠는 폴더(디렉토리) 위치와 같아야 한다.(필수)
* 2. 패키지 이름은 모두 소문자를 사용한다.(관례)
* 3. 패키지 이름의 앞 부분에는 일반적으로 회사의 도메인 이름 이름을 거꾸로 사용한다.
* ex) com.company.myapp과 같이 사용
* 이 부분은 필수는 아니다. 하지만 수 많은 외부 라이브러리가 함께 사용되면 같은 패키지에
* 같은 클래스 이름이 존재 할 수도 있다.
* 내가 오픈소스나 라이브러리를 만들어서 외부에 제공한다면 지키는게 좋음 */