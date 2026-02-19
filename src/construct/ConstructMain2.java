package construct;

public class ConstructMain2 {
    public static void main(String[] args) {
        MemberConstruct member1 = new MemberConstruct("user1", 15, 90);
        MemberConstruct member2 = new MemberConstruct("user2", 17);

        MemberConstruct[] members = {member1,member2};

        for (int i = 0; i < members.length; i++) {
            System.out.println("이름: "+members[i].name+","+members[i].age+","+members[i].grade);
        }
    }
    //결과를 보면 알겠지만. 생성자를 오버로딩 한 덕분에 성적 입력이 꼭 필요한 경우에는 grade가 있는 생성자를 호출하면 되고,
    //그렇지 않은 경우에는 grade가 없는 생성자를 호출 된다.
}
