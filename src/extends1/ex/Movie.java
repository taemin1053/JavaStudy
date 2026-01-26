package extends1.ex;

public class Movie extends Item{
    private String Director;
    private String author;
    public Movie(String title, int price , String Director, String author) {
        super(title, price);
        this.Director = Director;
        this.author = author;
    }
    @Override
    public void print() {
        super.print();
        System.out.println("감독: " + Director + "배우 : " + author);
    }
}
