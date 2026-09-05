package codingTest.exhaustiveSearch;

import java.util.Arrays;

/*
Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
예시
brown:10, yellow:2 return: [4,3]
brown: 24, yellow: 24 return: [8,6]
제안 사항
제한사항
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다
논리설계 및 객체지향
일단 카펫의 총 개수는 브라운 + 노랑이다.
노랑은 무조건 가운데에 배치된다. 노랑을 가로 배치를 계속한다고 가정했을때, 가로길이는 노랑의 개수 + 2(양쪽 꼭지점)이다.
세로길이는 노란색은 가로로 길게 배치한다고하였으니깐 1+ 2(위 아래 꼭지점) = 3으로 고정되지 않을까..?
하지만 예시 24,24에서 이 논리는 틀렸다.
노란색의 가로세로 길이를 생각해보자
일단  W(전체가로길이)-2, H(전체세로길이)-2 이다.
따라서 노랑색 개수는 (w-2) * ( h-2) 이다.
또한 카펫의 총 개수는 W * H 이므로 W와 H는 총 개수의 약수 관계가 된다.
그러면 카페의 총 개수(total)의 약수를 찾은다음 그 약수들을 가로, 세로로 지정하고 각각 -2를 해서 곱해서 노랑total과 같은걸 찾는다면? 그것이 가로 세로 아닐까?
이때 제약 조건을 생각해 봐야한다. 일단 노랑의 최솟값은 1, 따라서 H는 최소 3은 되어야한다.
또한 제안 사항에 W>= H 이여야한다.
반복문을 사용할때 제곱근을 사용해서 약수를 찾으면된다. √total 까지 했을 때 약수를 다 찾을 수 있기 떄문이다. 또한 만약 제곱근보다 크다면 W>=H 제안사항을 위배 될것이다 .
이제 객체 지향 및 생성자를 생각해봐야한다.
객체지향
1. 두 개 이상의 데이터가 하나로 묶여서 하나의 의미를 하는가 -> 이 부분은 응집도를 뭍는 것이다 가로 와 세로가 합쳐서져서 토탈이 되고, 토탈의 약수를 관리해야하므로 이 부분은 맞다.
2. 행위나 규칙이 있는가? -> 제안 사항도 있지만, 노랑의 개수는 H,W의 각각 -2 후 곱해야하고, H,W는 total의 약수라는 규칙이 있어 total에서 약수를 찾는 행위가 있으며, 그 약수의 -2를 해서 곱한 값이
노랑의 개수와 같은 지 확인해 보는 행위가 있다.
3. 명사가 속성을 가지는 가? -> 이 의문문은 도메인 모델링을 말한다. 클래스를 만들 때 그 클래스가 기계라고 생각하자 그러면 나는 어떤 기계를 만들어야할까?
3-1-> 일단 total 과 total의 약수로 가로, 세로를 만드는 약수를 구해 List로 만들어주는 기계, 그리고 그 List를 받아서 노랑 개수와 비교해줄 기계
-> 생성해도 될 거 같다.
그러면 각각 생성자를 만들기 전에 기능들을 클래스로 분배를 해보자
FindWH -> total 계산하고, 가능한 W,H을 List[][]로 보내줄 클래스
FindYellow -> for-each로 list<>에서 하나씩 꺼내서 (list[0] -2) * (list[1] -2) == yellow인지 확인하는 클래스
이렇게 보니 어차피 둘다 yellow 개수는 필요하다 따라서 클래스는 합치는게 나아보인다.
생성자
FindWH로 합쳤다고 했을 때 이 클래스가 어떤 데이터가 없으면 실행이 불가능할까를 생각해본다. brown, yellow가 없으면 아무것도 못하지 않나?
그러면 외부로 brown과 yellow를 받고 내부에선 어떤게 필요한가? 일단 가로세로가 저장될 int[][] or List[][]인데 List[][]라는 문법이 있나? 없을듯
그리고 기본적으로 total, Height, width 가 필요할 것이다.

피드백:
클래스 이름: FindWH 행위를 나타내기 때문에 메소드 이름에 어울린다. CarpetSizeFinder 이런 느낌이 명사느낌으로 좋다
List[][] -> 이런건 없다 보통 List<int[]> 이렇게 사용한다. 가로 세로가 응집도가 높은 걸 판단했으니
class Carpet {
int width;
int height;
}
List<Carpet>;
이런식으로 관리하는 게 객체지향적 심화이며 이상적이다.
하지만 여기서는 w, h를 반환하고 끝이고, 추가적인 관리가 필요없어 List<> 에 담지 않고 new int[] {w,h}로 사용하는 것이 메모리 관리에 좋다.
height. width-> 객체의 필드(상태)로 남겨야 할 데이터와, 메서드 안에서 쓰고 버릴 지역 변수를 구분해야 한다.
필드(상태): 생성자를 통해 주입받는 brown, yellow와 이를 통해 계산되는 total은 기계가 기억해야 할 상태다.
지역변수: width와 height는 탐색 과정(for문)에서 계속 변하는 임시 값이다. 굳이 기계의 상태(필드)로 저장할 필요 없이 메서드 안에서 선언하고 쓰고 버리면 된다.
클래스는 완성되었다.
이름: CarpetSizeFinder
필드: brown, yellow, total
생성자: brown, yellow 두 개를 외부에서 받아서 필드에 있는 애들 초기화
메서드: public int[] calculate()
->H=3 부터 √total까지 H++
-> total % h == 0으로 약수를 찾고 w = total / h 로 w를 찾고
-> yellow == (w -2) * (h-2) 인지 확인 후 맞으면 return new int[] {w,h}으로 마무리

 */
class CarpetSizeFinder{
    final int brown;
    private final int yellow;
    private final int total;
    //생성자 주입
    public CarpetSizeFinder(int brown, int yellow){
        //예외처리
        if (brown < 8 || yellow < 1) {
            throw new IllegalArgumentException("카펫의 크기 조건이 유효하지 않습니다.");
        }
        this.brown =brown;
        this.yellow = yellow;
        this.total = brown + yellow;
    }
    //메서드 생성
    public  int[] calculate(){
        for(int h=3; h <=Math.sqrt(total); h++){
            if(total % h == 0){
                int w = total / h;

                if(yellow == (w -2) * (h -2)){
                    return new int[] {w, h};
                }
            }
        }
        throw new IllegalArgumentException("조건의 맞는 가로, 세로를 찾지 못했습니다.");
    }
}
public class TestCarpet {
    public int[] solution(int brown, int yellow){
        CarpetSizeFinder sizeFinder = new CarpetSizeFinder(brown,yellow);
        return sizeFinder.calculate();
    }

    public static void main(String[] args) {
        int a = 24;
        int b = 24;
        TestCarpet carpet = new TestCarpet();
        System.out.println(Arrays.toString(carpet.solution(24,24)));
    }
}
