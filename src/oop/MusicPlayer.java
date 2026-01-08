package oop;
/*지금까지 만든 플레이어는  데이터와 기능이 분리 되어 있었다.
* 데이터와 기능을 하나로 뮦어 음악 플레이어라는 개념을 온전히 하나의 클래스에 담아보기
* 즉 음악 플레이어라는 객체를 지향해보기
*
* 음악 플레이어
* 속성:volume, isOn
* 기능: on(), off(), volumeUp(), volumeDown(), showStatus() */

public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;
    void on() {
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다..");
    }
    void off() {
        isOn = false;
        System.out.println("음악 플레이어을 종료합니다.");
    }
    void volumeUp() {
        volume++;
        System.out.println("음악 플레이어 볼륨: "+volume);
    }
    void volumeDown() {
        volume--;
        System.out.println("음악 플레이어 볼륨: "+volume);
    }
    void showStatus() {
        if(isOn) {
            System.out.println("플레이어 전원 ON,플레이어 볼륨: " + volume);
        }
        else {
            System.out.println("플레이어 전원 OFF");
        }
        //이 클래스 안에 필요한 속성과 기능을 모두 정의했기때문에, 이 클래스만 있으면 음악 플레이어를 생성해 사용할 수 있다
    }
}
