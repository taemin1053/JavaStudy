package objectoverring;

public class StudentMain1 {
    public static void main(String[] args) {
        /*Student student1 = new Student();
        student1.name = "John Doe";
        student1.number = "20201111";
        student1.birthYear = 1990;
        Student student2 = new Student();
        student2.name = "Jain doe";
        student2.number = "2020";
        student2.birthYear = 1991;
        */
        Student student1 = new Student("jain", "2111",1995);
        Student student2 = new Student("jain", "2111",1995);
        if(student1.equals(student2)) {
            System.out.println("Student 1 and Student 2 are the same");
        }
        else {
            System.out.println("Student 1 and Student 2 are not the same");
        }
        //동일하게 작성했지만 equals를 사용하면 서로 같지 않다고 함 해시 코드 사용하기
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        //서로 해시 코드가 다름 따라서 오버라이딩을 해야함 mac 기준으로  해당 클래스(현재는 Student)에서 cmd + n 단축키를 사용해 equals() and hashCode()를 사용해
        //만들기
        System.out.println(student1); //toString 오버라이딩이 필요함 해시코드 오버라이딩하고 방법은 비슷함
        System.out.println(student2.toString());
    }
}
