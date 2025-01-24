package Model;

import Controller.RentalController;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Customer extends User {
    private List<String> addresses;
    private Keranjang keranjang;

    public Customer(String username, String password, String noHp, String alamat) {
        super(username, password, noHp, alamat);
        this.addresses = new ArrayList<>();
        this.keranjang = new Keranjang();
    }

    public boolean requestRentalByName(RentalController controller, String productName, String startDate, String endDate, String deliveryMethod, String paymentMethod, int rentalDuration, String noHp, String alamat) {
        List<Product> selectedProducts = keranjang.getItems().stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .collect(Collectors.toList());

        if (selectedProducts.isEmpty()) {
            System.out.println("No products found in cart with the name: " + productName);
            return false;
        }

        String rentalName = productName + " Rental";
        Rental rental = new Rental(rentalName, this, selectedProducts, startDate, endDate, deliveryMethod, paymentMethod, rentalDuration, noHp, alamat);
        controller.getRentalList().add(rental);
        return true;
    }

    public void returnRental(RentalController controller, String rentalName, int daysLate) {
        Optional<Rental> rentalOpt = controller.getRentalList().stream()
                .filter(r -> rentalName.equalsIgnoreCase(r.getName()))
                .findFirst();

        if (rentalOpt.isPresent()) {
            Rental rental = rentalOpt.get();
            int fine = 0;

            if (daysLate > 0) {
                fine = daysLate * 10000;
                System.out.println("You are returning the rental late. Fine: " + fine);
            } else {
                System.out.println("Rental returned on time. No fine.");
            }

            controller.getRentalList().remove(rental);
            System.out.println("Rental " + rental.getName() + " has been returned successfully.");
        } else {
            System.out.println("Rental not found! Please check the rental name.");
        }
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public boolean login(String username, String password) {
        return this.getUsername().equals(username) && this.password.equals(password);
    }
}