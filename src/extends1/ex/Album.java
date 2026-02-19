package extends1.ex;

public class Album extends Item {
    private String author;
    public Album (String title, int price, String author){
        super(title, price);
        this.author = author;
    }
    @Override
    public void print() {
        super.print();
        System.out.println("아티스트: " + author);
    }
}
