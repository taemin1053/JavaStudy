package scope;

//local Variable(지역변수): {} 코드 블록에서 사용할 수 있는 변수, 자신이 선언된 코드 블록을 벗어나면 제거 된다.
public class Scope1 { // 변수의 접근 가능한 범위를 스코프(Scope)라 한다.
    public static void main(String[] args) {
        int m = 10;
        if(true){
            int x = 20; //x 생존 시작
            System.out.println("if m = " + m);
            System.out.println("if x = " + x);
        }// int x 생존 끝

        //System.out.println("main x = " + x) //오류, 변수 x에 접근 불가
        System.out.println("main m = " + m);
    }//m생존 종료
}

//int m 은 main{}의 코드 블록안에서 선언 -> main{}의 코드 블록이 종료될 때 까지 생존
//int x는 if{}에서 선언되었기 때문에 if{}을 나가면 int x는 사라진다.