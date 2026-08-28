package codingTest.arraySort;

import java.util.Arrays;

/*
문제
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

논리 설계
우선순위큐를 사용하면 되지 않나 생각이 들긴함 원시 코드로는 반복문으로 i~j까지 해서 비교하면서 정렬하면 될거 같음 시간복잡도는 O(N)일거 같음
캡슐화, 객체 지향적으로 생각해보기
오답 수정: i부터 j까지 길이를 M이라고 할 때 이 구간을 정렬하는 행위는 O(C(time)MlogM)임
 우선 순위 큐 도입 비효율성: M개의 원소를 자른 뒤 정렬할 때는 단순 배열 정렬(Dual-Pivot Quicksort(듀얼 피벗 퀵정렬)이 오버헤드가 적고 빠름

객체지향 설계 조건 분석
1. 두 개 이상의 데이터가 하나의 의미로 묶어 다닐때 -> i와 j는 묶여다니긴함 , 둘중에 하나라도 없으면 문제를 풀지 못함
2. 데이터뿐만 아니라 규칙(행위)가 필요할때 ->정렬이라는 행위가 필요하고, 마지막 k번째 수를 찾는 행위 메서드가 필요함
3.문제 설명의 명사가 속성을 가질 때 -> 이걸 모르겠다 명사 속성 너무 어려움 기계와 작동버튼... Array와 정렬버튼, k번째 찾기 버튼..?

오답 체크 및 설계
3. 명사: command(명령어) -> 문제에서 [i,j,k]는 단순한 숫자 3개가 아니라 하나의 작업을 수행하기 위한 명령어 객체이다.
   속성: from(i-1, 시작 인덱스),to(j,끝 인덱스), targetIndex(k-1, 찾을 인덱스)
   행위:  public int execute(int[] array), 배열을 넘겨 받아서 내 속성들을 바탕으로 자르고 정렬 하기

생성자 생성 기준
1. 객체가 태어날 때 '필수 재료'가 반드시 필요한 경우
 (불완전한 상태 방지)생성자의 가장 중요한 목적은 객체가 불완전한 상태로 태어나는 것을 막는 것입니다.
 예를 들어, Command 객체는 i, j, k 정보가 없으면 애초에 존재할 이유가 없고 아무 일도 할 수 없습니다.
 기본 생성자로 빈 객체를 만들고 나중에 setFrom(), setTo()로 채우는 방식은 주입을 깜빡했을 때 NPE 등 런타임 에러를 유발합니다.
 필수 값은 생성 시점에 강제로 받도록 잠가야 합니다.
 2. 객체의 상태를 불변(Immutable)으로 만들고 싶을 때 (값 고정)필드를 final로 선언하면, 객체가 생성된 이후 외부에서 값을 절대 바꿀 수 없습니다.
 이 final 필드에 초기값을 할당할 수 있는 유일한 통로가 바로 생성자입니다.
 3. 들어오는 원시 데이터를 객체의 도메인 규칙에 맞게 가공·검증할 때외부에서 들어오는 날것의 데이터([2, 5, 3])를 0-based 인덱스로 보정(i - 1, k - 1)하거나,
 유효성 검사(from < 0 등)를 수행하기에 가장 안전한 장소가 생성자 내부입니다
 .4. 생성자가 '필요 없는' 반대 상황과 비교앞서 만든 DoublePriorityQueue나 testTreeMap처럼 내부 보관함(자료구조)만 쥐고 있고,
 외부에서 값을 주입받아 태어날 필요가 없는 상태 저장형/기계형 객체는 생성자가 필요 없습니다.
  (기본 생성자 사용)판단 공식:"이 객체는 태어날 때 어떤 데이터를 반드시 쥐고 태어나야만 자기 역할을 온전히 수행할 수 있는가?"->YES라면 그 데이터를 매개변수로 받는 생성자를 만듭니다.
 */
//정렬 클래스 구현하기
class Command{
    //필요한 필드 정의
    private final int from;
    private final int to;
    private final int targetIndex;
    //생성자: int[] command 배열을 받아 index 0으로 맞추기,받는 command 형태 {[1,2,1]} 이런형식이라 거기에 맞추기
    public Command(int[] command){
        this.from = command[0] -1;
        this.to = command[1];
        this.targetIndex = command[2] -1;
    }
    public int cutting(int[] array){
/*        Arrays.copyOfRange() 메서드를 사용하는 것이 가장 간편하고 표준적입니다.
          사용 예제 int[] subArr = Arrays.copyOfRange(arr,1,3) ->arr을 인덱스 1부터 인덱스 3까지 자르기
          우리는 커맨더에서 from과 to를 만들었기에 그걸 활용
 */
        int[] cuttingArr = Arrays.copyOfRange(array,from,to);
        Arrays.sort(cuttingArr); //sort를 활용해 정렬하기
        return cuttingArr[targetIndex]; //k번째 숫자 반환하기

    }
}
public class k_maxSort {
    public int[] solutionK(int[] array, int[][] command){
        //command 크기만큼 결과 int[] 배열생성
        int[] answer = new int[command.length];
        //반복문을 돌며 cutting 메소드 호출

        for(int i = 0; i< command.length; i++){
            Command cmd = new Command(command[i]);
            answer[i] = cmd.cutting(array);

        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        k_maxSort ks = new k_maxSort();
        System.out.println(Arrays.toString(ks.solutionK(arr, command)));
    }
}

