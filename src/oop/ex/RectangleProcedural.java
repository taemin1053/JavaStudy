package oop.ex;

public class RectangleProcedural {
    int width;
    int height;

    int calculateArea() {
        return width * height;
    }
    int calculatePerimeter() {
        return 2 * (width + height);
    }
    void isSquare(){
        if(this.width == this.height){
            System.out.println("정사각형 입니다.");
        }
        else {
            System.out.println("정사각형이 아닙니다.");
        }
    }
}
