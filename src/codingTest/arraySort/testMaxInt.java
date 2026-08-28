package codingTest.arraySort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요
제안사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
객체지향 설계 조건 분석
1. 두 개 이상의 데이터가 하나의 의미로 묶어 다닐때 -> 정수를 각각 하나씩 나눠서 한다고 했을때 두개 이상의 데이터가 하나로 묶여다니긴함
2. 데이터뿐만 아니라 규칙(행위)가 필요할때 ->일단 문자열을 숫자로 바꿔야하고, 배열에 있는 문자열를 한개 씩 나눠야됨
3.문제 설명의 명사가 속성을 가질 때 -> 이건 아닌듯

생성자 조건 확인하기
초기에 값을 넣지 않으면 객체 생성을 할 수 없는가 -> 맞음 값을 주입해야지 실행이된다.
클래스 설계
int[] numbers를 받아주는 변수 생성
여기가 문제임 사실상 numbers.length가 n이라고 할 때 경우의 수는 n!임 -> 즉 단순 정렬해야함
가장 단순한건 앞에 최고 차항이 9에 가까워야함
 즉 10과 9가 있을 때 10은 앞자리가 1이고 9는 9이기에 9를 먼저 넣음 -> 자리수를 확인후 숫자/(자리수-1)*10
 이렇게하면 가장 큰수를 만들기 쉬워짐
 오답 정리:
 앞자리 숫자가 같을 때 이 수식은 깨진다  -> 3과 34를 생각하면 334 343 이므로 34가 3보다 앞에 와야함
 핵심 해결책: A,B가 있을 때 어느것이 앞에 와야하는지 (B+A), (A+B)의 크기를 비교하면 쉽다

 객체지향 설계
 도메인객체: ComparableNumber
 속성: priavte final String value
 행위: Comparable<ComparableNumber>를 구현하여 compareTo 정의
 (other + this)와 (this + other)를 비교하여 내림차순 정렬
 (other.value + this.value).compareTo(this.value + other.value)
 */
class ComparableNumber implements Comparable<ComparableNumber>{
    private final String value; //숫자 한개만 저장

    public ComparableNumber(String value){
          this.value = value;
    }

    @Override
    public int compareTo(ComparableNumber other){
        return (other.value + this.value).compareTo(this.value + other.value);
    }

    public String getValue() {
        return value;
    }
}
public class testMaxInt {
    public String solution(int[] numbers){
        List<ComparableNumber> list = new ArrayList<>(); //compareTo를 사용하기 위해 타입을 ComparableNumber로 선언
        for (int number : numbers) {
            list.add(new ComparableNumber(String.valueOf(number)));
            //list에 넣음과 동시에 ComparableNumber 객체 heap 메모리 영역에 생성 생성된 객체를 String으로 변환
            /*
            String stringNumber = String.valueOf(number);
            ComparableNumber comparableNumber = new ComparableNumber(stringNumber);
            list.add(comparableNumber);
             */
        }

// 2. 정렬 수행 Comparable에 정의한 compareTo 기준으로 자동 정렬)
        /*
        Collentions.sort가 CompareTo를 참조 할 수 있는 이유
        자바 표준 라이브러리(JDK)의 Colletions.java 내부를 보면
        public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
        }
        이렇게 명시 되어있다. <T comparable<..extend>>  이 메서드에 들어오는 리스트의 원소 타입 T는
        반드시 Comparable 인터페이스 구현(implements)한 클래스이여라한다. 만약 implements Comparable을 붙이지 않는 클래스를 Collections.sort()에 넣으려고 하면 컴파일 시 오류 발생

        또한 호출과정을 보면
        // 내부 정렬 알고리즘 내부 로직 (단순화된 형태)
    Comparable<Object> pivot = (Comparable<Object>) a;

    if (pivot.compareTo(b) > 0) {
    // 자리를 바꿈 (Swap)
    } a 객체를 Comparable를 호출하면, 동적 바인딩에 의해 a의 실제 객체인 ComparableNumber 안에 오버라이딩된 compareTo() 메서드 실행
         */
        Collections.sort(list);
/*
compareTo는 숫자하나 저장한거랑 다른 ComparbleNumber을 만나면 비교를함
근데 왜 한개 저장한다 해놓고 list를 쓰는가 문제에서 주어진 입력은 숫자 1개가 아니라 수많은 숫자들의 묶음(int[] numbers]이다
자바의 정렬 도구인 Collections.sort()나 Arrays.sort는 여러 개가 모여있는 list를 통째로 넘겨받아야 정렬할 수 있음
각 ComparableNumber이 Comparable 규칙을 쥐고 있고, 이 numbers들을 list라는 바구에 전부 담아서 Collections.sort(list)에 던져줌
전에 했던 job(testHardClass)와 동일함 단일객체가 시작시간, 소요시간에서 숫자 1개값으로 변한것 밖에 없음
 */
        //StringBuilder로 붙이기
        StringBuilder stringBuilder = new StringBuilder();
        for(ComparableNumber num: list){
            stringBuilder.append(num.getValue());
        }
        //예외처리: 가장 큰 값이 0이면 전체 결과 0
        if(list.get(0).getValue().equals("0")){
            return "0";
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        testMaxInt mi = new testMaxInt();
        System.out.println(mi.solution(arr));
    }
}
