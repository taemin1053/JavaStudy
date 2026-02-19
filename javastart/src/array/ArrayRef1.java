package array;

public class ArrayRef1 {
    public static void main(String[] args) {
        int[] student; //배열 변수 선언 ->int 배열인 student 변수를 선언
        student = new int[10]; //배열 생성

        student[0] = 90;
        student[1] = 80;
        student[2] = 70;
        student[3] = 60;
        student[4] = 50;
        student[5] = 40;
        //변수 값 사용
        for(int i= 0; i< 5; i++){
            System.out.println(student[i]);
        }
    }
}
