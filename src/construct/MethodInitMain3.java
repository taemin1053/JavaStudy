package construct;

public class MethodInitMain3 {
    public static void main(String[] args) {
        MemberInit member1=new MemberInit();
        member1.InitMember("박준수",18,97);

        MemberInit member2=new MemberInit();
        member2.InitMember("정태철",18,98);

        MemberInit[] members= {member1,member2};
        for(int i=0;i<members.length;i++){
            System.out.println(members[i].name+","+members[i].age+","+members[i].grade);
        }

    }
}
