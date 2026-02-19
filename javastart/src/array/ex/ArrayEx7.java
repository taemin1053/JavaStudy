package array.ex;
import java.util.Scanner;
public class ArrayEx7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생수를 입력하세요");
        int count = scanner.nextInt();
        int[][] student = new int[count][3];
        String[] subject = {"국어","영어","수학"};

        for(int i= 0 ; i<count; i++){
            System.out.println(i+1+"번 학생의 성적을 입력하세요");
            for(int j=0; j<3; j++){
                System.out.print(subject[j]+"점수: ");
                student[i][j] = scanner.nextInt();
            }
        }

        for(int i=0; i<count; i++){
            int sum = 0;
            double average = 0;
            for(int j=0; j<3; j++){
                sum+=student[i][j];
            }
            average = (double) sum/count;
            System.out.println(i+1+"번 학생의 총점: "+sum + "평균: "+average);
        }

    }
}
