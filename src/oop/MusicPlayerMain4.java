package oop;

public class MusicPlayerMain4 {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.on();
        musicPlayer.volumeUp();
        musicPlayer.volumeUp();
        musicPlayer.volumeDown();
        musicPlayer.showStatus();
        musicPlayer.off();
    }
    //이렇게 속성과 기능을 하나로 묶어서 필요한 기능을 메서드를 통해 외부에 제공하는 것 -> 캡슐화
}
