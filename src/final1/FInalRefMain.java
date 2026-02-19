package final1;


//final 변수 참조
//변수는 기본형 변수, 참조형 변수로 나뉜다. -> 기본형 변수는 10,20 같은 값을 보관하고, 참조형 변수는 객체의 참조값을 보관한다.
//final을 기본형 변수에 사용하면 값을 변경 X
//final을 참조형 변수에 사용하면 참조값을 변경할 수 없다.
public class FInalRefMain {
    public static void main(String[] args){
        final Data data = new Data();
        //data = new data(); //final 변경 불가 컴파일 오류 생김
        //변수 선언 시점에 참조값을 할당 했으므로 더는 참조값을 변경할 수 없다.

        //참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}
