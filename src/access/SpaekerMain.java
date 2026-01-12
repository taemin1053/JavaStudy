package access;

public class SpaekerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();

        speaker.volumeUp();

        speaker.volumeDown();
        speaker.showVolume();

        System.out.println(" volume 필드 직접 접근 수정");
        //speaker.volume = 200;
        speaker.showVolume();
        //volumeUp()과 같은 메서드를 만들어서 음량이 100을 넘지 못하도록 기능을 개발했지만 소용이 없다.
        //Speaker를 사용하는 입장에서 volume 필드에 직접 접근해서 원하는 값을 설정할 수 있기 때문이다.
        //따라서 volume필드를 Speaker 클래스 외부에서 접근하지 못하게 private를 사용
    }
}
