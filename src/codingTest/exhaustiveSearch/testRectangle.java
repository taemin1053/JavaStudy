package codingTest.exhaustiveSearch;
/*
문제
모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.

논리설계 및 객체 지향
1. 2개 이상 데이터가 묶여 하나의 의미로 다니나 -> O 가로,세로는 서로 묶여있음
2. 행위나 규칙이 필요한가 -> 가로세로 최대,최소값을 구해내야함
3. 명사가 속성을 가지나  -> 모르겠음 직사각형이 가로 ,세로를 가짐
가로는 최대값을 구하고 세로는 최솟값을 구해 가로 * 세로해서 return
회전했을 때 기장 긴변, 가장 짤을 변을 구함
1. Card (명함): 각 명함의 가로/세로 길이를 가지며, 회전을 고려해 '긴 변'과 '짧은 변'을 제공하는 책임을 가짐.
2. Wallet (지갑): Card 객체들의 묶음(일급 컬렉션)을 관리하며, 모든 명함을 담을 수 있는 최소 면적을 계산하는 책임을 가짐.

Card와 Wallet으로 나눈 이유 생각해보기
객체를 쪼개는 유일한 기준은 "이 행동을 누가 하는 것이 가장 자연스러운가?(책임)" 입니다.
Solution 클래스(메인 함수) 혼자서 2차원 배열을 까보고, 90도 돌려보고,
최대/최소값까지 갱신하는 '모든 일'을 다 해야 합니다. 이건 똑똑한 객체들이 협력하는 게 아니라, 중앙 통제실 혼자 막노동을 하는 절차지향 코드가 됩니다.

List<Card>는 어떻게 작동하고 있는가
List에 특별한 의미를 부여할 필요 없습니다. 현실 세계의 '집게'나 '고무줄'이라고 생각하십시오.

명함(Card)들을 한 장씩 새로 만듭니다 (new Card(...)).

이 낱장들을 지갑(Wallet)에 그냥 던져줄 수는 없으니, List<Card>라는 바구니에 차곡차곡 담습니다.

지갑을 만들 때(new Wallet(cards)), 이 바구니를 통째로 넘겨줍니다.

지갑은 내부적으로 이 바구니를 쥐고 있다가, 면적을 계산할 때 바구니에서 명함을 한 장씩 꺼내보며(for(Card card : cards)) 자신의 크기를 결정합니다.
클래스 구분 내용 추가
그룹화 찾기 (일급 컬렉션): "
이 객체들이 여러 개 모였을 때 새로운 의미나 로직이 생기는가?" -> 명함들이 모여야 '최소 지갑 크기'를 구할 수 있다. -> 명함 리스트를 관리하는 Wallet 객체를 만들자.
 */

import java.util.ArrayList;
import java.util.List;

class Card{
    private final int width;
    private  final int height;

    public Card(int width, int height){
        this.height = height;
        this.width = width;
    }
    //회전했을 때까지 생각해서 가로세로 긴거 작은거 리턴
    public int getLongSide(){
        return Math.max(this.height, this.width);
    }
    public int getShortSide(){
        return Math.min(this.height, this.width);
    }
}
class Wallet{
    private final List<Card> cards; //자바의 제네릭 List<card> cards-> 우리가 만든 card 객체들을 담는 리스트, // 1. 공간만 선언 (아직 new ArrayList 안 함)

    public Wallet(List<Card> cards){
        this.cards =cards;
    }
    public int getMinArea(){
        int maxLongSide =0;
        int maxShortSide = 0;
    for(Card card : cards){

        maxLongSide = Math.max(maxLongSide , card.getLongSide());
        maxShortSide = Math.max(maxShortSide, card.getShortSide());
    }
    return maxLongSide * maxShortSide;
    }

}
public class testRectangle {
    public int solution(int[][] sizes) {
        // 여기서 실제로 바구니를 새로 생성 (new)
        List<Card> cards = new ArrayList<>();
        // 원시 데이터(2차원 배열)를 의미 있는 도메인 객체(Card)로 변환하여 리스트에 적재
       for(int[] size: sizes){
           cards.add(new Card(size[0], size[1]));
       }
        // 지갑 객체에 명함 리스트를 주입하고, 면적 계산 로직을 위임(호출)
       Wallet wallet = new Wallet(cards);
       return wallet.getMinArea();
    }

    public static void main(String[] args) {
        int[][] arr = {{60, 50},{30, 70},{60, 30},{80, 40}};
        testRectangle tr = new testRectangle();
        System.out.println(tr.solution(arr));
    }
}

