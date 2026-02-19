package construct;

public class MethodInitMain1 {
    public static void main(String[] args) {
        MemberInit memberInit = new MemberInit();
        memberInit.name = "박준수";
        memberInit.age = 18;
        memberInit.grade = 98;

        MemberInit memberInit1 = new MemberInit();
        memberInit1.name = "정태철";
        memberInit1.age = 18;
        memberInit1.grade = 99;

        MemberInit[] members = {memberInit, memberInit1};
        for( int i = 0; i < members.length; i++ ) {
            System.out.println(members[i].name+","+members[i].age+","+members[i].grade);
        }
    }
    //회원 객체를 생성하고 나면 name, age, grade 같은 변수에 초기값을 설정한다. 이 코드는 회원의 초기값을 설정하는 부분이 계속 반복되기때문에
    //메서드를 이용해 반복을 제거해보겠다.
}
