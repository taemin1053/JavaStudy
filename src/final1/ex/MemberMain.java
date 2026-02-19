package final1.ex;

public class MemberMain {
    public static void main(String[] args) {
        Member member = new Member("MyId","KIM");
        member.print();
        member.changeData("MyId2","KIM2");
        member.print();
    }
}
