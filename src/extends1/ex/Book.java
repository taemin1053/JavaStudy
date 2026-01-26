package extends1.ex;

public class Book extends Item {
    private String author;
    private int pages;
    public Book(String title, int price, String author, int pages) {
        super(title, price);
        this.author = author;
        this.pages = pages;
    }
    @Override
    public void print() {
        super.print();
        System.out.println("저자" + author + "페이지 : " + pages);
    }

}
