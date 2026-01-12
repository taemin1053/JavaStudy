package access.ex;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public void AddItem(Item item) {
        if(itemCount >= items.length){
            System.out.println("장바구니가 가득 찼습니다.");
            return;

        }
        else {
            items[itemCount] = item;
            itemCount++;
        }
    }
    public void displayItems() {

        System.out.println("장바구니 상품 출력");
        for(int i = 0; i < itemCount; i++) {
            System.out.println("상품명: "+items[i].getName() + "합계: "+items[i].getPrice());

        }
        System.out.println("전체 가격 합: " + totalPrice());
    }
    private int totalPrice() {
        int totalPrice = 0;
        for(int i = 0; i < itemCount; i++) {
            totalPrice += items[i].getPrice();
        }
        return totalPrice;
    }

}
