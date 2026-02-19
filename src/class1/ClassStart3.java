package class1;

public class ClassStart3 {
    public static void main(String[] args){
        Student student1 = new Student();
        student1.name ="학생1";
        student1.age = 18;
        student1.score = 90;
        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 17;
        student2.score = 80;
        System.out.println("이름: "+student1.name + " 나이: " + student1.age + " 점수: "+ student1.score);
        System.out.println("이름: "+student2.name + " 나이: " + student2.age + " 점수: "+ student1.score);
    }
}
