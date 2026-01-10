package construct;
/*객체를 생성하는 시점에 어떤 작업을 하고 싶다면 생성자(Constructor)를 이용하면 된다.
* 생성자를 알기전 생성자가 왜 필요한지 코드로 알아보기 */
public class MemberInit {
    String name;
    int age;
    int grade;

    void InitMember(String name, int age, int grade){//매개 변수
        this.name = name;
        this.age = age;
        this.grade = grade; //this는 자기 자신을 가리킨다.
        //멤버 변수와 매개 변수의 이름 이름 같다. 이때 매개변수가 코드 블럭의 더 안쪽에 있기 때문에 매개변수가 우선순위를 가진다
        //따라서 initMember() 메서드 안에서 name이라고 적으면 접근하게된다
        //그래서 멤버 변수에 접근하려면 앞에 this.을 붙여주면 된다.
    }
}
