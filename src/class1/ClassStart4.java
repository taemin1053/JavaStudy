package class1;
//배열 사용
public class ClassStart4 {
    public static void main(String[] args){
        Student student1 = new Student();
        student1.name = "학생1";
        student1.age = 18;
        student1.score = 80;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 18;
        student2.score = 75;

        Student[] students =new Student[2];
        students[0] = student1;
        students[1] = student2;

        Student[] studentarr = new Student[]{student1,student2};
        Student[] studentarr2 = {student1,student2}; //이렇게하면 선언후 바로 최적화 가능
        for(int i=0; i<studentarr.length; i++){
            System.out.println("이름: " + studentarr[i].name + " 나이: "+studentarr[i].age +
                    " 점수: " + studentarr[i].score);
        }

    }
}
