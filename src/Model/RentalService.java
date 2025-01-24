package Model;
import java.util.List;

public class RentalService {
    private Keranjang keranjang;

    public RentalService(Keranjang keranjang) {
        this.keranjang = keranjang;
    }

    public void approve(Rental rental) {
        List<Product> selectedProducts = rental.getSelectedProducts();
        for (Product product : selectedProducts) {
            if (!keranjang.getItems().contains(product)) {
                System.out.println("Cannot approve rental. Product " + product.getName() + " is not in the cart.");
                return;
            }
        }
        rental.approve();
        System.out.println("Rental approved: " + rental.getName());
    }

    public void reject(Rental rental) {
        rental.reject();
        System.out.println("Rental rejected: " + rental.getName());
    }
}