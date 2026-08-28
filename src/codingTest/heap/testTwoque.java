package codingTest.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
코테 문제:
이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
명령어: 설명
I 숫자 :큐에 주어진 숫자를 삽입합니다.
D 1: 큐에서 최댓값을 삭제합니다.
D -1: 큐에서 최솟값을 삭제합니다.
이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return

생각하기
객체지향적으로 생각해보기
1. 두 개 이상의 데이터가 하나의 의미로 묶어 다닐때 -> X,하나의 String[]만 받음
2. 데이터뿐만 아니라 규칙(행위)가 필요할때 -> O 명령어 3가지가 있음
3.문제 설명의 명사가 속성을 가질 때 -> 속성은 없는 거 같음
2번이 해당되어 class를 만들어함 그러면 어떻게 만들어야할까?
class operation{} ->이렇게 해서 각 명령어가 어떻게 들어오는거에 따라서 return 다르게 해야하나?
생성자는..?
일단 solution 함수 우선순위 큐를 만들고 크기는 미정, String[]에서 한개씩 꺼내서 명령어 확인 이건 클래스로 뭐 해야하지 않을까? 익숙하지 않아서 어렵네

오류 수정:
객체지향 분석 교정
1. 두개 이상의 데이터가 하나의 의미로 묶어 다닐 때 -> O
단순한 String 하나라고 생각했지만, 안을 들여다보십시오. "I 16", "D 1"은 사실 연산자(I,D)와 '숫자(16,1)라는 두 개의 명확한 데이터가 공백을 기준으로 묶여있는 세트다.
따라서 이 문자열을 파싱해서 operation, value 나누어 들고 있는 Command 객체로 분리할 수 있다.
3. 문제 설명의 명사가 속성을 가질 때
문제 제목부터 '이중 우선순위 큐'이다
이 큐는 내부에 숫자들을 저장한다 -> 상태(속성)를 가지고, 삽입, 최댓값 삭제, 최솟값 삭제라는 행위(메서드)를 가진다

3번 보충 설명
1.명사'의 진짜 의미: 데이터가 아니라 '역할을 가진 주체'
이전 문제의 Job은 누가 봐도 [요청 시간, 소요 시간]이라는 눈에 띄는 '데이터'였습니다. 그래서 묶기 쉬웠습니다.
하지만 이번 문제에서 '명사'는 데이터가 아니라 '이중 우선순위 큐(Double Priority Queue)'라는 하나의 기계(시스템)입니다.
원시적 사고: solution 메서드 안에 자바가 기본 제공하는 PriorityQueue 두 개를 지역 변수로 띡 만들어 놓고, if-else문으로 조작한다.
객체지향 사고: "아, 이 문제는 일반적인 큐로 해결이 안 되는구나. 그럼 '최댓값과 최솟값을 동시에 뽑을 수 있는 특수한 큐'라는 기계를 내가 직접 명사(클래스)로 정의해야겠다."

2. '속성'의 진짜 의미: 객체가 '기억해야 할 상태'
클래스가 가져야 할 '속성(필드)'이 반드시 int age, String name처럼 단순한 값일 필요는 없습니다.
이중 우선순위 큐라는 기계가 정상 작동하려면 '현재까지 입력된 숫자들'을 내부에 기억하고 있어야 합니다.
즉, 이 클래스의 속성(필드)은 List<Integer>가 될 수도 있고, PriorityQueue<Integer> 두 개(Max-Heap, Min-Heap)가 될 수도 있습니다. 이것이 바로 객체의 '상태(속성)'입니다.
3.일급 컬렉션(First-Class Collection)'
지금 요구하는 설계가 바로 우아한테크코스 프리코스 2주 차부터 귀에 못이 박이도록 듣게 될 '일급 컬렉션' 패턴입니다.
List나 Map, PriorityQueue 같은 자바의 기본 자료구조를 외부(solution 메서드)에 날것 그대로 노출시키지 않고, 하나의 클래스 내부 속성(필드)으로 숨기는(캡슐화) 기법입니다.
외부에서는 이 기계 안에 숫자가 리스트로 저장되어 있는지, 트리로 저장되어 있는지 알 필요가 없습니다. 오직 기계에 달린 3개의 버튼(insert, deleteMax, deleteMin)만 누르면 됩니다.

1. 명사 = '기계' 그 자체
자판기는 눈에 보이는 하나의 사물(명사)입니다.
우리가 만들어야 할 '이중 우선순위 큐' 역시 단순한 데이터 쪼가리가 아니라, 숫자들을 넣고 빼는 하나의 '가상의 기계(명사)'라고 생각하십시오.
기계니까 당연히 클래스(class DoublePriorityQueue)로 만들어야 합니다.

2. 속성(필드) = 기계가 '기억'해야 할 데이터
자판기가 제대로 작동하려면 내부적으로 무언가를 기억하고 있어야 합니다.

자판기의 속성: "현재까지 들어온 동전 총액", "남은 콜라 재고량"

이중 우선순위 큐 기계의 속성: "지금까지 사용자가 밀어 넣은 숫자들의 목록"
이 기계는 들어온 숫자들을 어딘가에 보관하고 있어야 최댓값이든 최솟값이든 뽑아낼 수 있습니다. 이 보관함(자료구조)이 바로 클래스의 '속성(필드)'이 됩니다.

3. 행위(메서드) = 기계 겉면에 달린 '버튼'
자판기 안의 부품이 어떻게 생겼는지 우리는 알 필요 없습니다. 겉에 달린 버튼만 누르면 됩니다.

자판기의 버튼: [동전 넣기], [음료 뽑기], [잔돈 반환]

이중 우선순위 큐 기계의 버튼: 문제에서 주어진 3가지 명령어입니다. [숫자 넣기(I)], [최댓값 빼기(D 1)], [최솟값 빼기(D -1)]

뼈대
class DoublePriorityQueue {
    // 1. 속성(필드): 들어온 숫자를 기억할 보관함 (내부 부품)
    // (예: PriorityQueue 두 개를 쓰든, ArrayList를 쓰든 여기에 선언)

    // 2. 행위(메서드): 기계 밖에서 사용자가 누를 수 있는 3개의 버튼
    public void insert(int number) {
        // 숫자 넣는 로직
    }

    public void deleteMax() {
        // 최댓값 빼는 로직
    }

    public void deleteMin() {
        // 최솟값 빼는 로직
    }
}

찾은 내용을 보면 이중 우선순위큐가 명사 즉 class 되는 거 같다. 클래스 안에는 최댓값, 최솟값을 위한 두개의 우선순위 큐를 설계해 놓고, insert, delete_max, delete_min을 만들면 될 거 같다
이때 두개의 우선순의 큐는 서로 동기화 되어야 한다.
방법 1. (자바 내장 remove 활용): 한쪽 큐에서 꺼낸 값을 다른 쪽 큐에도 pq.remove(value)로 즉시 지워준다 (단점:remove(Object)는 내부 요소를 선형 탐색하므로 O(n)시간 복잡도 발생
방법 2.(TreeMap 활용 - 실무 추천) 내부적으로 자바의 TreeMap<Integer, Integer>(레드 -블랙 트리 기반, 값-개수 매핑)을 사용하여 최댓갓(lastKey()), 최솟값(firstKey())을 모두 OlogN으로 시간복잡도 발생
TreeMap: 이진트리를 기반으로한 Map 컬렉션

TreeSet과의 차이점 TreeSet은 그냥 값만 저장한다면, TreeMap은 키와 값이 저장된 Map, Entry 저장한다 하지만 여기서는 TreeMap을 사용하는 진짜 이유는 중복 숫자 처리 때문이다
중복된 숫자가 들어오면 숫자 한개는 들어와야하지만 TreeSet을 쓰면 한번에 지워지고 중복이 안되기 때문이다.
TreeMap에 객체를 저장하면 오름차순으로 정렬된다. 타입이 숫자일 경우 값으로, 문자열일 경우 유니코드를 사용한다.
정렬 순서는 기본적으로 부모 키값과 비교해서 키값이 낮은 것은 왼쪽 자식 노드에 키 값이 높은 것은 오른쪽 자식 노드에 Map.Entry 객체를 저장한다.
TreeMap은 HashMap보다 성능이 떨어진다 하지만 정렬된 상태로 Map을 유지해야 하거나 정렬된 데이터를 조회해야 하는 범위 검색이 필요한 경우 HashMap을 사용하는게 효율적이다.
선언 방식 :TreeMap<Integer,String> map1 = new TreeMap<Integer,String>();//TreeMap생성
값추가: map.put(1,"사과")
삭제: map.remove(1) key 값 1제거, clear() 모든값을 제거
출력: System.out.println(map) 전체 출력
     System.out.println(map.get(1)) key value print
     System.out.println(map.firstEntry()) 최소 엔트리 출력
     System.out.println(map.firstKey()) 최소 key 출력
     System.out.println(map.lastEntry()) 최대 엔트리 출력
     System.out.println(map.lastKey()) 최대 key 출력
TreeMap 설계: key(Integer): 실제 들어온 숫자 값,value(Integer): 해당 숫자가 들어온 개수(빈도수, count)
클래스 설계
명사:DoublePriorityQueue 클래스
속성: TreeMap<Integer, Integer> map
메서드:
insert(num) : map.put(num, map.getOrDefault(num, 0) + 1)
deleteMax(): map.lastKey()를 조회하여 개수 차감 또는 remove
deleteMin(): map.firstKey()를 조회하여 개수 차감 또는 remove
getResult():비어있으면 [0,0] 아니면 [map.lastKey(), map.firstKey()]
 */
class DoublePriority{
    //캡슐화를 위한 private final 삽입
    private final PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> minpq = new PriorityQueue<>();

    //생성자 생성하기
    /*String operation;
    int num;
    public DoublePriority(String operation, int num){
        this.operation = operation;
        this.num = num;

    }
    생성자 필요 없음 DoublePriority는 숫자를 담아두는 큐이므로 특정 명령어나 숫자를 가지고 태어날 이유가 없기 때문  -> 이 클래스에서는 operation, num 같은 필드와 해당 생성자가 필요 없음
     */
    //기능 세개 구현 하기
    public void insert(int num){
        maxpq.offer(num);
        minpq.offer(num);
    }
    public void deleteMax(){
        if(maxpq.isEmpty()){
            return;
        }
        int maxVal = maxpq.poll();
        minpq.remove(maxVal);
    }
    public void deleteMin(){
        if(minpq.isEmpty()){
            return;
        }
        int minVal = minpq.poll();
        maxpq.remove(minVal);
    }
    public int[] getResult(){
        if(maxpq.isEmpty()){
            return new int[] {0,0};
        }
        return new int[]{maxpq.peek(), minpq.peek()};
    }
}
public class testTwoque {
    /*
    2번째 논리 설계 operation 형태는 ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"] 즉 공백 기준으로 나눠서 D인지 I인지 확인후 뒤에 나오는 문자열을 숫자로 만들어서
    조건문을 만들어서 삽입 삭제를 구현하면 될 것같다
    구현 예제(필요한 스킬)
    str.split(" ");
    int arrInt = Integer. parseInt(stringA)
     */
    public int[] solutionTwoque(String[] operations){
            //클래스 호출해서 객체 생성 여기서 pq는 메모리 스택에 들어가며 new DoublePriority는 메모리 힙 부분에 들어간다.
            DoublePriority pq = new DoublePriority();
//            operations에서 한개씩 꺼내서 oper에서 넣어서 공백기준으로 나눠서 저장하기
            for( String oper : operations){
                //split 문자열 배열을 만든어 공백 기준으로 [0]은 문자열이 들어가고 [1]은 숫자가 들어간다
                String[] split = oper.split(" ");
                String command = split[0];
                int number = Integer.parseInt(split[1]);
                //            조건문 형성하기 앞에 command 부분에서 I인지 D인지 확인한다.
                if ("I".equals(command)) {
                    pq.insert(number);
                } else if ("D".equals(command)) {
                    if(number == 1){
                        pq.deleteMax();
                    } else if (number == -1) {
                        pq.deleteMin();
                    }
                    //예외 처리 해야하지 않나 실무에서는 throw new IllegalArgumentException("지원하지 않는 옵션입니다.")이렇게 예외처리를 함
                }
            }
        return pq.getResult();
    }
}
