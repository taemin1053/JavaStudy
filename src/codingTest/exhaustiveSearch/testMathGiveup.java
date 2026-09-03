package codingTest.exhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
제한 사항
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

 논리 구현 및 객체 지향 확인
 일단 문제를 해석하자면
 1번 수포자는 1,2,3,4,5
 2번 수포자는 2,1,2,3,2,4,2,5
 3번 수포자는 3,3,1,1,2,2,4,4,5,5
 이렇게 반복한다. 즉 우리는 배열이 주어 졌을 때 각 번호의 수포자들이 몇개를 맞췄는지 확인해야한다 .

 쉬운 방법을 떠올리면, count라는 배열을 만들어서 각 인덱스 수포자들의 맞친 개수를 입력한다 .
 객체 지향 확인
 1. 두 개 이상의 데이터가 하나의 의미로 묶여있는지 -> 수포자들의 찍는 방식과 정답은 서로 묶여다녀야한다 -> O
 2. 규칙이나 행위가 있는가 -> 정답이 몇개인지 확인, 가장 많이 맞춘 사람은 누구인지 이렇게 2개가 있다.
 3. 명사가 속성을 가지는가? -> 문제 -> 정답?
 클래스를 만들어야한다. 그러면 클래스를 총 몇개를 만들어야할까? 행위가 2개니깐 2개로 나눠야하지 않을까?
 그러면 2개를 어떤 식으로 나눌 것인가
 1. 배열을 정의하고 정답 개수를 확인하는 클래스, 2.정답 수를 비교하는 클래스
 그러면 정답 개수를 어떻게 확인 할 것인가
 1. 배열에서 반복되게 숫자를 넣을 수 있나..? 그게 된다면 배열을 만들고 ,인덱스 끼리 비교 -> 같으면 count++
 ->이게 될려나 mapping..? 아니면 hashMap..? 개수 샐때 편하지 않나..? 정보 조회나

 정리:
 1. 객체 모델링 분석 (클래스 2개 분리)
 1.student(수포자 개인 도메인)
 속성: 수포자 번호, 찍기 패턴
 행위:
 이 문제의 정답과 내 패턴이 일치하는가 패턴
 정답 배열(answer) 전체를 받아 내가 몇 개를 맞혔는지 getScore로 계산
 2.Students(Student 그룹)
 속성: List<Student>
 행위
 최고점 받은 학생들의 번호를 오름차순으로 정리

 정답 비교를 어떻게 할 것인가
 %를 사용하면 원래 패턴 배열의 길이안에서 인덱스가 순환한다.
 patten[문제번호 % patten.length]->이렇게하면 수포자의 패턴을 통해 정답하고 비교하면된다.
 */
class student{
    private final int id;
    private final int[] pattern;

    //생성자 확인 -> student는 초반에 값을 주입하지 않으면 작동할 수 없는가? -> O, id와 pattern이 나중에 들어오면 class가 할 수 있는 건 아무것도 없다
    public student(int id, int[] pattern){
        this.id = id;
        this.pattern = pattern;
    }
    public int getScore(int answers[]){
        int score = 0 ;
        // [핵심 로직: 나머지 연산자 %]
        // 문제 번호(i)가 패턴 길이보다 커져도 0번 인덱스부터 무한 반복되도록 순환 인덱스를 만듦
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == this.pattern[i% this.pattern.length]){
                score++;
            }
        }
        return score;
    }
    public int getId(){
        return this.id;
    }
}
class students{
    // 외부에서 리스트를 직접 조작(clear, add 등)하지 못하도록 private final로 캡슐화
    private final List<student> students;

    //생성자 유무 확인 ->List<student>에 초반 값을 주입해야할까? -> O, 또한 쓸데없는 메모리 방지
    // 학생 목록이 없는 깡통 상태의 Students 객체 생성을 방지.
    public students(List<student> students){
        this.students = students;
    }
    //치고 득점자들의 번호 반환
    public int[] getTop(int[] answers){
        int maxScore = 0;
        int[] score = new int[students.size()];
        for(int i =0; i< students.size(); i++){
            //getScore를 호출하며 학생들의 점수를 저장
            score[i] = students.get(i).getScore(answers);
            maxScore = Math.max(maxScore, score[i]);
        }

        //최고 점수와 일치하는 학생의 번호를 수집
        List<Integer> TopStudent = new ArrayList<>();
        for(int i = 0; i <students.size(); i++){
            if(maxScore == score[i]){
                TopStudent.add(students.get(i).getId());
            }
        }
        //Integer::intValue는 각 Integer 객체의 .intValue() 메서드를 호출하라는 의미입니다 x-> x.intValue랑 같음
        //부득이하게 stream을 사용함. mapToInt Integer을 int로 변환. toArray는 배열로 변환
        return TopStudent.stream().mapToInt(Integer::intValue).toArray();
    }

}
public class testMathGiveup {
    public int[] solution(int[] answers){
        // [원시 데이터 -> 도메인 객체 변환]
        // 3명의 수포자 정보를 각각 생성하여 리스트로 묶음
        List<student> st = Arrays.asList(
                new student(1, new int[]{1, 2, 3, 4, 5}),
                new student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}),
                new student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5})
        );

        students students = new students(st);
        return students.getTop(answers);
    }

    public static void main(String[] args) {
        int[] answer = {1,3,2,4,2};
        testMathGiveup tm = new testMathGiveup();
        System.out.println(Arrays.toString(tm.solution(answer)));
    }
}
