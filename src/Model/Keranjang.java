package Model;
import java.util.ArrayList;
import java.util.List;

public class Keranjang {
    private List<Product> items;

    public Keranjang() {
        this.items = new ArrayList<>();
    }

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void viewKeranjang() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (Product product : items) {
                System.out.println(product);
            }
        }
    }

    public void clearCart() {
        items.clear();
        System.out.println("Your cart has been cleared.");
    }
}