package codingTest.exhaustiveSearch;
import java.util.*;
/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제안사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

예제
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
11과 011은 같은 숫자로 취급합니다.

논리 설계
1. 객체 지향-> 클래스로 나눌 수 있는지
1-1. 두 개이상의 데이터가 하나로 묶여 하나의 의미를 나타내는가 -> yes, 이유: 배열에 있는 숫자들이 하나로 합쳐져 소수가 되었을 때 카운팅이 되기 때문이다.
1-2. 규칙이나 행위를 하는가 -> yes, 소수를 찾는 클래스 , 문자열을 숫자로 변환하는 기능이 있으므로 맞음
1-3. 명사가 속성을 가지는가 -> 잘모르겠음, 넘버가 행위값을 가지냐라는 건데, 이 3번째 조건을 완벽하게 이해 못해서 그런지 모르겠음
결론: 클래스로 나눠야함
2. 생성자 -> 초반에 클래스에 값을 넣어주지 않으면 작동하지 않는가?
->문자열을 숫자로 변환하는 클래스는 필요함, 허나 소수를 확인하는 클래스는 문자열을 숫자로 변환하는 클래스에서 가져오므로 이것도 필요함 ㅋㅋ

1,2 피드백
1-1 : 숫자가 합쳐져 카운팅되는 것은 단순 결과일 뿐이다. 1-1은 응집도가 있는 지 물어보는 문장이다. 따라서 내가 설명한 것은 데이터 응집도가 아니다. 이 문제에서 진정으로
묶여야 할 데이터는 내가 지금까지 종이 조각을 조합해서 만들어낸 숫자들의 목록이다. 011을 조합할 때 11이 중복으로 만들어지는 것을 방지 하기 위해 생성된 숫자들을 Set<Integer>라는
하나의 덩어로 묶어서 관리해야하며 이것이 객체의 상태가 된다

1-2 : 논리는 맞지만 숫자를 조합해 내는 행위와 소수인지 검증하는 행위라는 두가지 명확한 책임이 존재, 실무에서는 이 두 책임을 하나의 클래스로 섞지 않음

1-3 : 명사가 속성을 가지는가? -> 도메인 모델링을 말하는 것이다
내 논리는 : 넘버가 행위값을 가지냐는 건데 -> 시야가 좁다.
교정: 자꾸 numbers라는 문자열 데이터 자체를 명사로 보려니깐 막힘. 현실 세계의 기계를 떠올려봐라.
명사:NumberGenerator(숫자를 생성하는 기계)
속성(필드): Set<Inetger> generateNumbers (이 기계가 중복을 걸러내기 위해 내부에 기억하고 있는 숫자 보관함)
데이터 쪼가리 numbers가 아니라, 그 데이터를 처리하는 주체 (기계)를 명사로 도출해야한다.

2: 생성자 존재이유
내 논리: 클래스끼리 값을 가져오기위해 필요하다 -> 생성자의 본질을 오해함
교정: 클래스끼리 값을 주고받는 것은 메서드의 역할이다. 생성자의 유일한 목적은 이 객체가 정상적으로 작동하기 위한 필수 초기값을 강제하는것
NumberGenerator 객체는 애초에 종이 조각(String numbers)이 없으면 숫자를 만들어낼 수 없음 따라서
public NumberGenerator처럼 생성자를 통해 강제로 주입받아야함

총평 : 규칙과 행위를 찾아내는 눈은 어느정도 생겼지만 데이터를 기억하는 상태를 객체의 속성으로 연결하는 감각 부족

3.논리 설계 구축하기
이 문제를 풀라면 소수가 어떤 소수 인지 알아야함, 단순이 홀수인 소수이냐, 나눴을때 1과 자기자신 밖에 안나눠지는 소수인지를 파악할 필요가 있음 -> 내 생각엔 후자임
그러면 원래 소수를 판별하는 방법은 반복문을 써 i =2 부터 자기 자신까지 %가 0일때를 구해서 하는 게 좋음 허나 제안 조건에서 numbers가 7이상임 worst case가 9999999이면?
반복문의 시간 복잡도는 i만 생각해도 O(N)일 거 같은데 효율성으로 안좋다고 생각
인터넷에 검색해본 결과 소수를 판별하는 알고리즘은 크게 두개 있다고함
3-1 제곱근을 이용한 소수 판별하기
사용 조건: 하나의 수가 소수인지 확인할때 사용한다.
설명: 어떤 수 N의 제곱근보다 큰 자연수는 그보다 작은 수와 짝을 이루므로 2부터 √n까지만 나누어 떨어지는지 확인
시간 복잡도: o(√N)

3-2. 에라토스테네스의 체
사용 조건: 특정 범위 내의 모든 소수를 한꺼번에 구할 때 사용
설명: 2부터 시작해 배수들을 차례대로 지워나가는 방법
시간 복잡도 : O(NloglogN)

이 문제에서는 에라토스테네스의 체가 좋아 보임-> 문자열에서 가장 큰수까지 에라토스테네스의 체를 돌리고 문자열로 만들수 있는 수가 거기에 있는지만 비교하면 되지 않을까..?
제곱근이 조금 더 괜찮을지도.. 만든 즉시 확인 시키면 되니깐..

3 피드백
마지막에 말한 제곱근-> 이것이 정확한 정답이다
에라토스테네스의 체를 쓰면 공간 복잡도 최적화 실패이다
-> 1.치명적인 메모리 낭비(공간 복잡도)
->numbers가  9999999로 주어졌다고 가정하면, 에라토스테네스의 체를 쓰려면 가장 큰수인 9,999,999까지 담을 수 있는 1천만 칸짜리 boolean 배열을 메모리에 올려야함
우리가 종이 조각으로 만들 수 있는 숫자는 기껏해야 몇백 ~몇천개 수준인데 이를 확인하기 위해 천만 개의 소수여부를 전부 계산하고 메모리에 들고 있는것은 낭비이다
->2. 불필요한 연산(시간 복잡도)
종이 조각 7개로 만들 수 있는 숫자의 모들 조합은 최대 7!에서 자릿수별 조합을 다 합쳐도 몇만 개 채 되지 않는다,
 천만 번 루프를 도는 체를 만드는 것보다 조합으로 만들어낸 그 몇만 개의 숫자들만 그때그때 O(√N)로직에 던져서 판별하는 것이 압도적으로 빠르고 효율

 피드백을 통한 논리 설계 확인하기
 Set<Integer> ? 뭔지 모름 -> 찾아보니 Set<>은  중복을 허용 안하면, 순서 유지가 안되며 , 배열처럼 인덱스를 통한 접근이 불가능하다. , 어디서 공부할 때 들어본 익숙한 느낌 HashSet이였다.
 HashSet은 중복은 허용되지 않으며, Hash의 특성을 가지고 있는 것이다. hashSet 밖에도 LinkedHashSet, TreeSet이 있다. 여기서는 key:value 필요없고, 링크드 리스트로 순선를 찾을 필요도 없다.
 따라서 TreeSet을 써야할 것 같다. 하지만 TreeSet도 의문이다, 정렬된 데이터가 필요하지않다. 사실 hashSet으로 그냥 써도 되지않을까 싶다. key value가 아닌 value만 사용해서
 피드백을 받았을 때 generatorNumber(숫자 생성기), primeValidator(소수 판별기) 이렇게 두개 클래스를 만들어 내는 것이 가장 좋아 보인다.
 그러면 숫자 생성기를 어떤 식으로 만들 것이냐인데 찾아본 결과 조합 재귀 알고리즘이 있다 .
 조합 재귀 알고리즘이란?
 정의: 서로 다른 n개 중에서 순서 없이 r개를 고르는  모든 경우의 수를 재귀 호출을 통해 구하는 방법
 핵심 원리: 조합은 파스칼의 상각형 공식 성질을 이용하거나 DFS(백트래킹) 방식을 통해 현재 원소를 선택하는 경우와 선택하지 않는 경우로 나누어 구현
 종료 조건 : 뽑아야하는 개수가 되거나 인덱스가 배열의 끝에 도달했을 때 결과를 저장하고 리턴
 재귀 호출: 현재 원소를 포함하여 재귀를 돌거 r-1, 현재 원소를 포함하지 않고 다음 원소로 재귀를 돈다.

 우리가 여기서 조합 재귀 알고리즘으로 쓸 수 있는거, 백트래킹 방식으로 현재 원소를 선택하지않는 것으로 점점 선택하는 숫자를 제거하는 방식으로 가는 것 이 좋아보인다 Set으로 중복을 제거하고
 PrimeValidator클래스로 넘겨주는 것이다 이 과정이 한번에 되게 solution 함수에서 설계

피드백...
 조합 백트래킹을 상용할 경우, 조합은 중복이 되어도 상관을 안쓴다. 예를 들어 1,7을 뽑을 때 1,7와 7,1을 같은걸로 취급한다. 즉 1과 7을 뽑았다는 결과만 중요하게 생각한다
 따라서 조합과 비교되는 순열을 해야한다. 종이 조각 1과 7을 뽑았을때 17과 71은 전혀다른 숫자이기에 소수 판별에 결과에도 완전히 달라진다.
 이 문제는 종이 족각의 배치 순서에 따라 다른 숫자가 만들어지므로 조합이 아니라 순열 백트래킹을 사용해야함

순열 설명
순열은 n개의 값 중에서 r개의 숫자를 모든 순선대로 뽑는 경우를 말한다.
예를 들어 1,2,3이라는 3개의 배열에서 2개의 숫자를 뽑는 경우 -> 1,2 , 1,3 , 2,1 , 2,3 , 3,1 , 3,2 이렇게 6개가 된다.

1. Swap을 이용한 순열
첫번째는 swap 함수를 만들어서 배열들의 값을 직접 바꾸는 방법
배열의 첫 값부터 순서대로 하나씩 바꾸며 모든 값을 한번씩 swap
depth 를 기준 인덱스로 하여 depth보다 인덱스가 작은 값들은 그대로 고정하고, depth보다 인덱스가 큰 값들만 가지고 다시 swap을 진행한다.
depth보다 인덱스가 큰 값들만 가지고 다시 swap을 진행순
-> 쉽게 생각하면 자리를 고정해두고 나머지 값들끼리만 자리를 바꾼다.
2.Visited 배열을 이용한한 순열
swap과 달리 사전식으로 순열을 구현 할 수 있다.
 arr: r개를 뽑기위한 n개의 값
 output: 뽑힌 r개의 값
 visited : 중복해서 뽑지 않기 위해 체크하는 값

 DFS를 돌면서 모든 인덱스를 방문하여 output 에 값을 넣는다
 이미 들어간 값은 visited 값을 true로 바꾸어 중복하여 넣지 않도록한다.
 depth 값은 output에 들어간 숫자의 길이라고 생각
 depth의 값이 r만큼 되면 output에 있는 값을 출력
 그러면 이 문제를 풀기 위해서는 순열 visited 방식을 사용해서 중복을 넣지 않게 해야한다 .
boolean[] visited와 문자열을 정수열로 바꾸는 Integer.parseInt() 변환 후 hashSet에 넣기

 */

class numberGenerator {
    private final String numbers; //원본 종이 조각 문자열
    private  final boolean[] visited; //어떤 위치에 종이 조각이 사용했는지 기억할 방분 체크 배열
    private  final Set<Integer> NumberGenerator; //중복없이 완성된 숫자를 담는 배열

    //생성자 생성
    public numberGenerator(String numbers){
        this.NumberGenerator = new HashSet<>();
        this.numbers = numbers;
        this.visited = new boolean[numbers.length()];
    }

    public Set<Integer> generate(){
        //외부에서 숫자 생성기 기계의 버튼을 누르는 역할입니다. 내부적으로 빈 문자열 ""을 시작으로 재귀 함수를 호출하고, 최종 완성된 Set을 반환합니다.
        dfs("");
        return NumberGenerator;
    }
    private void dfs(String currentNumber){
        //실제 순열(백트래킹) 로직이 돌아가는 핵심 재귀 메서드입니다. 외부로 노출할 필요가 없으므로 private으로 닫아둡니다.
        //1(저장). 현재까지 만들어진 currentNumber(조각)가 빈 문자열("")이 아니라면 정수로 변환하여 set에 저장
        if(!currentNumber.isEmpty()){
            NumberGenerator.add(Integer.parseInt(currentNumber));
        }
        //2(순회). 원본 numbers의 길이 만큼 for문을 돌며 종이 조각을 하나 씩 확인
        for(int i =0; i<numbers.length(); i ++ ){
            //3조건. 만약 visited[i]가 false라면?, 즉 i번째 종이 조각(숫자)를 안썼다면?
            if(!visited[i]){
                //4. true로 바꾸고 dfs(현재 숫자+ 아직 안쓴 숫자 붙여서 재귀함수 호출), 그후 다른 조합을 위해 다시 false로 변경
                visited[i] = true;
                dfs(currentNumber + numbers.charAt(i));
                visited[i] = false;
            }
        }

    }
}
class PrimeValidator{
    /*
    private final List<numberGenerator> number;

    public PrimeValidator(List<numberGenerator> number){
        this.number =number;
    }
    싹다 받아와서 할려고 했는데 클래스는 하나에 역할을 할 때 가장 이쁠 거 같음..
     */
    public boolean isPrime(int number){
        //예외처리 0이거나 1이면 소수가 아니므로 F
        if(number == 0 || number == 1){
            return false;
        }
        //제곱근의 원칙 i가 제곱근까지 반복문을 돌린다
        for(int i = 2; i <= Math.sqrt(number); i ++ ){
            //만약 number가 i로 나누어 떨어지면 그건 소수가 아님
            if(number % i ==0){
                    return  false;
            }
        }
        return true;
    }



}
public class testFindPrimenumber {
    //자 그러면 이제 solution에서 위에 있는 클래스를 써서 해야겠지?
    public int solution(String numbers) {
        int count = 0;
        //일단 객체 생성
        PrimeValidator prime = new PrimeValidator();
        numberGenerator ng = new numberGenerator(numbers);
        Set<Integer> generatedNumbers = ng.generate();
        for(Integer number: generatedNumbers){

            if(prime.isPrime(number)){
                count ++ ;
            }

        }

        return  count;
    }

    public static void main(String[] args) {
        String num = "17";
        testFindPrimenumber fp = new testFindPrimenumber();
       System.out.println(fp.solution(num));
    }
}
