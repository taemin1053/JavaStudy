package construct;

public class MethodInitMain2 {
    public static void main(String[] args) {
        MemberInit member1 = new MemberInit();
        InitMember(member1,"박준수",18,97);
        MemberInit member2 = new MemberInit();
        InitMember(member2,"정태철",18,98);

        MemberInit[] members = {member1,member2};
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i].name+","+members[i].age+","+members[i].grade);
        }
    }
    static void InitMember(MemberInit member, String name, int age, int grage) {
        member.name=name;
        member.age=age;
        member.grade=grage;
    }
    /*MemberInit 메서드를 사용해서 중복되는 부분을 제거했다. 이 메서드는 대부분 InitMember 객체의 멤버 변수를 사용한다.
    * 저번 타임에 객체 지향에 대해서 학습했으므로 이런 경우 속성과 기능을 한 곳에 두는 것이 더 나은 방법인것 같다. */
}
