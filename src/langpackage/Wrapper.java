package langpackage;

public class Wrapper {
    int i = 5; //데이터 기본형
    Integer i2 = new Integer(5); //int를 객체로 바꿔주는 wrapper class 중 하나인 Integer

    Integer i3 = 5; //기본 데이터 타입을 넣어도 문제 없음 자동으로 객체형으로 변함(오토박싱)

    //오토박싱: 기본 타입 데이터를 객체 타입의 데이터로 자동 형변환 시켜주는 기능

    //객체형을 기본형으로 변환
    int i4 = i3.intValue();

    int i5 = i3;
    //오토언박싱: 오토박싱과 반대로 객체 타입의 데이터를 기본형으로 자동으로 형변환 시켜주는 기능
}
