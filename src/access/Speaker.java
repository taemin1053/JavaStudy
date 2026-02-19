package access;

//스피커에 들어가는 소프트웨어 개발, 스피커 음량은 100을 넘으면 안된다.
public class Speaker {
    private int volume;
//private를 사용해서 Speaker 클래스 내부에 volume을 숨겼다.
    Speaker(int volume) {
        this.volume = volume;
    }
    void volumeUp() {
        if (volume >= 100) {
            System.out.println("음량을 증가 시킬 수 없습니다. 최대 음량입니다.");
        } else {
            volume += 10;
            System.out.println("음량을 10 증가 시켰습니다.");
        }
    }
    void volumeDown(){
            if (volume == 0){
                System.out.println("음량이 이미 0입니다.");
            }
            else {
                volume-=10;
                System.out.println("volumeDown 호출 ");
            }
    }
    void showVolume(){
        System.out.println("현재 음량: "+volume);
    }

}
/*접근 제어자 종류
* private: 모든 외부 호출을 막는다.
* default(package-private): 같은 패키지안에서 호출은 허용된다.
* protected: 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다.
* public: 모든 외부 호출을 허용한다.
* private -> default -> protected -> public 순으로 차단 강도가 낮아진다.
* */


