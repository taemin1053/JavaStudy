package poly.basic;

//캐스팅 주의점 : 다운캐스팅은 잘못하면 심각한 런타임 오류가 발생한다.
public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1;
        child1.childMethod(); //문제 없음

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2; //런타임 오류 ClassCastException
        child2.childMethod(); //실행 불가

    }
}
