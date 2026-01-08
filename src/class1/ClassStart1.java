package class1;

public class ClassStart1 {
    public static void main (String[] args){
        String student[][] = {
                {"학생1", "15", "90"},
                {"학생2", "16", "80"}
        };
        System.out.println("이름: " + student[0][0] +  " 나이: "+student[0][1] + " 성적: " + student[0][2]);
        System.out.println("이름: " + student[1][0] +  " 나이: "+student[1][1] + " 성적: " + student[1][2]);

        String StudentName[] = {"학생3", "학생4"};
        int StudentAge[] = {15,16};
        int StudentScore[] = {90, 80};
        for (int i = 0; i < StudentName.length; i++) {
            System.out.println("이름: " + StudentName[i] + " 나이: " + StudentAge[i] + " 점수: " + StudentScore[i]);
        }
    }

}
