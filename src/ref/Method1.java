package ref;

public class Method1 {
    public static void main(String[] args) {
        Student student1 = new Student();
        initStudent(student1, "태철", 15,90);

        Student student2 = new Student();
        initStudent(student2, "재훈", 17 ,80);

        printStudent(student1);
        printStudent(student2);

    }
    static void initStudent(Student student, String name, int age, int score) {
        student.name = name;
        student.age = age;
        student.score = score;
    }
    static void printStudent(Student student) {
        System.out.println(student.name+","+student.age+","+student.score);
    }
}
