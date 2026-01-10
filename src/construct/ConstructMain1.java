package construct;

public class ConstructMain1 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("박준수", 18 , 98);
        MemberConstruct member2 = new MemberConstruct("정태철", 18 , 97);
        /*생성자는 인스턴스를 생성하고 나서 즉시 호출된다
        * 따라서 new 클래스(생성자)이름 (생성자에 맞는 인수 목록)  */
        MemberConstruct[] members = {member1,member2};
        for(int i=0;i<members.length;i++){
            System.out.println(members[i].name+","+members[i].age+","+members[i].grade);

        }
    }
}
