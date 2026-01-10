package construct.ex;

public class BookMain {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.bookInfo();
        Book book2 = new Book("hello java", "seo");
        book2.bookInfo();
        Book book3 = new Book("Java progranming","kim", 700);
        book3.bookInfo();
    }
}
