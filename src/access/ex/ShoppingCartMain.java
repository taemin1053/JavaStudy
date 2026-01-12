package access.ex;

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);

        shoppingCart.AddItem(item1);
        shoppingCart.AddItem(item2);

        shoppingCart.displayItems();
    }
}
