package codingTest.arraySort;

import java.util.Arrays;

/*
문제 설명
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.

어떤 과학자가 발표한 논문 n편 중,
h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

예시)
citations: [3, 0, 6, 1, 5]
return: 3
설명: 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
논리 설게 및 객체 지향 설계 확인
1. 두개 이상 데이터가 서로 묶여 하나의 의미로 다니는지 -> X n과 h는 서로 다르게 작용하기 떄문에
2. 규칙(행위)가 필요한지 ->애매함 h가 정확하게 뭔지 알아야할듯
3. 명사가 속성을 가질 때: 모르겠음

일단 citations.length가 n임 h는 h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 이 말을 보면 뭔가 평균 같음 중간값 정도..? 중간 인덱스
오답 정리
객체 지향 설계 판단 -> 굳 이 문제는 복잡한 도메인 데이터가 묶여 다니는 문제가 아님 순수 알고리즘 문제임
h는 평균이나 중간 인덱스가 아님
h의 정체
흔한 착각: h는 반드시 citations 배열 안에 존재하는 숫자 중 하나여야한다. -> 틀림
h가 가질 수 있는 값의 범위: 0<= h <= n -> 인용횟수가 아무리 1000번이어도 발표한 논문이 n편이면 h는 n을 넘을 수 없다
예시로 흐름 잡기
정렬(내림차순 또는 오름차순)을 먼저 해봅니다.내림차순 정렬: [6, 5, 3, 1, 0]논문을 1편씩 늘려가며 확인합니다
 i번째 논문과 지금까지 센 편수 비교
 :1번째 논문 (인용 6회): 6회 이상 인용된 논문이 1편 있음 -> 6 >= 1 (만족, h=1 가능)
 2번째 논문 (인용 5회): 5회 이상 인용된 논문이 2편 있음 -> 5 >= 2 (만족, h=2 가능)
 3번째 논문 (인용 3회): 3회 이상 인용된 논문이 3편 있음 -> 3 >= 3 (만족, $h=3$ 가능)
 4번째 논문 (인용 1회): 1회 이상 인용된 논문이 4편 있음 -> 1 >= 4 (불만족, 탈락)
 따라서 조건을 만족하는 h의 최댓값은 3이 됩니다.
 */
public class testHindex {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        //오름차순에서 '남은 편수(n - i)'와 '인용수(citations[i])' 비교
        for(int i = 0; i< citations.length; i++){
           int h = citations.length - i;//현재 논문을 포함해 그 이상 인용된 논문의 개수

            // 인용 횟수가 남은 논문 편수(h) 이상이 되는 최초의 순간이 h의 최댓값
           if(citations[i] >= h){
               return h ;
           }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5};
        testHindex th = new testHindex();
        System.out.println(th.solution(arr));
        System.out.println(Arrays.toString(arr));
    }
}
