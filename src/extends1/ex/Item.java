package extends1.ex;

public class Item {
    private String title;
    private int price;
    public Item(String title, int price) {
        this.title = title;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    public void print(){
        System.out.println("이름: " + title + " , 가격: " + price);
    }
}
