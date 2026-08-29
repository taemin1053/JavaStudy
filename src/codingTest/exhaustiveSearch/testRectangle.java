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
    //card 객체는 카드에 최대, 최소 값을 wallet클래스에게 넘겨 주는 역할이다. 가로,세로 선언
    private final int width;
    private final int height;

    //Card가 초반에 값이 없어도 클래스가 유지 될 수 있는 지 상상해보자
    // -> X 이유: 카드는 초반에 가로 세로가 있어야지 최대 최소를 확인할 수 있는 메서드를 선언할 수 있다. 또한 Card의 생성자가 없으면 Wallet 클래스에서 가로 세로를 일일이 size 배열에서 기억해야한다.
    public Card(int width, int height){
        this.height = height;
        this.width = width;
    }
    //이제 가로 세로에 최대 최소를 확인해 본다 이때 명한은 돌릴 수 있으므로 가로와 세로를 비교하면서 최대 최소를 확인한다.
    //클래스 내에서 가로,세로를 정의했으므로 메서드 ()를 비웠다
    public int getLong( ){
        return Math.max(this.height, this.width);
    }
    public int getShort() {
        return Math.min(this.height, this.width);
    }
    //여기서 card 클래스의 역할은 종료
}
class Wallet{
  //자바의 제네릭 List<card> cards-> 우리가 만든 card 객체들을 담는 리스트, // 1. 공간만 선언 (아직 new ArrayList 안 함)
    //Wallet 클래스는 card 클래스에 있는 가로 세로를 가져와야한다. 그러면 그 가로,세로를 담는 바구니가 필요하다.
    // -> List로 담는 것이 좋아보인다 이유:List<Card> cards는 인터페이스(타입 규격)를 선언한 것이고 실세 solution에서 만든 것은 new ArrayList<>() 이다
    //List로 선언하는 진짜 이유는 다형성(유연성) 때문이다 ArrayList 대신 linkedList 등으로 구현체를 바꿔도 Wallet 코드는 수정하지 안도록하기 위함이다.
    List<Card> cards; //List의 타입은 미리 선언해놓은 가로세로를 두개 다 담을 수 있는 Calss Card를 담는다.
    //List를 선언했으니 이제 Wallet이 생성자가 필요한지 생각해본다 ->O wallet은 Card안에 있는 객체를 사용한다. Wallet에 생성자를 둔 이유는
    // 명함 리스트(cards)가 없는 깡통 지갑 객체가 메모리에 만들어지는 것을 방지하기 위함이다. 초기 데이터를 강제하는것을 방지
    // , 또한 최소 지갑 크기를 구하는 getMinArea를 선언할 수 없게된다
    public Wallet(List<Card> cards){
        this.cards =cards;
    }
    //이제 생성자를 만들었으니 getMinArea를 생성한다.
    public int getMinArea(){
        //생각해보자 어차피 가로,세로 최대 최소 길이는 Card 클래스에서 이미 완료 되었다.그러면 wallet에서는 List에 있는 card들의 최대 최소만 비교해주면 되기만 한다.
        //일단 반복문을 생성한다 List에서 한개씩 꺼낼수 있게
        int maxLong = 0;
        int maxShort = 0; //초기값을 설정 짧은 변들 중 가장 큰값
        //cards라는 리스트에 객체를 꺼낼때 를 생각해보자 List안에는 Card라는 객체가 있다 그러므로 Card 객체를 card라고 부르며 꺼내겠다라고 반복문을 생성한다
        for(Card card : cards){

            maxLong = Math.max(maxLong, card.getLong());
            maxShort = Math.max(maxShort, card.getShort());

        }
        return maxLong * maxShort ;
    }
    //Wallet 클래스의 역할은 끝났다 이제 이걸 총 관리할 솔류선 클래스 만들어보자



}
public class testRectangle {
    public int solution(int[][] sizes) {
        // 여기서 실제로 바구니를 새로 생성 (new)
        //Wallet 클래스에서 List는 만들었지만 생성을 안했다 그 이유는 solution 모든 기능을 담은 클래스가 호출되었을 때 생성하기 위해서다
        List<Card> cards = new ArrayList<>();
        // 원시 데이터(2차원 배열)를 의미 있는 도메인 객체(Card)로 변환하여 리스트에 적재
        //위 주석 말대로 이제 2중 배열인 sizes를 List<Card>에 맞쳐서 cards라는 card객체를 담은 List에 넣는다
        //sizes를 생각해보자 배열은 2중 배열이지만 가로, 세로 각각 들어가 있다. 그러면 sizes[1]을 가져오면 size[1]인덱스에 가로, 세로 모두 가질수 있다. 하지만 card는 객체이지만 size는 배열이다.
        //그러면 타입을 int[]로 선언하고 size로 쓰기로 한다. ->내가 말하지만 이해가 안됨 추가 설명이 필요할듯
        for(int[] size :sizes){
            //여기서 고급스킬로 list에 넣음과 동시에 size의 대한 정보를 Card에 선언하고 넣어야한다.
            cards.add(new Card(size[0],size[1]));
        }
        //이제 cards 배열에 다 넣었으니 우리가 고대하던 Wallet 객체를 선언해서 리턴만 해주면 된다.
        Wallet wallet = new Wallet(cards);
        return wallet.getMinArea();


        //for(Card card: cards)와 차이 -> 지금 내가 열어보고 있는 바구니(컬렉션) 안에 무엇이 들어있는가? -> 알맹이의 타입만 다르다
        //2차원 배열 -> 1차원 배열들을 여러 개 담아둔 큰박스 , 알맹이: 큰 박스에서 하나를 쏙 꺼내면, 숫자가 아니라 1차원 배열이 나온다
        //for(Card card: cards) -> Card 객체들을 여러개 담아둔 리스트 바구니, 알맹이: 바구니에서 하나를 꺼내면 , 기본 숫자가 아니라 Card 객체 1개가 나온다

    }

    public static void main(String[] args) {
        int[][] arr = {{60, 50},{30, 70},{60, 30},{80, 40}};
        testRectangle tr = new testRectangle();
        System.out.println(tr.solution(arr));
    }
}

