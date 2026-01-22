package final1;

public class Constant {
    //상수: static final 키워드 사용, 상수는 변하지 않고, 항상 일정한 값을 갖는 수
    //대문자를 사용하고 구분은 _(언더스코어)를 사용한다.

    //숫자 상수
    public static final double PI = 3.14;
    //시간 상수
    public static final int HOURS_IN_DAY = 24;
    public static final int MINUTES_IN_HOUR = 60;
    public static final int SECONDS_IN_MINUTE = 60;
    //애플리케이션 설정 상수
    public static final int MAX_USERS = 1000;
}
//보통 이런 상수들은 애플리케이션 전반에서 사용되기 때문에 public를 자주 사용한다. 물론 특정 위치에서만 사용된다면 다른 접근 제어자를 사용하면  된다.
//상수는 중앙에서 값을 하나로 관리 할 수 있다, 중앙에서 값을 하나로 관리할 수 있다는 장점이 있다.
//상수는 런타임에 변경할 수 없다.
