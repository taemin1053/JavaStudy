package construct;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    //생성자
    //생성자는 메서드와 비슷하지만
    //생성자의 이름은 클래스 이름과 같아야 하고, 첫 글자도 대문자로 시작한다.
    //또한 반환 타입이 없으므로 비워둬야 한다.
    MemberConstruct(String name, int age, int grade){
        System.out.println("생성자 호출 name= "+name+",age="+age+",grade="+grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    // this와 오버로딩
    MemberConstruct(String name, int age){
        this(name, age, 50); // this를 사용하면 자신의 생성자를 호출한다
    }
}

