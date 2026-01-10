package construct.ex;

public class Book {
    String title;
    String author;
    int page;

    //기본 생성자
    Book() {
        this(" "," ", 0);
    }
    //매개변수 2개 일때 작동
    Book(String title, String author){
        this(title, author, 0);
    }
    //매개 변수 3개 일때 작동
    Book(String title, String author, int page){
        this.title = title;
        this.author = author;
        this.page = page;
    }
    void bookInfo() {
        System.out.println("제목: " + title + " 저자: "+author + " 페이지 " + page);
    }
}
